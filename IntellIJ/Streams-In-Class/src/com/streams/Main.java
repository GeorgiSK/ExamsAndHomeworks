package com.streams;

import java.io.FileReader;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* try {
            Scanner scanner = new Scanner(System.in);
            int parsedNum = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            int value = Integer.parseInt(str);
            System.out.println(parsedNum);
        }catch (InputMismatchException ime) {
            System.out.println(ime);
        }catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }finally {
            //Allways gets executed
            System.out.println("Finally block");
        }

        //Try with resources
        try(Reader reader = new FileReader("text.txt")) {

        }catch(Exception ex) {

        }*/

        Player gosho = new Player(50, 200);
        Player pesho = new Player(200, 0);


    }
}
