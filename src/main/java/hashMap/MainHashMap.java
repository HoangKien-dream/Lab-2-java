package hashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainHashMap {

    public static void main(String[] args) {
        Map<String, Teacher> teacherMap = new HashMap<>();
        String regex = "(^GV.+)\\|(.+)\\|(.+)\\|(.+)";
        Pattern pattern = Pattern.compile(regex);
        //read file text
        try {
            File file = new File("src/main/java/hashMap/file");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String str = reader.nextLine();
                Matcher m = pattern.matcher(str);
                if (m.find()) {
                    Teacher newTeacher = new Teacher();
                    newTeacher.setRollNumber(m.group(1).trim());
                    newTeacher.setNameTeacher(m.group(2).trim());
                    newTeacher.setDate(DateTimeUtil.parseDateString(m.group(3).trim()));
                    newTeacher.setAmount(Integer.parseInt(m.group(4).trim()));
                    if (teacherMap.containsKey(newTeacher.getRollNumber())) {
                        Teacher teacherDuplicate = teacherMap.get(newTeacher.getRollNumber());
                        teacherDuplicate.setAmount(teacherDuplicate.getAmount() + newTeacher.getAmount());
                    } else {
                        teacherMap.put(newTeacher.getRollNumber(), newTeacher);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        MainHashMap.printSortedTeacher(teacherMap);
    }

    private static void printSortedTeacher(Map map) {
        ArrayList<Teacher> teacherArrayList = new ArrayList<Teacher>(map.values());
        Collections.sort(teacherArrayList, new TeacherComparator());
        for (int i = 0; i < 3; i++) {
            System.out.println(teacherArrayList.get(i).toString());
        }
    }

    private static class TeacherComparator implements Comparator<Teacher> {
        @Override
        public int compare(Teacher o1, Teacher o2) {
            if (o1.getAmount() != o2.getAmount()) {
                return -(o1.getAmount() - o2.getAmount()); // quantity lớn hơn lên trên
            } else {
                return o1.getDate().compareTo(o2.getDate()); // ngày nhỏ hơn lên trên
            }
        }
    }
}