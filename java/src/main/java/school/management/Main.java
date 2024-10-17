package school.management;

public class Main {
    public static void main(String[] args){
        // Create student objects
        Student student1 = new Student("Azim", 19, 230205);
        Student student2 = new Student("Adil", 23, 190401);
        Student student3 = new Student("Joe", 20, 300304);

        // Enroll students in courses
        student1.enrollCourses(new String[]{"Algebra", "Calculus"});
        student2.enrollCourse("Discrete Math");
        student3.enrollCourse("Algorithm");
        student3.enrollCourse("Data Structures");

        // Update and display tuition fees
        student1.setStudentTuition(500);
        student2.setStudentTuition(600);
        student3.setStudentTuition(300);

        System.out.println("----- Student Details -----");
        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();

        // Use CourseManager to add students and display details
        CourseManager courseManager = new CourseManager();
        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);

        System.out.println("\n----- All Students Details -----");
        courseManager.displayAllStudents();
    }
}
