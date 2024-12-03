package model;

public enum Filling {
    Vanilla(30), Choclate(40), Strawberry(50), Coconut(60), MixedBerries(70), Unknown(0);
    int price;
    Filling(int price){
        this.price = price;
    }
}
