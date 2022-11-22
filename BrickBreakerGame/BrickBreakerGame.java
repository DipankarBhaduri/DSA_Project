package BrickBreakerGame;

import javax.swing.JFrame;

public class BrickBreakerGame {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        GamePlay gameplay = new GamePlay();
        obj.setSize(700, 600);
        obj.setTitle("Brick_Breaker_Game with MSI");
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
}