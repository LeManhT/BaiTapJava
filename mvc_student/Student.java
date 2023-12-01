/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_student;

/**
 *
 * @author hieud
 */
public class Student implements Comparable<helloworld.Student>{
    private static int nextId = 1;

    public int id;
    public String name;
    public int  age;
    public String address;
    public Float gpa;
    public Student() {
        this.id = nextId++;
    }
    public Student(int id,String name, int age, String address, Float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(helloworld.Student o) {
        return Float.compare(this.gpa, o.gpa);
    }
}
