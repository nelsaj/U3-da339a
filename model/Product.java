package model;

public abstract class Product {
    private String name; 
    private int price;
    
    public Product(){
        this.setName(this.name);
    }

    public Product(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString(){
        return name + ", Price: " + price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    abstract int calculatePrice();


}
