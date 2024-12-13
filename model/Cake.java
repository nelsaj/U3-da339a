/**
 * Klassen Cake ärver från klassen Produkt och är en representation av tårta 
 * man ska kunna köpa.
 *
 * @author Elliot Collins
 * @author Nelly Sajland
 */
package model;

public class Cake extends Product {
    private Filling[] fillings;
    private int size;

    /**
     * konstruktorn som sätter default värden.
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public Cake() {
        super(); 
        this.setFillings(new Filling[2]);
        this.setSize(this.size);
    }

    /**
     * Konstruktör som tar emot input och sätter värden för de olika attribut.
     *
     * @param fillings en array av Fillings
     * @param size tårtans storlek
     * @param name tårtans namn
     *
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public Cake(Filling[] fillings, int size, String name) {
        super.setName(name);
        this.setFillings(fillings);
        this.setSize(size);
        this.setPrice(calculatePrice());
    }

    /**
     * Getter för tårtans storlek.
     * @return tårtans storlek
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter för tårtans fyllningar.
     * @return en array av Fillings
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public Filling[] getFillings() {
        return fillings;
    }

    /**
     * Setter för tårtans fyllningar.
     * @param fillings en array av Fillings
    
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public void setFillings(Filling[] fillings) {
        this.fillings = fillings;
    }

    /**
     * Setter för tårtans storlek.
     * @param size storleken att sätta för tårtan
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returnerar en sträng av cakes olika attribute som ska användas sednan för listan av orders.
     * @return En sträng som beskriver en cake.
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    @Override
    public String toString() {
        String cakeText = super.toString() + " Storlek: " + this.size + " Fyllningar: "; 
        for (int i = 0; i < fillings.length; i++) {
            cakeText += fillings[i] + ", ";    
        } 
        return cakeText;
    }

    /**
     * Beräknar priset på tårtan baserat på dess fyllningar och storlek.
     * @return Det beräknade priset på tårtan.
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    @Override  
    public int calculatePrice() {
        int price = 0;
        for (int i = 0; i < fillings.length; i++) {
            price += fillings[i].getFillingPrice();
        }
        price *= size; 
        setPrice(price);
        return price;
    }
}
