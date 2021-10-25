package bsu.rfe.java.group10.lab1.Galay.varC2;

public class Apple extends Food{
    public Apple(){
        super("Apple", 50);
    }

    @Override
    public void consume() {
        System.out.println(get_name() + " eaten!");
    }

    @Override
    public int calculateCalories() {
        return get_calories();
    }

    @Override
    public String toString(){ return super.toString(); }
}