//Ryan Barber 8/1/2026 Assignment 11.2
//This example was adapted from the official Gson User Guide examples: https://google.github.io/gson/UserGuiide.html

import com.google.gson.Gson;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class GsonExample {

    public static void main(String[]args) {

        Gson gson = new Gson();

        Student student = new Student ("Ryan", 29);

        String json = gson.toJson(student);

        System.out.println("JSON:");
        System.out.println(json);

        // Java Object -> JSON
        Student newStudent = gson.fromJson(json, Student.class);

        System.out.println("\nJavaObject:");
        System.out.println("Name:" + newStudent.name);
        System.out.println("Age:" + newStudent.age);
    }
}