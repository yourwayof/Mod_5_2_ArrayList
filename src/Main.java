import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> addToIndex(String str, ArrayList<String> arrayList)
    {
       String [] inputLineWords = str.split("\\s+", 3);
       String taskName = inputLineWords[2];
       int number = Integer.parseInt(inputLineWords[1]);
       if (number > arrayList.size()){
           arrayList.add(taskName);
       }
       else {
       arrayList.add(number - 1, taskName);
       System.out.println("Добавлено дело: " + taskName);
       }
       System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
       return arrayList;
    }

    public static ArrayList <String> add(String str, ArrayList<String> arrayList)
    {
        String [] inputLineWords = str.split("\\s+", 2);
        String taskName = inputLineWords[1];
        arrayList.add(taskName);
        System.out.println("Добавлено дело: " + taskName);
        System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
        return arrayList;
    }

    public static ArrayList <String> editIndex(String str, ArrayList<String> arrayList)
    {
        String [] inputLineWords = str.split("\\s+", 3);
        String taskName = inputLineWords[2];
        int number = Integer.parseInt(inputLineWords[1]);
        if (number > arrayList.size()){
            System.out.printf("Ошибка ввода. Дело с номером %d не существует. ", number);
        }
        else {
            arrayList.set(number - 1, taskName);
            System.out.println("Вы заменили дело. Новое название: " + taskName);
        }
        System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
        return arrayList;
    }

    public static ArrayList<String> deleteIndex(String str, ArrayList<String> arrayList)
    {
        String [] inputLineWords = str.split("\\s+");
        int number = Integer.parseInt(inputLineWords[1]);
        if (number > arrayList.size()){
            System.out.printf("Ошибка ввода. Дело с номером %d не существует. ", number);
        }
        else {
            arrayList.remove(number - 1);
            System.out.println("Дело удалено!");
        }
        System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
        return arrayList;
    }

    public static void printList(ArrayList<String> arrayList)
    {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(i+1 + ". " + arrayList.get(i));
        }
        System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
    }

    public static void main(String[] args) {

        String regexAddIndex = "ADD\\s+\\d+\\s+.+";
        String regexEditIndex = "EDIT\\s+\\d+\\s+.+";
        String regexAdd = "ADD\\s+.+";
        String regexDeleteIndex = "DELETE\\s+\\d+";
        String regexList = "LIST$";
        String regexStop = "STOP$";

        System.out.println("ДЗ 5.2.");
        System.out.println("Разработать список дел, которым можно управлять командами в консоли. \nКоманды LIST, ADD, EDIT, DELETE. LIST должен выводить дела с их порядковыми номерами. \nADD - добавлять дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер. \nEDIT - заменять дело с указанным номером. DELETE - удалять.");
        System.out.println("Для начала работы со списком дел выберите и введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP:");
        ArrayList<String> toDoList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputLine = scanner.nextLine();
            inputLine = inputLine.trim();

            if (inputLine.matches(regexAddIndex)) {
                addToIndex(inputLine, toDoList);
            } else if (inputLine.matches(regexAdd)) {
                add(inputLine, toDoList);
            } else if (inputLine.matches(regexEditIndex)) {
                editIndex(inputLine, toDoList);
            } else if (inputLine.matches(regexDeleteIndex)) {
                deleteIndex(inputLine, toDoList);
            } else if (inputLine.matches(regexList)) {
                printList(toDoList);
            } else if (inputLine.matches(regexStop)) {
                break;
            } else {
                System.out.println("Ошибка введения команды. Введите одну команду из списка: LIST, ADD, EDIT, DELETE. Для выхода введите команду STOP.");
            }
        }
    }
}

