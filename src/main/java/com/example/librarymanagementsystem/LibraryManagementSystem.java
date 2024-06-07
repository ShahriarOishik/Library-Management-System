package com.example.librarymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryManagementSystem extends Application {
    public static Library library;
    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/Bebas-Regular.ttf"), 16);
        Image icon = new Image(getClass().getResourceAsStream("/icons/app-icon.jpg"));
        HomePageController.setLibrary(library);
        LoginPageController.setLibrary(library);
        AdminLoginPageController.setLibrary(library);
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryManagementSystem.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(icon);
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {e.consume();UpdateLibrary();stage.close();});
    }

    public static void main(String[] args) {
        LoadLibrary();
        setAllLibrary(library);
        UpdateLibrary();
        setLibrary(library);
        launch();
    }
    public static void setLibrary(Library lib) {

        library = lib;
    }
    public static void setAllLibrary(Library lib) {

        library = lib;
        HomePageController.setLibrary(lib);
        AdminLoggedPageController.setLibrary(lib);
        AdminLoginPageController.setLibrary(lib);
        BrowseBookPageController.setLibrary(lib);
        HomePageController.setLibrary(lib);
        LoginPageController.setLibrary(lib);
        MemberLoggedPageController.setLibrary(lib);
    }
    public static void saveLibrary(){
        ReadNWrite.WriteDB(library.admin,"AdminDB.ser");
        ReadNWrite.WriteDB(library.books,"BookDB.ser");
        ReadNWrite.WriteDB(library.members,"MemberDB.ser");
    }
    public static void LoadLibrary(){
        ArrayList<Book> BookDB = ReadNWrite.ReadDB("BookDB.ser");
        ArrayList<Member> MemberDB = ReadNWrite.ReadDB("MemberDB.ser");
        ArrayList<Admin> AdminDB = ReadNWrite.ReadDB("AdminDB.ser");
        Library lib = new Library("Adorsho Library", BookDB, MemberDB, AdminDB);
        setLibrary(lib);
    }
    public static void UpdateLibrary(){
        saveLibrary();
        LoadLibrary();
    }
    public static void  signUp(String username,String password,String address,String phone,String email){
        Member newMember = new Member(username, password, address, phone, email);
        library.members.add(newMember);
        UpdateLibrary();
    }
  }


