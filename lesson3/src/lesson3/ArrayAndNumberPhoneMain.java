package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayAndNumberPhoneMain {
    public static void main(String[] args) {
        String[] myArray = new String[]{"when", "did", "you","create", "when", "go", "create", "berry", "melon", "create", "slowly"};
        unique(myArray);// вывести уникальные слова
        num(myArray);// количество вхождений каждого слова
        System.out.println();

        numberPhone Book = new numberPhone(); //создать телефонный справочник
        Book.add("Иванов", "896546546546");
        Book.add("Иванов", "8956456546");
        Book.add("Петров", "89654646");
        Book.add("Сидоров", "8965465546");
        Book.add("Редько", "896546546546");
        Book.add("Редько", "89632154687");
        Book.add("Иванов", "89632154687");

        Book.get("Иванов");



    }

    public static void unique(String[] arr){ //вывод уникальных слов
        List<String> newList = new ArrayList<String>();
        for (String str: arr) {
            if (!newList.contains(str)) newList.add(str);
        }
        System.out.println(newList);
    }

    public static void num(String[] arr){ //количество вхождений каждого уникального слова
        HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
        Integer count;
        for (String str: arr) {
            count = myHashMap.get(str);
            if (count == null) myHashMap.put(str, 1);
            else myHashMap.put(str, count+1);
        }
        System.out.println(myHashMap);
    }



}
