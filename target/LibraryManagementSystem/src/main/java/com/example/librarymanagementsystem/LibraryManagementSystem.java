package com.example.librarymanagementsystem;

import javafx.application.Application;
import java.time.*;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.css.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.lang.ModuleLayer.Controller;

public class LibraryManagementSystem extends Application {
    //Stage Window;
    private static Library library;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryManagementSystem.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        LoadLibrary();
        for(Member m: library.members){
            m.displayInfo();
        }
        launch();
    }
    public static void setLibrary(Library lib) {
        library = lib;
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
        Library lib = new Library("Niggatola Library", BookDB, MemberDB, AdminDB);
        setLibrary(lib);
    }
    public static void UpdateLibrary(){
        saveLibrary();
        LoadLibrary();
    }
    public static void  signUp(String username,String password,String address,String phone,String email){
        Member newMember = new Member(username, password, address, phone, email);
        library.members.add(newMember);
        for(Member m: library.members){
            m.displayInfo();
        }
        UpdateLibrary();
    }
  }


