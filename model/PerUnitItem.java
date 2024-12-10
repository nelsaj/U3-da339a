package model;

public class PerUnitItem extends Product {
    private int price; 
    
    public PerUnitItem(){
        super();
        setPrice(this.price);
    }

    public PerUnitItem(int price, String name){
        super(name);
        setPrice(price);
    }

    public int getPrice() {
        return price;
    }
    //TODO: fixa felhantering
    public void setPrice(int price) {
        this.price = price;
    }

    //TODO: fixa denna 
    @Override
    public int calculatePrice(){
        return 0; 
    }

    @Override
    public String toString(){
        return super.toString() + " Price: " + this.price;
    }
}
