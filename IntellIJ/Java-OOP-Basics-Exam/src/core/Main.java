package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //Core objects created
        System system = new System();
        CommandHandler handler = new CommandHandler(system);

        //Create the input reader object
        BufferedReader reader = new BufferedReader(new InputStreamReader(java.lang.System.in));

        String input;

        while (!(input = reader.readLine()).equals("System Split")) {
            handler.handleCommand(input);
        }

        java.lang.System.out.println(handler.systemSplit());
    }
}
