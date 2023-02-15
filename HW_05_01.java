// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class HW_05_01 {
    public static void main(String[] args) 
    {
        Map<Integer,String> dbPerson = new HashMap<>();       // 0    Иван Петров
        Map<String,Integer> dbPhoneNumber = new HashMap<>();      // 89200000000 0
        int recordIndex = 0;
       // LinkedList<HashMap<Integer,String[]>> LinkedList = new LinkedList<>();   

        dbPerson.put(recordIndex, "Иван Иванов");
        dbPhoneNumber.put("89200000000",recordIndex);
        dbPhoneNumber.put("89200000001",recordIndex);
        recordIndex++;

        dbPerson.put(recordIndex, "Светлана Петрова");
        dbPhoneNumber.put("89200000010",recordIndex);
        recordIndex++;

        dbPerson.put(recordIndex, "Кристина Белова");
        dbPhoneNumber.put("89200000100",recordIndex);
        dbPhoneNumber.put("89200000101",recordIndex);
        recordIndex++;

        Scanner scan = new Scanner(System.in, "CP866");
        int menu = 0;

        System.out.println("Вас приветствует телефонная книга!");

        while(true)
        {   
            System.out.printf("\nВыберите команду меню:\n");
            System.out.println(" 0. Выход из программы");
            System.out.println(" 1. Добавить абонента");
            System.out.println(" 2. Удалить абонента");
            System.out.println(" 3. Просмотр телефонной книги");
            System.out.printf("> ");
            
            menu = Integer.parseInt(scan.nextLine());
 
            switch(menu)
            {
                case 0:
                {
                    System.out.println("До свидания!");
                    break;
                }
                case 1:
                {
                    recordIndex = addContact(dbPerson,dbPhoneNumber,recordIndex,scan);
                    break;
                }
                case 2:
                {
                    deleteContact(dbPerson,dbPhoneNumber,scan);
                    break;
                }
                case 3:
                {
                    printPhoneBook(dbPerson,dbPhoneNumber);
                    break;
                }
                default:
                {
                    System.out.println("Ошибка ввода!");
                }
            }

            if (menu==0)
            {
                 break;
            }

        } 
        scan.close(); 
    }
    public static void printPhoneBook(Map<Integer,String> dbPerson,Map<String,Integer> dbPhoneNumber) 
    {
        for (var itemPerson : dbPerson.entrySet())
        {
            Integer key = itemPerson.getKey();

            if (dbPhoneNumber.containsValue(key)) // print all PhoneNumbers for this ID
            {
                // dbPhoneNumber.
                
                System.out.printf("\n%d\t%s \n",key, itemPerson.getValue()); 

                for (var itemPhoneNumber : dbPhoneNumber.entrySet())
                {
                    if (itemPhoneNumber.getValue() == key)
                    {
                        System.out.printf("\tТелефонный номер %s\n",itemPhoneNumber.getKey()); 
                    }
                }
            }
        }
    }
    public static int addContact(Map<Integer,String> dbPerson,Map<String,Integer> dbPhoneNumber, int recordIndex, Scanner scan) 
    {
        System.out.printf("Введите Имя и Фамилию, затем нажмите Enter\n> ");
        dbPerson.put(recordIndex, scan.nextLine());
        
        System.out.printf("Введите Номер телефона, затем нажмите Enter. Для выхода введите 'q'\n");
        String lineToCheck;
        while(true)
        {
            System.out.printf("> ");
            lineToCheck = scan.nextLine();
            if (lineToCheck.equalsIgnoreCase("q"))
            {
                break;
            }
            dbPhoneNumber.put(lineToCheck,recordIndex);
        }
        recordIndex++;

        return recordIndex;
    }
    public static void deleteContact(Map<Integer,String> dbPerson,Map<String,Integer> dbPhoneNumber, Scanner scan) 
    {
        System.out.printf("Введите ID контакта для удаления\n> ");
        int ID = Integer.parseInt(scan.nextLine());
        dbPerson.remove(ID);

        for (var itemPhoneNumber : dbPhoneNumber.entrySet())
        {
            if (itemPhoneNumber.getValue() == ID)
            {
                dbPhoneNumber.remove(itemPhoneNumber.getValue(), ID);
            }
        }
    }
}
