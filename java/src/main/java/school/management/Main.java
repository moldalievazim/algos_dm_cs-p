package school.management;
import CourseManager;

public class Main {
    public static void main(String[] args){
        // Create student objects
        Student student1 = new Student("Azim", 19, 230205);
        Student student2 = new Student("Adil", 23, 190401);
        Student student3 = new Student("Joe", 20, 300304);

        // Enroll students in courses
        student1.enrollCourses("Algebra");
        student2.enrollCourses("Discrete Math");
        student3.enrollCourses("Algorithm");

        // Update and display tuition fees
        student1.setStudentTuition(500);
        student3.setStudentTuition(600);
        student2.setStudentTuition(300);

        System.out.println("Student 1 tuition fee: " + student1.getStudentTuition());
        System.out.println("Student 2 tuition fee: " + student2.getStudentTuition());
        System.out.println("Student 3 tuition fee: " + student3.getStudentTuition());

        // Use CourseManager to add students and display details
        CourseManager courseManager = new CourseManager();
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);

        courseManager.displayAllStudents();
    }
}
