package BrickBreakerGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
    // Using matrix creating the map :
    public int map[][];

    // for brickWidth :
    public int bricksWidth;

    // for the brick height :
    public int bricksHeight;

    // Created Constractor of MapGenerator :
    public MapGenerator(int row, int col) {

        // initilization of Row and Column as well
        map = new int[row][col];

        // forLoop for initilization the value 1 to every index
        for (int[] map1 : map) {
            for (int j = 0; j < map[0].length; j++) {
                map1[j] = 1;
            }
        }

        // specify the brickWidth
        bricksWidth = 540 / col;

        // specify the brickHeight
        bricksHeight = 150 / row;
    }

    // Graphics 2D as a parameter
    public void draw(Graphics2D g) {
        // as it is a matrix so using 2 loops to access the all element
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {

                    // set the colour red
                    g.setColor(Color.red);

                    // fill the block using height and width
                    g.fillRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);

                    // set the basic stroke to maintain gap between two brick
                    g.setStroke(new BasicStroke(3));

                    // giving the colour to the gap also
                    g.setColor(Color.black);

                    // to fill the stroke draw is created
                    g.drawRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);
                }
            }
        }
    }

    public void setBricksValue(int value, int row, int col) {
        map[row][col] = value;
    }
}