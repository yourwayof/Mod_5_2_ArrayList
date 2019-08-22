import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("ДЗ 5.2.");
        System.out.println("Разработать список дел, которым можно управлять командами в консоли. \nКоманды LIST, ADD, EDIT, DELETE. LIST должен выводить дела с их порядковыми номерами. \nADD - добавлять дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер. \nEDIT - заменять дело с указанным номером. DELETE - удалять.");
        System.out.println("Для начала работы со списком дел выберите и введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP:");
        ArrayList <String> toDoList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputLine = scanner.nextLine();
            inputLine = inputLine.trim();
            String [] inputLineWords = inputLine.split("\\s+");
            if (inputLineWords[0].equals("STOP")){break;}
            else if (inputLineWords[0].equals("ADD")){
                if (!isNumeric(inputLineWords[1])){
                    String workName = "";
                    for (int i = 1; i < inputLineWords.length; i++){
                        workName = workName + inputLineWords[i] + " ";
                    }
                    toDoList.add(workName);
                    System.out.println("Добавлено дело: " + workName);
                }
                else {
                    int number = Integer.parseInt(inputLineWords[1]);
                    if (number > toDoList.size()){
                        String workName = "";
                        for (int i = 2; i < inputLineWords.length; i++){
                            workName = workName + inputLineWords[i] + " ";
                        }
                        toDoList.add(workName);
                        System.out.println("Добавлено дело: " + workName);
                    }
                    else {
                        String workName = "";
                        for (int i = 2; i < inputLineWords.length; i++){
                            workName = workName + inputLineWords[i] + " ";
                        }
                        toDoList.add(number-1, workName);
                        System.out.println("Добавлено дело: " + workName);
                    }
                }
                System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
            }
            else if (inputLineWords[0].equals("LIST")){
                System.out.println("Ваш список дел:");
                for (int i = 0; i < toDoList.size(); i++){
                    System.out.println(i+1 + ". " + toDoList.get(i));
                }

                System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
            }
            else if (inputLineWords[0].equals("EDIT")) {
                while (true) {
                    if (isNumeric(inputLineWords[1]) == false) {
                        System.out.println("Ошибка ввода. После команды EDIT введите номер элемента списка, который Вы хотите заменить.");
                        break;
                    } else {
                        int number = Integer.parseInt(inputLineWords[1]);
                        String workName = "";
                        for (int i = 2; i < inputLineWords.length; i++) {
                            workName = workName + inputLineWords[i] + " ";
                        }
                        toDoList.set(number-1, workName);
                        System.out.println("Вы заменили дело. Новое название:: " + workName);
                        System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
                        break;
                    }
                }
            }
            else if (inputLineWords[0].equals("DELETE")){
                while (true) {
                    if (isNumeric(inputLineWords[1]) == false) {
                        System.out.println("Ошибка ввода. После команды DELETE введите номер элемента списка, который Вы хотите удалить.");
                    } else {
                        int number = Integer.parseInt(inputLineWords[1]);
                        toDoList.remove(number-1);
                        System.out.println("Дело удалено!");
                        System.out.println("Для продолжения работы введите команду (LIST, ADD, EDIT, DELETE). Для выхода введите команду STOP.");
                        break;
                    }
                }
            }
            else {
                System.out.println("Ошибка введения команды. Введите одну команду из списка: LIST, ADD, EDIT, DELETE. Для выхода введите команду STOP.");
            }
        }
    }
}

