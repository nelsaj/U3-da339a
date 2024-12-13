/**
 * Klassen Cake är en class som ärver från Classen Product men med storlek och fyllningar som enskilda attribute.
 * Det finns klass spesifika metoder för att beräkna priset på tårtan och hämta dess data.
 *
 * @author Elliot Collins
 * @author Nelly Sajland
 */
package model;

public class Cake extends Product {
    private Filling[] fillings;
    private int size;

    /**
     * konstruktorn som initialiserar ett Cake-objekt med standardvärden.
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public Cake() {
        super(); 
        this.setFillings(new Filling[2]);
        this.setSize(this.size);
    }

    /**
     * Konstruktor för att initialisera ett Cake-objekt med specifika fyllningar,storlek och namn.
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
     * Hämtar tårtans storlek.
     * @return tårtans storlek
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public int getSize() {
        return size;
    }

    /**
     * Hämtar tårtans fyllningar.
     * @return en array av Fillings
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public Filling[] getFillings() {
        return fillings;
    }

    /**
     * Sätter tårtans fyllningar.
     * @param fillings en array av Fillings
    
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public void setFillings(Filling[] fillings) {
        this.fillings = fillings;
    }

    /**
     * Sätter tårtans storlek.
     * @param size storleken att sätta för tårtan
     * 
     * @author Elliot Collins
     * @author Nelly Sajland
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returnerar en text av cakes olika attribute som ska användas för listan av orders.
     * @return en sträng som beskriver en cake
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
     * @return det beräknade priset på tårtan
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
