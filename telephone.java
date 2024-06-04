package itog;

import java.lang.reflect.Array;
import java.util.*;

import javax.print.attribute.IntegerSyntax;

import user.name;

public class Tel {
    private static Map<String, HashSet<Integer>> phoneBook = new HashMap<>();

   
    
    // @Override
    // public int compareTo(Tel o) {
    // return phoneBook.keySet().size()-o.phoneBook.keySet().size();

    // }

     public Tel() {
    }

    public Tel(Map<String, HashSet<Integer>> phoneBook) {
        this.phoneBook = phoneBook;
    }
     public <E> Tel(String name, HashSet<E> numbers) {
        this.phoneBook.put(name, (HashSet<Integer>) numbers);
    }

    @Override
    public String toString() {
        return "Tel{" +
                "db=" + phoneBook +
                '}';

    }

    public void add(String name, Integer phoneNum) {
        if (phoneBook.get(name) != null) {
            phoneBook.get(name).add(phoneNum);
        } else {
            phoneBook.put(name, new HashSet<>());
            phoneBook.get(name).add(phoneNum);
        }
        // System.out.println("Добавлены новые данные");
    }

    public void find(String name) {
        if (phoneBook.get(name) != null) {
            System.out.println(name + ":" + phoneBook.get(name));
        } else {
            System.out.println(new HashSet<>());
        }

    }

    public void removePhone(String name, Integer phoneNum) {
        if (phoneBook.get(name) != null) {
            if (phoneBook.get(name).remove(phoneNum))
                phoneBook.get(name).remove(phoneNum);
            else {
                System.out.println("Такого номера у этого человека не существует");
            }
        } else {
            System.out.println("Нет такого имени в справочнике");
        }
    }

    public void showAll() {
        
        List<Map.Entry<String, HashSet<Integer>>> sortList = new ArrayList<>(phoneBook.entrySet());
        sortList.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, HashSet<Integer>> entry : sortList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
    

}




}
