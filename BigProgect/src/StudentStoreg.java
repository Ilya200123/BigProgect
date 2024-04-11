import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentStoreg {

    private Map<Long,Student> studentStoregMap = new HashMap<>();

    private  StudentSurnameStorege studentSurnameStorege = new StudentSurnameStorege();

    private Long currentId = 0l;

    public Long createStudent(Student student){

        Long nextId = getNext();


        studentStoregMap.put(nextId,student);

        studentSurnameStorege.studentCreated(nextId,student.getSurname());

        return nextId;

    }

    public  boolean updateStudent(long id, Student student){

        if (!studentStoregMap.containsKey(id)){
            return  false;
        }else {
            String newStud = student.getSurname();
            String oldSurname = studentStoregMap.get(id).getSurname();
            studentSurnameStorege.studentUpdated(id,oldSurname,newStud);

            studentStoregMap.put(id,student);
            return  true;
        }

    }

    public boolean deleteStudent(long id){

Student remove = studentStoregMap.remove(id);
if (remove!=null){
    String surname = remove.getSurname();
    studentSurnameStorege.studentDeleted(id,surname);
}
return  remove != null;
    }

    public void serch2(String[] dataArrey,int size){

        Set<Long> syudent = studentSurnameStorege
                .getStudentBySurnamsLessOrEqulaThan2(dataArrey,size);
        for (Long studId:syudent){
            Student student = studentStoregMap.get(studId);
            System.out.println(student);
        }
    }

    public void serch(String surname){
        Set<Long> syudent = studentSurnameStorege
                .getStudentBySurnamsLessOrEqulaThan(surname);
        for (Long studId:syudent){
            Student student = studentStoregMap.get(studId);
            System.out.println(student);
        }
    }


    public  long getNext(){
        currentId = currentId+1;
        return currentId;

    }

    public void  printAll(){
        System.out.println(studentStoregMap);

    }

    public void printMap(Map<String,Long> data){
        data.entrySet().stream().forEach(e-> {
            System.out.println(e.getKey()+"-" + e.getValue());
        });
    }
    public  Map<String,Long> getDataByCourse() {
        /*
        Map<String,Long> res = new HashMap<>();

        for (Student student: studentStoregMap.values()){
            String key = student.getCourse();
            Long count = res.getOrDefault(key,0l );
            count++;
            res.put(key,count);
        }
        return  res;

         */

        Map<String, Long> res = studentStoregMap.values()
                .stream()
                .collect(Collectors.toMap(
                        s -> s.getCourse(),
                        s -> 1l,
                        ( count1, count2) -> count1 + count2
                ));
        return res;

    }


    public  Map<String,Long> getDataByCity() {


        Map<String, Long> res = studentStoregMap.values()
                .stream()
                .collect(Collectors.toMap(
                        s -> s.getCity(),
                        s -> 1l,
                        ( count1, count2) -> count1 + count2
                ));
        return res;

    }

    public  Map<String,Long> getDataByCity2(String[] dataArrey, Map<String,Long> data) {
        /*
        int a = 0;
        Map<String,Long> СityStud = new HashMap<>();
        for (String s:dataArrey) {
            СityStud.put(dataArrey[a], data.get(dataArrey[a]));
            a++;
        }

    return СityStud;



         */

        Map<String, Long> СityStud = new HashMap<>();

        for (String City:dataArrey){
            СityStud.put(City,data.get(City));
        }
        return СityStud;
    }


    public Set getSurname() {
        
        Set<String> res = studentStoregMap.values()
                .stream()
                .map(s -> s.getSurname()) // Возвращает поток фамилий
                .collect(Collectors.toSet()); // Собирает фамилии в Set
        return res;
    }
}
