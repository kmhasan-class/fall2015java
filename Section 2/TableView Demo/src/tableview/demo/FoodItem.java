/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview.demo;

/**
 *
 * @author kmhasan
 */
public class FoodItem {
    private int itemCode;
    private String itemName;
    private String category;
    private String description;
    private double price;

    public FoodItem(int itemCode, String itemName, String category, String description, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public int getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FoodItem{" + "itemCode=" + itemCode + ", itemName=" + itemName + ", category=" + category + ", description=" + description + ", price=" + price + '}';
    }
}
