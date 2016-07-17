package com.streams;

import java.io.*;

public class Files {
    public static void main(String[] args) {
        //Buffered reading
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("text.txt")))) {
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            System.out.println("Program");
        }

        String[] array = new String[] {"Neshto", "Stamat", "asda", "asdadd"};


        try(BufferedWriter writer = new BufferedWriter(new FileWriter("text1.txt"))) {

            for (int i = 0; i < array.length; i++) {
                String s = array[i];
                writer.write(s + " \r\n");
            }
        }catch(Exception ex) {

        }

        try(BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
            String s;

            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }catch(Exception ex) {

        }
    }
}
