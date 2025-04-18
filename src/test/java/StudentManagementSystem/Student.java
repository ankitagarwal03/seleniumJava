package StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    public Student(String name, int age, String studentId){
        if(validateStudentAge(age)) {
            this.age = age;
            this.name = name;
            this.studentId = studentId;
            courses = new ArrayList<String>();
        }
    }

    public String getStudentName(){
        return name;
    }

    public void validateStudentId(String studentId){
        String strPattern = "$-\\d+$";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(studentId);
        boolean isMatch = matcher.matches();
    }

    public void validateStudentName(String name){
        String strPattern = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(studentId);
        boolean isMatch = matcher.matches();
    }

    public boolean validateStudentAge(int age){
        if(age>=19 && age<=55){
            return true;
        }
        else{
            System.out.println("Invalid Age Provided. It should be in range of 19 t0 55, Provided input = "+age);
            return false;
        }
    }



    public void enrollCourse(String course){
        if(!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void printStudentInfo(){
        System.out.println("Student Name = "+name);
        System.out.println("Student Age = "+age);
        System.out.println("Student Id = "+studentId);
        System.out.println("Student courses = "+courses);
        System.out.println("-----");
    }

    public String getStudentId(){
        return studentId;
    }

}
