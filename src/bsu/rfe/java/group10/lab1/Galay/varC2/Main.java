package bsu.rfe.java.group10.lab1.Galay.varC2;

import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do u want to sort? (y/n) ");
        String sorted = scanner.nextLine();

        System.out.print("Do u want to calculate calories? (y/n) ");
        String calories = scanner.nextLine();

        ArrayList<Food> breakfast = new ArrayList<Food>();
        FillArrayList(breakfast);
        PrintArrayList(breakfast);

        if (sorted.equals("y")) {
            SortArrayList(breakfast);
            System.out.println("Sorted breakfast");
            PrintArrayList(breakfast);
        }

        Consume(breakfast);

        if (calories.equals("y"))
            System.out.println("U ate " + CalculateCalories(breakfast) + " calories");
    }

    private static void Consume(ArrayList<Food> breakfast) {
        if (breakfast == null)
            return;
        for (Food el:breakfast)
            el.consume();
    }

    public static void FillArrayList(ArrayList<Food> breakfast) throws Exception{
        String answer;
        do {
            System.out.print("Select food from the list\n" +
                    "_________________________\n" +
                    "1)Apple\n" +
                    "2)Cheese\n" +
                    "3)Cocktail:\n" +
                    "Drink(Milk, Sprite, Water) with Fruit(Banana, Kiwi, Watermelon) ");
            String food = scanner.nextLine();

            if (food.equals("Apple"))
                breakfast.add(new Apple());
            else if (food.equals("Cheese"))
                breakfast.add(new Cheese());
            else if (food.equals("Cocktail")){
                System.out.print("Enter drink: ");
                String drink = scanner.nextLine();
                if (!(drink.equals("Milk") || drink.equals("Sprite")||drink.equals("Water")))
                    throw new ClassNotFoundException("There is no such drink");
                System.out.print("Enter fruit: ");
                String fruit = scanner.nextLine();
                if (!(fruit.equals("Banana")||fruit.equals("Kiwi") || fruit.equals("Watermelon")))
                    throw new ClassNotFoundException("There is no such fruit");
                breakfast.add(new Cocktail(drink,fruit));
            }
            else throw new ClassNotFoundException("There is no such variant!");

            System.out.print("Do u want more? (y/n) ");
            answer = scanner.nextLine();
        } while(answer.equals("y"));
    }

    public static void PrintArrayList(final ArrayList<Food> breakfast) throws ClassNotFoundException, NoSuchFieldException {
        if (breakfast == null)
            System.out.println("U are fat, u are not allowed to eat!");
        System.out.println("U want to ate today: ");
        for (Food item : breakfast) {
            Class MyClass = item.getClass();
            System.out.println(MyClass.getSimpleName());

            Field[] fields = MyClass.getDeclaredFields();
            for (Field it : fields){
                System.out.println(it);
            }
            //System.out.print(item.toString() + ", ");
        }
        System.out.println();
    }

    public static void SortArrayList(ArrayList<Food> breakfast){
        Collections.sort(breakfast,
                (f1, f2) -> {
                    if(f1==null) return 1;
                    if(f2==null) return -1;
                    if(((Food)f1).calculateCalories()==((Food)f2).calculateCalories()) return 0;
                    if(((Food)f1).calculateCalories()>((Food)f2).calculateCalories()) return -1;
                    return 1;
                });
    }

    public static int CalculateCalories(ArrayList<Food> breakfast){
        if (breakfast == null)
            return 0;
        int calories = 0;
        for (Food el : breakfast)
            calories += el.calculateCalories();
        return calories;
    }
}
