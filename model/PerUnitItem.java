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
    //TODO: fixa denna 
    @Override
    public int calculatePrice(){
        return 0;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
