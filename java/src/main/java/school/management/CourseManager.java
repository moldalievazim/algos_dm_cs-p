package school.management;

public class CourseManager {
    private Student[] students;

    public CourseManager (){
        students = new Student[0];
    }

    public void addStudent(Student student) {
        Student[] tempArray = new Student[students.length + 1];
        System.arraycopy(students, 0, tempArray, 0, students.length);
        tempArray[students.length] = student;
        students = tempArray;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            student.displayDetails();
            System.out.println("Student ID: " + student.studentID);
            System.out.println("Enrolled Courses: " + String.join(", ", student.enrolledCourses));
            System.out.println("Tuition: $" + student.getStudentTuition());
            System.out.println(); // Print newline after each student details
        }
    }
}
