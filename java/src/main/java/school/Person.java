package school;

public class Person {
    public String name;
    protected int age;

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayDetails (){
        System.out.print("Name: " + this.name + ", ");
        System.out.println("Age: " + this.age);
    }
}
