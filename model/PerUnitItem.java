/**
 * Klassen representerar en produkt som inte ska vara en tårta.
 * Denna klass ärver från Produkt 
 *
 * @author Elliot Collins
 * @author Nelly Sajland
 */
package model;

public class PerUnitItem extends Product {

    /**
     * Defaultkonstruktör för PerUnitItem.
     * Konstruktören sätter default värden för attribut som finns.
     */
    public PerUnitItem() {
        super();
        setPrice(super.getPrice());
    }

    /**
     * Konstruktör som tar emot input och sätter värden för de olika attribut.
     *
     * @param price priset på varan.
     * @param name namnet på varan.
     */
    public PerUnitItem(int price, String name) {
        super(name);
        setPrice(price);
    }

    /**
     * Denna metod ska implementera det som behövs för att kunna retunera rätt pris 
     * för producten.
     * @return Priset av varje PerUnitItem 
     */
    @Override
    public int calculatePrice() {
        return this.getPrice();
    }

    /**
     * Skapar en sträng av perUnitItem för att sen kunna visa i GUI.
     *
     * @return en sträng av alla attribute av PerUnitItem.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
