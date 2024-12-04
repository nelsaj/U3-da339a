package model;

public enum Filling {
    Vanilla(30), Choclate(40), Strawberry(50), Coconut(60), MixedBerries(70), Unknown(0);
    private int price;
    Filling(int price){
        this.price = price;
    }
    public int getFillingPrice() {return price;}
}
