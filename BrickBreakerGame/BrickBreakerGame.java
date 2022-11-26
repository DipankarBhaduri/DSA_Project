package BrickBreakerGame;

import javax.swing.JFrame;

public class BrickBreakerGame {
    public static void main(String[] args) {
        // Create jFrame
        JFrame obj = new JFrame();

        // Calling game class here
        GamePlay gameplay = new GamePlay();

        // set size of the jframe
        obj.setSize(700, 600);

        // Title of jframe
        obj.setTitle("Brick_Breaker_Game with MSI");

        // its non resizeable
        obj.setResizable(false);

        // Should be visiable
        obj.setVisible(true);

        // When we click on exit it should be closed
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // calling object & passing the gamePlay class
        obj.add(gameplay);
    }
}