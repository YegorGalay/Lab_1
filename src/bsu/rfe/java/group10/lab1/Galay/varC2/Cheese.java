package bsu.rfe.java.group10.lab1.Galay.varC2;

public class Cheese extends Food{
    public Cheese() {
        super("Cheese", 400);
    }

    @Override
    public void consume() {
        System.out.println(get_name() + " eaten! Yummy!");
    }

    @Override
    public int calculateCalories() {
        return get_calories();
    }

    @Override
    public String toString(){ return super.toString(); }}