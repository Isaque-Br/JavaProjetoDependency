package model.entities;

import model.enums.Color;

public class Rectangle extends Shape{

    private Double width;
    private Double height;

    public Rectangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double area() {
        return width * height;
    }

    public Double perimeter() {
        return 2 * (width + height);
    }

    public Double diagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    @Override
    public String toString() {
        return "AREA = " + String.format("%.2f", area()) + "\n"
                + "PERIMETER = " + String.format("%.2f", perimeter()) + "\n"
                + "DIAGONAL = " + String.format("%.2f", diagonal());
    }
}
