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

    @Override
    public int calculatePrice() {
        return this.getPrice();
    }

    /**
     * Returnerar en strängrepresentation av PerUnitItem-objektet.
     * Delegerar till basklassens toString-metod.
     *
     * @return en strängrepresentation av PerUnitItem.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
