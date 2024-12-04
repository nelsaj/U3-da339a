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
        return super.toString() + this.size + this.fillings; 
    }

    @Override  //TODO: fixa denna 
    public int calculatePrice(){
        return 1;
    }
}