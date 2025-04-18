package StudentManagementSystem;

import java.util.*;

public class MainClassAddStudentByConsole {
    static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("***** Welcome *****");
            System.out.println("Select from the options Below..");
            System.out.println("1. Create a New Student");
            System.out.println("2. Print all student info");
            System.out.println("3. Find Student with Student ID");
            System.out.println("4. List Student Information in Sorted Order");
            System.out.println("5. Exit");


            int userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    createStudent(sc);
                    break;
                case 2:
                    printAllStudentInfo();
                    break;
                case 3:
                    System.out.println("Enter Student Id for Search ");
                    String stID = sc.next();
                    findStudentById(stID);
                    break;
                case 4:
                    sortStudent();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    public static void exit(){
        System.exit(0);
    }

    public static void createStudent(Scanner sc){
        System.out.println("Enter Student Name: ");
        String name = sc.next();

        System.out.println("Enter Student StudentId: ");
        String studentId = sc.next();

        System.out.println("Enter Student age: ");
        int age = sc.nextInt();

        Student newStudent = new Student(name, age, studentId);
        studentList.add(newStudent);

        boolean flag = true;
        while(flag) {
            System.out.println("Enter Course name for enroll Student Or Type Done to exit :");
            String course = sc.next();
            if(course.equalsIgnoreCase("exit")){
                flag = false;
            }else {
                if(newStudent.getStudentName() != null) {
                    newStudent.enrollCourse(course);
                }
            }
        }

        if(newStudent.getStudentName() != null) {
            Student studentRef = findStudentById(studentId);
            studentRef.printStudentInfo();
        }

    }

    public static void printAllStudentInfo(){
        System.out.println("Student Info ==== ");
        System.out.println(studentList);
    }

    public static Student findStudentById(String studentId){

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
