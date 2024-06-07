package com.example.librarymanagementsystem;
import java.util.List;
import java.util.Date;
import java.util.Random;

public class UserIDGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10000;
    private static Random random = new Random();

    public static String generateUniqueID() {
        long timestamp = System.currentTimeMillis();
        int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
        return "USER-" + timestamp + "-" + randomNumber;
    }
}