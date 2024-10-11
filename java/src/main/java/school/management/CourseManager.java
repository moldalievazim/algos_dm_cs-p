package school.management;

public class CourseManager {
    private String[] students;

    public CourseManager (String[] students){
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void displayAllStudents (String[] students){
        for (String student : students) {
            System.out.println(student);
        }
    }
}
