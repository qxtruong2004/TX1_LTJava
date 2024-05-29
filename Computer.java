package KtraTX1;

import java.util.Scanner;

public class Computer extends Product {
    private String color;
    private String material;
    private String style;
    Scanner sn = new Scanner(System.in);
    public Computer() {
    }

    public Computer(int product_id, String product_name, double product_price, int product_total, String color, String material, String style) {
        super(product_id, product_name, product_price, product_total);
        this.color = color;
        this.material = material;
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    @Override
    public void Input(){
        super.Input();
        System.out.println("Color: ");
        this.color = sn.nextLine();
        System.out.println("Material: ");
        this.material = sn.nextLine();
        System.out.println("Style: ");
        this.style = sn.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + "Computer{" +  " color= '" + color +"', material= '" + material + "', style= '" + style + '}';
    }
}
