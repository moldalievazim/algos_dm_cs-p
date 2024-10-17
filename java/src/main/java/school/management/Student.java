package school.management;
import school.Person;

class Student extends Person {
    protected int studentID;
    protected String[] enrolledCourses;
    private double tuition;

    public Student(String name, int age, int studentID) {
        super(name, age); // Call parent constructor
        this.studentID = studentID;
    }

    public void enrollCourses(String[] courses) {
        this.enrolledCourses = new String[courses.length];
        System.arraycopy(courses, 0, this.enrolledCourses, 0, courses.length);
    }

    public void enrollCourse(String course){
        if (enrolledCourses == null){
            enrolledCourses = new String[1];
            enrolledCourses[0] = course;
        } else {
            String[] tempArray = new String[enrolledCourses.length + 1];
            System.arraycopy(enrolledCourses, 0, tempArray, 0, enrolledCourses.length);
            tempArray[enrolledCourses.length] = course;
            enrolledCourses = tempArray;
        }
    }

    public double getStudentTuition(){
        return tuition;
    }

    public void setStudentTuition(double basePricePerCourse){
        this.tuition = enrolledCourses.length * basePricePerCourse;
    }
}

