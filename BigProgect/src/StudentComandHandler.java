import java.util.*;

public class StudentComandHandler {
    Scanner scanner = new Scanner(System.in);
    Set<String> nums = new TreeSet<>();
     private StudentStoreg studentStoreg = new StudentStoreg();

    public  void processComand(Command command){
        Action action = command.getAction();
        switch (action){
            case  create ->{
                processCreateComand(command);
                break;
            }
            case update -> {
                processUpdateCommand(command);
            }
            case delete -> {
                processDeeteCommand(command);
            break;
            }
            case  statistic -> {
                processStatusByCourseCommand(command);
                break;
            }
            case  statisticDZ -> {
                StatusoftheprocessbystudentsIncities(command);
                break;
            }
            case  search -> {
                processSerchCommand(command);
                break;
            }
            default -> {
                System.out.println("Действие не поддерживается"+ action );
            }

        }
        System.out.println(" Обработка команды." + command.getAction().name()+ " Данные:" + command.getData());


    }

    private void StatusoftheprocessbystudentsIncities(Command command) {

        Map<String,Long> data = studentStoreg.getDataByCity();

        String surname = command.getData();

        if (Checking.RegulStatic(surname)==true) {

            String[] dataArrey = surname.split(",");

            Map<String, Long> data2 = studentStoreg.getDataByCity2(dataArrey, data);

            studentStoreg.printMap(data2);

        } else if (Checking.RegulStatic2(surname)==true) {
            studentStoreg.printMap(data);
        }else {
            System.out.println("Извините, но к сожалению вы некорректно ввели данные. Пример ввода данных представлен ниже.");
            System.out.println("Город,Город");
            System.out.println("№1 - попробовать снова");
            System.out.println("№2 - закончить");

            int code = scanner.nextInt();

            if (code==1){
                Main.Entry();
            }else {
                System.exit(0);
            }
        }

    }

    private  void processSerchCommand(Command command){

        String surname = command.getData();

        Set<String> data = studentStoreg.getSurname();

        if (Checking.RegulStaticSurname(surname)==true){

            String[] dataArrey = surname.split(",");
            int size = dataArrey.length;

            studentStoreg.serch2(dataArrey,size);

        } else if (Checking.RegulStaticSurname2(surname)==true) {

            for (String a : data){
                studentStoreg.serch(a);
            }

        } else if (Checking.RegulStaticSurname3(surname)==true){
            studentStoreg.serch(surname);
        }
        else {
            System.out.println("Извините, но к сожалению вы некорректно ввели данные. Пример ввода данных представлен ниже.");
            System.out.println("Город,Город");
            System.out.println("№1 - попробовать снова");
            System.out.println("№2 - закончить");

            int code = scanner.nextInt();

            if (code==1){
                Main.Entry();
            }else {
                System.exit(0);
            }
        }

    }
    
    private void processStatusByCourseCommand(Command command){
        Map<String,Long> data = studentStoreg.getDataByCourse();
        studentStoreg.printMap(data);

    }

    private void  processCreateComand(Command command){
        String data = command.getData();

        if (Checking.RegulCreate(data)==true){
            String[] dataArrey = data.split(",");

            Student student = new Student();
            student.setSurname(dataArrey[0]);
            student.setName(dataArrey[1]);
            student.setCourse(dataArrey[2]);
            student.setCity(dataArrey[3]);
            student.setAge(Integer.valueOf(dataArrey[4]));

            studentStoreg.createStudent(student);
            studentStoreg.printAll();
        }else {
            System.out.println("Извините, но к сожалению вы некорректно ввели данные. Пример ввода данных представлен ниже.");
            System.out.println("Фамилия,Имя,Специальность,Город,Возраст");
            System.out.println("№1 - попробовать снова");
            System.out.println("№2 - закончить");

            int code = scanner.nextInt();

            if (code==1){
                Main.Entry();
            }else {
                System.exit(0);
            }

        }

    }

    public  void  processUpdateCommand(Command command){
        String data = command.getData();

        if (Checking.RegulUpdate(data)==true){
            String[] dataArrey = data.split(",");
            Long id = Long.valueOf(dataArrey[0]);

            Student student = new Student();
            student.setSurname(dataArrey[1]);
            student.setName(dataArrey[2]);
            student.setCourse(dataArrey[3]);
            student.setCity(dataArrey[4]);
            student.setAge(Integer.valueOf(dataArrey[5]));

            studentStoreg.updateStudent(id, student);
        }else {
            System.out.println("Извините, но к сожалению вы некорректно ввели данные. Пример ввода данных представлен ниже.");
            System.out.println("Индекс,Фамилия,Имя,Специальность,Город,Возраст");
            System.out.println("№1 - попробовать снова");
            System.out.println("№2 - закончить");

            int code = scanner.nextInt();

            if (code==1){
                Main.Entry();
            }else {
                System.exit(0);
            }



        }
    }

    public  void  processDeeteCommand (Command command){
        String data = command.getData();
        if (Checking.RegulDeete(data)==true){
            String[] dataArrey = data.split(",");
            Long id = Long.valueOf(data);
            studentStoreg.deleteStudent(id);
            studentStoreg.printAll();
        }else {
            System.out.println("Извините, но к сожалению вы некорректно ввели данные. Пример ввода данных представлен ниже.");
            System.out.println("Индекс  удаляемого элемента");
            System.out.println("№1 - попробовать снова");
            System.out.println("№2 - закончить");

            int code = scanner.nextInt();

            if (code==1){
                Main.Entry();
            }else {
                System.exit(0);
            }

        }

    }

}
