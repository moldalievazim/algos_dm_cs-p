package school.management;

import school.Person;

class Student extends Person {
    private int studentID;
    private String[] enrolledCourses;
    private double tuition;

    public double getStudentTuition(){
        return this.tuition;
    }

    public double setStudentTuition(double value){
        value = enrolledCourses.length * 500;
        return this.tuition = value;
    }

    public Student (String name, int age, int studentID){
        super(name, age);
    }

    public void enrollCourses (String[] courses){
        enrolledCourses.put(courses);
    }

    public void enrollCourses (String course){
        enrolledCourses.put(course);
    }

}
