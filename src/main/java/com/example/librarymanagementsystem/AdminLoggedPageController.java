package com.example.librarymanagementsystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminLoggedPageController {

    @FXML
    private Button AddBook;

    @FXML
    private Button RemoveMember;
    @FXML
    private Button adminLogOut;


    @FXML
    private Button EditMember;

    @FXML
    private Button RemoveBook;

    @FXML
    private ListView<String> ListOfBooks;

    @FXML
    private ListView<String> ListOfMembers;
    @FXML
    private Label ShowEmail;
    @FXML
    private Label ShowAddress;
    @FXML
    private Label ShowPhone;
    @FXML
    private Label ShowID;
    @FXML
    private Label ShowName;


    @FXML
    private TextField addAddress;

    @FXML
    private TextField addAuthor;

    @FXML
    private TextField addBookShelf;

    @FXML
    private TextField addCopies;

    @FXML
    private TextField addEmail;

    @FXML
    private TextField addISBN;

    @FXML
    private TextField addName;

    @FXML
    private TextField addPassword;

    @FXML
    private TextField addPhone;

    @FXML
    private TextField addPublisher;

    @FXML
    private TextField addTitle;
    public static int userIndex;
    private static Library lib;
    ObservableList<String> membersData;

    // Populate ListOfBooks
    ObservableList<String> booksData;

    public static void setLibrary(Library library) {
        lib = library;
    }
    public static void setUserIndex(int UserIndex) {
        userIndex = UserIndex;
    }
    @FXML
    private void initialize() {
        RemoveBook.setOnAction(this::AdminRemoveBook);
        RemoveMember.setOnAction(this::AdminRemoveMember);
        ShowName.setText(lib.admin.get(userIndex).getName());
        ShowPhone.setText(lib.admin.get(userIndex).getPhone());
        ShowAddress.setText(lib.admin.get(userIndex).getAddress());
        ShowID.setText(lib.admin.get(userIndex).getAdminID());
        ShowEmail.setText(lib.admin.get(userIndex).getEmail());
        adminLogOut.setOnAction(this::handleAdminLogOut);
        EditMember.setOnAction(this::AdminMemberEdit);
        AddBook.setOnAction(this::handleAddBook);

        membersData = FXCollections.observableArrayList();
        ListOfMembers.setItems(membersData);

        booksData = FXCollections.observableArrayList();
        ListOfBooks.setItems(booksData);

        ListOfMembers.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ListOfBooks.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        reloadUserList();
        reloadBookList();

    }
    private void handleAdminLogOut(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent newScene = fxmlLoader.load();
            Stage stage = (Stage) adminLogOut.getScene().getWindow();
            stage.setScene(new Scene(newScene));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void AdminRemoveBook(ActionEvent event) {
        int Index = ListOfBooks.getSelectionModel().getSelectedIndex()-1;
        if (Index != -1) {
            String bookName = lib.books.get(Index).getTitle();
            lib.removeBook(bookName);
            LibraryManagementSystem.setLibrary(lib);
            reloadBookList();
        }

    }
    private void handleAddBook(ActionEvent event){
        String title = addTitle.getText();
        String author = addAuthor.getText();
        String isbn = addISBN.getText();
        String bookshelf = addBookShelf.getText();
        String publisher = addPublisher.getText();
        int copies = Integer.parseInt(addCopies.getText());

        Book book = new Book(title, author,isbn,publisher,copies,bookshelf);
        lib.books.add(book);
        LibraryManagementSystem.setLibrary(lib);
        BrowseBookPageController.setLibrary(lib);
        MemberLoggedPageController.setLibrary(lib);

        reloadBookList();

    }

    @FXML
    private void AdminAddBookInterface(ActionEvent event) {

    }

    @FXML
    void AdminRemoveMember(ActionEvent event) {
            int Index = ListOfMembers.getSelectionModel().getSelectedIndex()-1;
            if (Index != -1) {
                String MemberName = lib.members.get(Index).getName();
                lib.removeUser(MemberName);
                LibraryManagementSystem.setLibrary(lib);
                reloadUserList();
            }
    }

    @FXML
    void AdminMemberEdit(ActionEvent event) {
        String username = addName.getText();
        String password = addPassword.getText();
        String address = addAddress.getText();
        String phone = addPhone.getText();
        String email = addEmail.getText();
        int Index = ListOfMembers.getSelectionModel().getSelectedIndex()-1;

        if ( username != null && !username.isEmpty()) {
            if (Index != -1) {
                lib.members.get(Index).setName(username);
            }
        }
        if (password != null && !password.isEmpty()){
            if (Index != -1) {
                lib.members.get(Index).setPassword(password);
            }
        }
        if ( address != null && !address.isEmpty()) {
            if (Index != -1) {
                lib.members.get(Index).setAddress(address);
            }
        }
        if (email != null && !email.isEmpty()){
            if (Index != -1) {
                lib.members.get(Index).setEmail(email);
            }
        }
        if (phone != null && !phone.isEmpty()){
            if (Index != -1) {
                lib.members.get(Index).setPhone(phone);
            }
        }
        LibraryManagementSystem.setLibrary(lib);
        reloadUserList();
    }
    private void reloadBookList() {
        booksData.clear();
        booksData.add("Title" + "\t\t\t" + "Author" + "\t\t\t"+ "Shelf" + "\t\t\t" + "ISBN" + "\t\t\t" + "publisher" + "\t\t\t" + "availableCopies");
        for (Book book : lib.books) {
            booksData.add(book.toString());
        }
    }
    private void reloadUserList() {
        membersData.clear();
        membersData.add("Name" + "\t\t\t" + "Password" + "\t\t\t" + "Address" + "\t\t\t" + "Phone" + "\t\t\t" + "Email");
        for (Member member : lib.members) {
            membersData.add(member.toString());
        }
    }
    private boolean isAddBookInputValid(String title, String author, String isbn, String bookshelf, String publisher, int copies) {
        return title != null && !title.isEmpty()
                && author!=null && !author.isEmpty()
                && isbn!= null && !isbn.isEmpty()
                && bookshelf != null && !bookshelf.isEmpty()
                && publisher!= null && !publisher.isEmpty()
                && copies<0;
    }

}

