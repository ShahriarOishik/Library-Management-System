package com.example.librarymanagementsystem;
import java.io.*;
import java.util.ArrayList;

public class ReadNWrite {
    public static <E> void WriteDB(ArrayList<E> list, String fileDir) {
        try (FileOutputStream fileOut = new FileOutputStream(fileDir);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
             out.writeObject(list);
            System.out.println("Data saved in " + fileDir + " Database");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static <E> ArrayList<E> ReadDB(String fileDir) {
        ArrayList<E> list = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(fileDir);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            list= (ArrayList<E>) in.readObject();

            System.out.println("Data Loaded from " + fileDir + " Database");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Found while reading in " + fileDir);
            System.out.println(e.getMessage());
        }
        return list;
    }
}
