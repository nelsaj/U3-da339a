package model;
/**
 * Enumen Filling är för att beskriva de olika fyllningar en tårta kan ha.
 *
 * @author Elliot Collins
 * @author Nelly Sajland
 */
public enum Filling {
    Vanilla(30), Choclate(40), Strawberry(50), Coconut(60), MixedBerries(70), Unknown(0);
    private int price;
    /**
     * Enum konstruktör som initialiserar pris attributet för en viss Enum literal.
     * @param price
     */
    Filling(int price){
        this.price = price;
    }
    public int getFillingPrice() {return price;}
}
