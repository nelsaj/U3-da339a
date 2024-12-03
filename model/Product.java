package model;

public abstract class Product {
    private String name; 
    
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
        return name;
    }
    
    abstract int calculatePrice();


}
