import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorege {


    public TreeMap<String, Set<Long>> surnameTreeMap = new TreeMap<>();

    public void studentCreated(Long id, String surname){

        Set<Long> existingIds = surnameTreeMap.getOrDefault(surname,new HashSet<>());

        existingIds.add(id);

        surnameTreeMap.put(surname,existingIds);

    }

    public void studentDeleted(Long id,String surname){
        surnameTreeMap.get(surname).remove(id);
    }

    public  void studentUpdated(Long id, String oldSurname, String newSurname){
        //surnameTreeMap.get(oldSurname).remove(id);
        studentDeleted(id,oldSurname);
        studentCreated(id,newSurname);
    }

    public Set<Long> getStudentBySurnamsLessOrEqulaThan(String surname) {
        Set<Long> res = surnameTreeMap.get(surname)   //.headMap(surname, true)
                    .stream()
                    //.flatMap(longs -> longs.stream())
                    .collect(Collectors.toSet());
            return res;
    }

    public Set<Long> getStudentBySurnamsLessOrEqulaThan2(String[] dataArrey,int size) {

        Set<Long> res = surnameTreeMap.subMap(dataArrey[0],true,  dataArrey[size-1],true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }

    }
