package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class numberPhone {


    private Map<String, ArrayList> numberPhone = new HashMap<>();

    public void add(String surname, String phoneNumber){

        if (numberPhone.containsKey(surname)){
            ArrayList numberList = numberPhone.get(surname);
            numberList.add(phoneNumber);
            numberPhone.put(surname, numberList);
        } else {
            ArrayList numberList = new ArrayList();
            numberList.add(phoneNumber);
            numberPhone.put(surname, numberList);
        }
    }

    public void get(String surname){
        System.out.println(numberPhone.get(surname));
    }
}
