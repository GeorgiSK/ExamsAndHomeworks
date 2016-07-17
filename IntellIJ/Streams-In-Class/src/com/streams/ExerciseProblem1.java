package com.streams;

import java.io.*;

public class ExerciseProblem1 {
    private static final String FILE_PATH_USERS = "users.txt";
    private static final String FILE_PATH_TIME_PLAYED = "total-played.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH_USERS);
        File fileWrite = new File(FILE_PATH_TIME_PLAYED);


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int y = 0; y < 3; y++) {
                String s = reader.readLine();
                String[] currentLine = s.split(" ");
                String currentPlayer = currentLine[0];
                int totalMinutes = 0;

                for (int i = 1; i < currentLine.length; i++) {
                    String[] hoursMinutes = currentLine[i].split(":");
                    totalMinutes += (Integer.parseInt(hoursMinutes[0]) * 60) + Integer.parseInt(hoursMinutes[1]);
                }

                int hours = totalMinutes / 60;
                int days = totalMinutes / 1440;
                int minutes = totalMinutes % 60;

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWrite, true))) {
                    writer.write(currentPlayer + " " + totalMinutes + " " + "(" + days + " days, " + hours + " hours, "+ minutes + " minutes" + ")" + "\r\n");
                } catch (Exception ex) {

                }
            }
        } catch (Exception ex) {

        }
    }
}
