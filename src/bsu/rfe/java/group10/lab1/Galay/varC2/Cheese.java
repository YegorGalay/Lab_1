package bsu.rfe.java.group10.lab1.Galay.varC2;

public class Cheese extends Food{
    public Cheese(){
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }



    @Override
    public int calculateCalories() {
        return 300;
    }
}