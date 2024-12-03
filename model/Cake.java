package model;

public class Cake extends Product{
    private Filling filling;
    private int size;

    // default values
    //TODO: felhantering för värden i setters
    public Cake(){
        super(); 
        this.setFilling(Filling.Unknown);
        this.setSize(this.size);
    }

    //TODO: felhantering för värden i setters
    public Cake(Filling filling, int size, String name){
       super.setName(name);
       this.setFilling(filling);
       this.setSize(size);
    }

    public int getSize() {
        return size;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return super.toString() + this.size + this.filling; 
    }

    @Override  //TODO: fixa denna 
    public int calculatePrice(){
        return 1;
    }
}
