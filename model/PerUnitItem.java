package model;

public class PerUnitItem extends Product {
    public PerUnitItem(){
        super();
        setPrice(super.getPrice());
    }

    public PerUnitItem(int price, String name){
        super(name);
        setPrice(price);
    }

    @Override
    public int calculatePrice() {
        return this.getPrice();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
