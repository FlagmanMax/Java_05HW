// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности Имени.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.*;

public class HW_05_02 
{
    
    
    
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Map -> List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
    
    public static void printMap(Map<String, Integer> map) 
    {
        System.err.println("Key\t\tValue");
        System.err.println("----------------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) 
        {
            System.out.println(entry.getKey()+ "     \t" + entry.getValue());
        }
    }
    public static void main(String[] args) 
    { 
        LinkedList<String> namesList = new LinkedList<>();

        namesList.addLast("Иван Иванов");
        namesList.addLast("Светлана Петрова");
        namesList.addLast("Кристина Белова");
        namesList.addLast("Анна Мусина");
        namesList.addLast("Анна Крутова");
        namesList.addLast("Иван Юрин");
        namesList.addLast("Петр Лыков");
        namesList.addLast("Павел Чернов");
        namesList.addLast("Петр Чернышов");
        namesList.addLast("Мария Федорова");
        namesList.addLast("Марина Светлова");
        namesList.addLast("Мария Савина");
        namesList.addLast("Мария Рыкова");
        namesList.addLast("Марина Лугова");
        namesList.addLast("Анна Владимирова");
        namesList.addLast("Иван Мечников");
        namesList.addLast("Петр Петин");
        namesList.addLast("Иван Ежов");
        System.out.println(namesList);

        Map<String,Integer> NameCounterMap = new HashMap<>();
        String[] Name = new String[2];

        for (int i=0;i<namesList.size();i++)
        {
            Name = namesList.get(i).split(" ");
            if (NameCounterMap.containsKey(Name[0]))
            {
                NameCounterMap.put(Name[0], NameCounterMap.get(Name[0])+1);
            }
            else
            {
                NameCounterMap.put(Name[0], 1);
            }
        }
        System.out.printf("\nUnsorted map:\n");
        printMap(NameCounterMap);

        Map<String, Integer> sortedMap = sortByValue(NameCounterMap);
        System.out.printf("\nSorted map:\n");
        printMap(sortedMap);

    }
}
