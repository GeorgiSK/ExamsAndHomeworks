package com.game.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private static final long serialVersionUID = 7533424942916683483L;

    public Window(int width, int height, String title, Game game) {
        //Creating an instance of a frame
        JFrame frame = new JFrame(title);

        frame.setIgnoreRepaint(true);
        //Setting dimensions
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        //This method actually stops the thread after pushing the close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Can't resize
        frame.setResizable(false);
        //To start frame in the middle of the screen
        frame.setLocationRelativeTo(null);
        game.setIgnoreRepaint(true);
        //Adding the game class into the frame
        frame.add(game);
        frame.pack();
        //Making the frame visible
        frame.setVisible(true);
        //Running the start method
        game.start();
    }
}
