package edu.sdccd.cisc191;

/**
 * Module 1 - Demo runner.
 * This is primarily for your video demo.
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Create at least 6 students and demonstrate:
        // - original order
        // - sorted-by-GPA order
        // - topNByGpa with N=3
        // - findByIdLinear with existing and non-existing id
        Student[] students = {
        new Student("Josh",3.7, 3 ),
        new Student("Lain",4, 73 ),
        new Student("Alan",2.5, 28 ),
        new Student("Berdly",3.9, 12 ),
        new Student("Jose",3, 93 ),
        new Student("Mica",3, 67 ),
        };
        System.out.println("Original order:");
        for (Student student : students) {
            System.out.print(student.getName() + ": " + student.getGpa() + " | ");
        }
        System.out.println("Sorted by GPA");
    }
}
