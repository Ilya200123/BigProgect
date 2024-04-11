import java.util.Scanner;

public class Main {

    private static StudentComandHandler studentComandHandler = new StudentComandHandler();

    public static void main(String[] args) {

        Entry();

    }

    public static void Entry(){
        while (true){
            printMessage();
            Command command = readCommand();
            if (command.getAction()==Action.Exit){
                return;
            } else if (command.getAction()==Action.error) {
                continue;
            }else {
                studentComandHandler.processComand(command);
            }
        }
    }

    private static Command readCommand(){

       Scanner scanner = new Scanner(System.in);
       try {
           System.out.println("введи номер команды - ");
           String code = scanner.nextLine();
           Integer actionCode = Integer.valueOf(code);
           Action action = Action.fromCode(actionCode);
          // if (action.getCode())
            if (action.isRequiredData()){
                System.out.println("Пожалуйста введите необходимые данные - ");
                String data = scanner.nextLine();
                return  new Command(action,data);
            } else {
                return  new Command(action);
            }
       }catch (Exception ex){
           System.out.println("проблема обработки ввода");
           return new Command(Action.error);
       }

    }

    public static void printMessage(){

        System.out.println("-----------------------------");
        System.out.println("№0 - выход");
        System.out.println("№1 - создание");
        System.out.println("№2 - Обновление данных");
        System.out.println("№3 - Удаление данных ");
        System.out.println("№4 - Вывод статистики по курсам");
        System.out.println("№5 - дз");
        System.out.println("№6 - Поиск по фамилии ");
        System.out.println("----------------------------");

    }



}