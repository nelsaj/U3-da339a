package model;

public class Order {
    private String id;
    private int totalPrice;
    private Product[] purchases;
    
    //Kolla om denna behövs
    public Order(){
        setId(this.id);
        setPurchases(new Product[0]);
        setTotalPrice(0);
    }

    public Order(String id){
        setId(id);
        setPurchases(new Product[0]);
        setTotalPrice(0);
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setPurchases(Product[] purchases) {
        this.purchases = purchases;
    }

    public String getId() {
        return id;
    }

    public Product[] getPurchases() {
        return purchases;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product){
        Product[] newPurchasesArr = new Product[purchases.length + 1];
        for (int i = 0; i < purchases.length; i++) {
            newPurchasesArr[i] = purchases[i];
        }
        newPurchasesArr[purchases.length] = product;
        purchases = newPurchasesArr;
    }

    //TODO: kolla om denna behövs och om den är bra implementera
    public String toString(){
        return "";
    }
}
