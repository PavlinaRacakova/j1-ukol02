package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    private Turtle turtle = new Turtle();
    private final Color SNOWMAN_BLUE = new Color(51, 153, 255);
    private final Color CONE_BROWN = new Color(102, 51, 0);

    public void start() {
        drawVanillaIceCream();
        drawSnowman();
        drawLocomotive();
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
        double sizeOfLongestSide = Math.sqrt(2 * Math.pow(size, 2));
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
        double movement = perimeter / 20;
        for (int i = 0; i < 20; i++) {
            turtle.move(movement);
            turtle.turnRight(18);
        }
    }

    private void drawVanillaIceCream() {
        //ice cream
        turtle.setLocation(200, 200);
        drawCircle(190, Color.YELLOW);
        //cone
        turtle.setLocation(turtle.getX() + 5, turtle.getY() + 20);
        turtle.turnRight(90);
        drawEquilateralTriangle(180, CONE_BROWN);
        turtle.turnLeft(90);
    }

    private void drawSnowman() {
        //variables to determinate the position
        double snowmanMainXLocation = 660;
        double snowmanMainYlocation = 250;
        //head
        turtle.setLocation(snowmanMainXLocation, snowmanMainYlocation);
        turtle.turnRight(90);
        drawCircle(100, SNOWMAN_BLUE);
        //upper body
        turtle.setLocation(snowmanMainXLocation, turtle.getY() + 100);
        drawCircle(130, SNOWMAN_BLUE);
        //arms
        turtle.setLocation(turtle.getX() + 95, turtle.getY() + 45);
        drawSnowmansHand();
        turtle.setLocation(turtle.getX() - 175, turtle.getY());
        drawSnowmansHand();
        //lower body
        turtle.setLocation(snowmanMainXLocation, turtle.getY() + 85);
        drawCircle(250, SNOWMAN_BLUE);
        //nose
        turtle.setLocation(snowmanMainXLocation, snowmanMainYlocation + 40);
        turtle.turnRight(90);
        drawEquilateralTriangle(25, Color.ORANGE);
        turtle.turnRight(180);
    }

    private void drawSnowmansHand() {
        drawCircle(40, SNOWMAN_BLUE);
    }

    private void drawLocomotive() {
        //cab
        turtle.setLocation(1350, 200);
        turtle.turnRight(90);
        drawRectangle(150, 250, Color.RED);
        //wheels
        turtle.setLocation(turtle.getX(), turtle.getY() + 250);
        turtle.turnLeft(90);
        drawCircle(153, Color.BLACK);
        turtle.setLocation(turtle.getX() - 100, turtle.getY() + 5);
        turtle.turnRight(90);
        drawSmallWheel();
        turtle.setLocation(turtle.getX() - 100, turtle.getY());
        drawSmallWheel();
        //front part
        turtle.turnLeft(90);
        turtle.setLocation(turtle.getX() - 50, turtle.getY() - 5);
        drawRectangle(130, 240, Color.RED);
        turtle.setLocation(turtle.getX(), turtle.getY() + 50);
        drawIsoscelesTriangle(140, Color.BLACK);
    }

    private void drawSmallWheel() {
        drawCircle(50, Color.BLACK);
    }

    public static void main(String[] args) {
        new HlavniProgram().start();
    }
}
