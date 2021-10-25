package bsu.rfe.java.group10.lab1.Galay.varC2;


class Cocktail extends Food{
    private String _drink = null;
    private String _fruit = null;

    public Cocktail (String drink, String fruit) {
        super("Cocktail", 200);
        _drink = drink;
        _fruit = fruit;
    }

    public String get_drink() {
        return _drink;
    }
    private void set_drink(String drink) { _drink = drink; }

    public String get_fruit() {
        return _fruit;
    }
    private void set_fruit(String fruit) { _fruit = fruit; }

    @Override
    public void consume() {
        System.out.println(get_name() + " eaten! :)");
    }

    @Override
    public int calculateCalories() {
        if (get_drink().equals("Milk"))
            set_calories(get_calories() + 42);
        else if (get_drink().equals("Sprite"))
            set_calories(get_calories() + 400);
        else if (get_drink().equals("Water"))
            set_calories(get_calories() + 1);
        if (get_fruit().equals("Banana"))
            set_calories(get_calories() + 90);
        else if (get_fruit().equals("Kiwi"))
            set_calories(get_calories() + 61);
        else if (get_fruit().equals("Watermelon"))
            set_calories(get_calories() + 30);
        return get_calories();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Cocktail)) return false;
        return (_drink.equals(((Cocktail) obj)._drink) && (_fruit.equals(((Cocktail) obj)._fruit)));
    }

    @Override
    public String toString(){
        return super.toString() + " with " + get_drink() + " and " + get_fruit();
    }
}
