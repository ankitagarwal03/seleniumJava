package StudentManagementSystem;

import Utils.CustomException;

import java.io.InputStream;
import java.util.*;

public class MainClass {
    static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args){
        Student ankit = new Student("Ankit", 31, "123");

        if(ankit.getStudentName() != null) {
            ankit.enrollCourse("selenium");
            ankit.enrollCourse("Java");
            ankit.enrollCourse("TestNg");
            ankit.enrollCourse("TestNg");
        }

        Student garima = new Student("Garima", 35, "234");
        garima.enrollCourse("cooking");
        garima.enrollCourse("Party");

        Student dhey = new Student("Dhey", 19, "890");
        dhey.enrollCourse("learn ABC");
        dhey.enrollCourse("learn 123");
        dhey.enrollCourse("learn Math");

        ankit.printStudentInfo();
//        garima.printStudentInfo();
//        dhey.printStudentInfo();

        studentList.add(ankit);
        studentList.add(garima);
        studentList.add(dhey);

        Student studentRef = findStudentById("1231");
        if(studentRef != null) {
            studentRef.printStudentInfo();
        }

        sortStudent();
        addNewStudent();
    }

    public static Student findStudentById(String studentId){

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return 0;
            }
        };

        Student result = null;
        try {
            result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Student not found"));
        }
        catch (RuntimeException e){
            System.err.println("Student with ID "+studentId+" is not found!");
        }
        return result;
//        Student student = null;
//        for(int i=0; i<studentList.size(); i++){
//            Student st = studentList.get(i);
//            String stId = st.getStudentId();
//            if(stId != null && stId.equals(studentId)){
//                student = st;
//            }
//        }
//        if(student == null){
//            throw new RuntimeException("Student with ID ["+studentId+"] not Found");
//        }else{
//            return student;
//        }
    }

//    public static void sortStudent(List<Student> studentList){
//        studentList.sort((student, t1) -> {});
//    }

    public static void addNewStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = sc.next();

        System.out.println("Enter Student StudentId: ");
        String studentId = sc.next();

        System.out.println("Enter Student age: ");
        int age = sc.nextInt();

        Student newStudent = new Student(name, age, studentId);
        studentList.add(newStudent);

        Student studentRef = findStudentById(studentId);
        studentRef.printStudentInfo();

    }

    public static void sortStudent(){
        Comparator<Student> compareByName =  (o1, o2) -> o1.getStudentName().compareTo(o2.getStudentName());

//                new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.getStudentName().compareTo(s2.getStudentName());
//            }
//        };

        Collections.sort(studentList, compareByName);
        System.out.println(studentList);
    }


}
