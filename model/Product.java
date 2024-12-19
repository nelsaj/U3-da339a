/**
 * Klassen representerar en produkt som är bas klassen för alla andra produkter.
 *
 * @author Elliot Collins
 * @author Nelly Sajland
 */
package model;
public abstract class Product {
    private String name; 
    private int price;
    /**
     * Konstruktör som sätter default värden för name attributet.
     */
    public Product(){
        this.setName(this.name);
    }
     /**
     * Konstruktör som sätter input parametervärdet för name attributet.
     */
    public Product(String name){
        this.setName(name);
    }
     /**
     * Getter för name attributet
     * @return namnet på produkten.
     */
    public String getName() {
        return name;
    }
     /**
     * Setter för name attributet.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Skapar en sträng av alla attribut för en produkt
     * @return En sträng av alla attribut för en produkt
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public String toString(){
        return name + ", Price: " + price;
    }
     /**
     * Setter för price attributet.
     * @param price 
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Getter för price attributet.
     * @return price attributet.
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    public int getPrice() {
        return price;
    }
    /**
     * En abstrakt metod för att kalkylera priset av en produkt som
     * är beronde på olika variabler så varsin klass som ärver Produkt ska implementera.
     * @return priset som har kalkylerats. 
     * 
     * @author Nelly Sajland, Elliot Collins
     */
    abstract int calculatePrice();


}
