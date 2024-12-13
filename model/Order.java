package model;

/**
 * Klass som representerar en beställning. 
 * Klassen består av ett unikt ID, ett pris och en Product array över valda produkter.
 * 
 * @author Nelly Sajland & Elliot Collins
 */
public class Order {
    
    private int id;
    private int totalPrice;
    private Product[] purchases;

    /**
     * Konstruktor som initierar med defualtvärden. 
     * ID 0, totalpris 0, inköp tom array.
     */
    public Order(){
        setId(this.id);
        setPurchases(new Product[0]);
        setTotalPrice(0);
    }

    /**
     * Konstruktor som skapar en beställning med ett specifikt ID, annars samma defaultvärden. 
     * 
     * @param id id:et för beställningen
     */
    public Order(int id){
        setId(id);
        setPurchases(new Product[0]);
        setTotalPrice(0);
    }

    /**
     * Sätter id:et för beställningen.
     * 
     * @param id det nya id:et för beställningen
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sätter totalpriset för beställningen.
     * 
     * @param totalPrice det nya priset för beställningen
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Sätter inköp i beställningen.
     * 
     * @param purchases en array av produkter som ingår i beställningen
     */
    public void setPurchases(Product[] purchases) {
        this.purchases = purchases;
    }

    /**
     * Hämtar id:et för ordern.
     * 
     * @return id:et för ordern
     */
    public int getId() {
        return id;
    }

    /**
     * Hämtar inköp i beställningen.
     * 
     * @return en array av produkter som ingår i beställningen
     */
    public Product[] getPurchases() {
        return purchases;
    }

    /**
     * Hämtar priset för beställningen.
     * 
     * @return priset för beställningen
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Lägger till en produkt i beställningen och uppdaterar priset.
     * Dessutom utökar storleken av purchases så att produkten får plats.
     * 
     * @param product den produkt som ska läggas till i ordern
     */
    public void addProduct(Product product){
        Product[] newPurchasesArr = new Product[purchases.length + 1];
        for (int i = 0; i < purchases.length; i++) {
            newPurchasesArr[i] = purchases[i];
        }
        newPurchasesArr[purchases.length] = product;
        purchases = newPurchasesArr;

        totalPrice += product.getPrice();
    }

    /**
     * Returnerar en text av beställningen.
     *
     * @return en sträng som beskriver beställningen
     */
    public String toString(){
        String purchasesString = "Order " + this.id + " Konstnad: " + this.totalPrice; 
        return purchasesString;
    }
}

