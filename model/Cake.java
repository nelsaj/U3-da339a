package model;

public class Cake extends Product{
    private Filling[] fillings;
    private int size;
    

    // default values
    //TODO: felhantering för värden i setters
    public Cake(){
        super(); 
        this.setFillings(new Filling[2]);
        this.setSize(this.size);
    }

    //TODO: felhantering för värden i setters
    public Cake(Filling[] fillings, int size, String name){
       super.setName(name);
       this.setFillings(fillings);
       this.setSize(size);
       this.setPrice(calculatePrice());
    }

    public int getSize() {
        return size;
    }

    public Filling[] getFillings() {
        return fillings;
    }

    public void setFillings(Filling[] fillings) {
        this.fillings = fillings;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString(){
        String cakeText = super.toString() + " Size: " + this.size + " Fillings: "; 
        for (int i = 0; i < fillings.length; i++) {
            cakeText += fillings[i] + ", ";    
        } 

        return cakeText;
    }

    @Override  
    public int calculatePrice(){
        int price = 0;
        for (int i = 0; i < fillings.length; i++) {
            price += fillings[i].getFillingPrice();
        }
        price *= size; 
        setPrice(price);
        return price;
    }
}
