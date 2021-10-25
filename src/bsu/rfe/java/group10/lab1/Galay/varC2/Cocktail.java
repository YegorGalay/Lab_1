package bsu.rfe.java.group10.lab1.Galay.varC2;

public class Cocktail extends Food {

    private final String drink;
    private final String fruit;

    @Override
    public void consume() {
        System.out.println(this + " выпит");
    }

    public Cocktail (String drink, String fruit) {
        super("Коктейль");
        this.drink = drink;
        this.fruit = fruit;
    }

    public String getDrink()
    {
        return drink;
    }

    public String getFruit()
    {
        return fruit;
    }

    @Override
    public int calculateCalories() {
        int calories = 0;
        switch (drink) {
            case "молоко" -> calories += 40;
            case "вода" -> calories += 1;
            case "спрайт" -> calories += 500;
        }
        switch (fruit) {
            case "апельсин" -> calories += 33;
            case "банан" -> calories += 28;
            case "киви" -> calories += 50;
            default -> calories += 10;
        }
        return calories;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Cocktail)) return false;
        return (drink.equals(((Cocktail) obj).drink) && (fruit.equals(((Cocktail) obj).fruit)));
    }

    public String toString() {
        return super.toString() + " c добавкой '" + drink.toUpperCase() + "'" + " и '" + fruit.toUpperCase() + "'";
    }
}