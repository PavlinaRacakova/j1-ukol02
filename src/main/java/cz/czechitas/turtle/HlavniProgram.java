package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    private Turtle turtle = new Turtle();
    private final Color SNOWMAN_BLUE = new Color (51, 153, 255);
    private final Color CONE_BROWN = new Color (102, 51, 0);

    public void start() {
        //drawVanillaIceCream();

        turtle.setLocation(500,200);
        drawCircle(100, SNOWMAN_BLUE);
        turtle.setLocation(turtle.getX() + 40, turtle.getY() + 50);
        turtle.turnRight(90);
        drawCircle(130, SNOWMAN_BLUE);
        turtle.setLocation(turtle.getX() + 95, turtle.getY() + 45);
        drawSnowmansHand();
        turtle.setLocation(turtle.getX() - 175, turtle.getY());
        drawSnowmansHand();

    }

    public void drawEquilateralTriangle(double size, Color color) {
        turtle.setPenColor(color);
        for (int i = 0; i < 3; i++) {
            turtle.move(size);
            turtle.turnRight(120);
        }
    }

    public void drawIsoscelesTriangle(double size, Color color) {
        turtle.setPenColor(color);
        double sizeOfLongestSide = Math.sqrt(2 * Math.pow((double) size, 2));
        turtle.move(size);
        turtle.turnLeft(135);
        turtle.move(sizeOfLongestSide);
        turtle.turnLeft(135);
        turtle.move(size);
    }

    public void drawRectangle(double sizeOfShorterSide, double sizeOfLongerSide, Color color) {
        turtle.setPenColor(color);
        for (int i = 0; i < 2; i++) {
            turtle.move(sizeOfShorterSide);
            turtle.turnRight(90);
            turtle.move(sizeOfLongerSide);
            turtle.turnRight(90);
        }
    }

    public void drawSquare(double size, Color color) {
        drawRectangle(size, size, color);
    }

    public void drawCircle(double diameter, Color color) {
        turtle.setPenColor(color);
        double perimeter = Math.PI * diameter;
        double movement = perimeter/20;
        for (int i = 0; i < 20; i++) {
            turtle.move(movement);
            turtle.turnRight(18);
        }
    }

    private void drawVanillaIceCream() {
        turtle.setLocation(200,200);
        drawCircle(190, Color.YELLOW);
        turtle.setLocation(turtle.getX() + 5, turtle.getY()+20);
        turtle.turnRight(90);
        drawEquilateralTriangle(180, CONE_BROWN);
    }

    private void drawSnowman() {

    }

    private void drawSnowmansHand(){
        drawCircle(40, SNOWMAN_BLUE);
    }

    public static void main(String[] args) {
        new HlavniProgram().start();
    }
}
