// Ryan Barber Assignment 7.2 7/11/26

import javafx.scene.shape.Circle;

public class CircleStyleTest {

    public static void main(String[] args) {

        Circle circle1 = CircleStyleApp.createPlainCircle();
        Circle circle2 = CircleStyleApp.createPlainCircle();
        Circle circle3 = CircleStyleApp.createColoredCircle("redcircle");
        Circle circle4 = CircleStyleApp.createColoredCircle("greencircle");

        System.out.println("Circle 1 style: "
                + circle1.getStyleClass().contains("plaincircle"));

        System.out.println("Circle 2 style: "
                + circle2.getStyleClass().contains("plaincircle"));

        System.out.println("Circle 3 ID: "
                + "redcircle".equals(circle3.getId()));

        System.out.println("Circle 4 ID: "
                + "greencircle".equals(circle4.getId()));

        System.out.println("All circles have radius 30: "
                + (circle1.getRadius() == 30
                && circle2.getRadius() == 30
                && circle3.getRadius() == 30
                && circle4.getRadius() == 30));
    }
}