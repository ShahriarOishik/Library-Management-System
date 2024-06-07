package com.example.librarymanagementsystem;
import java.io.*;
import java.util.ArrayList;

public class ReadNWrite {
    public static <E> void WriteDB(ArrayList<E> list, String fileDir) {
        try (FileOutputStream fileOut = new FileOutputStream(fileDir);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
             out.writeObject(list);
            System.out.println("Serialized data saved in " + fileDir);
        } catch (IOException e) {
            System.out.println("Error found while writing to " + fileDir);
            e.printStackTrace();
        }
    }

    public static <E> ArrayList<E> ReadDB(String fileDir) {
        ArrayList<E> list = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(fileDir);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            list= (ArrayList<E>) in.readObject();

            System.out.println("DeSerialized data from " + fileDir + " file");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Found while reading in " + fileDir);
            e.printStackTrace();
        }
        return list;
    }
    // Serialize an object to a file
    public static void serializeLibrary(Library library, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(library);
            System.out.println("Serialized library saved in " + filePath);
        } catch (IOException e) {
            System.out.println("Error while writing to " + filePath);
            e.printStackTrace();
        }
    }

    // Deserialize the Library object from a file
    public static Library deserializeLibrary(String filePath) {
        Library library = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            library = (Library) in.readObject();
            System.out.println("Deserialized library from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading from " + filePath);
            e.printStackTrace();
        }
        return library;
    }
}
