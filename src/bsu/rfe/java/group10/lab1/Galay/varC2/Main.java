package bsu.rfe.java.group10.lab1.Galay.varC2;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;



public class Main {

    public static void main(String[] args)
    {

        Food[] breakfast = new Food[20];
        boolean sort_needed = false;
        boolean calories_needed = false;
        System.out.println("длина массива аргументов: " + args.length);
        int count_breakfast = 0;
        for (String arg : args) {
            if (arg.equals("-calories")) {
                calories_needed = true;
            } else if (arg.equals("-sort")) {
                sort_needed = true;
            } else {
                String[] parts = arg.split("/");
                String[] param = new String[parts.length - 1];
                System.arraycopy(parts, 1, param, 0, parts.length - 1);

               try {
                    Class<?> myClass = Class.forName("bsu.rfe.java.group10.lab1.Galay.var2C" + parts[0]);
                   breakfast[count_breakfast] = (Food) myClass.getConstructor(myClass.getConstructors()[0].getParameterTypes()).newInstance((Object) param);
                    count_breakfast++;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                    System.out.print(ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Введите существующий класс!");
                } catch (NoSuchMethodException ex) {
                    System.out.println("Введите правильные параметры класса!");
                }
            }
        }
        for (Food food : breakfast) {
            if (food == null) break;
            food.consume();
        }
        int count;
        Food[] breakfast_diff = new Food[count_breakfast];
        for (int i = 0; i < count_breakfast; i++) {
            count = 1;
            boolean to_continue = false;
            for(int j = 0; j < count_breakfast; j++)
            {
                if(breakfast_diff[j] == null) continue;
                if (breakfast_diff[j].equals(breakfast[i])) {
                    to_continue = true;
                    break;
                }
            }
            if(to_continue) continue;
            for (int j = i + 1; j < count_breakfast; j++) {
                if ((breakfast[j].equals(breakfast[i]))) {
                    count++;
                }
            }
            breakfast_diff[i] = breakfast[i];
            breakfast[i].consume();
            System.out.println(count + " раз(а)");
        }
        if(calories_needed){
            int calories = 0;
            for (int i = 0; i < count_breakfast; i++) calories += breakfast[i].calculateCalories();
            System.out.println("калорийность: " + calories);
        }
        if(sort_needed){
            Arrays.sort(breakfast, new Comparator(){
                public int compare(Object f1, Object f2){
                    if(f1==null) return 1;
                    if(f2==null) return -1;
                    return Integer.compare(((Food) f2).calculateCalories(), ((Food) f1).calculateCalories());
                }
            });
        }
        System.out.println("отсортированные продукты");
        for (Food food : breakfast) {
            if (food == null) continue;
            System.out.println(food + " " + food.calculateCalories());
            //breakfast[i].consume();
        }
        System.out.print("Съедено продуктов: " + count_breakfast);
        System.out.print("\nвсего хорошего!");
    }
}