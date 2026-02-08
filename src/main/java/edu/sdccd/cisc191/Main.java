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
        new Student("Mica",3, 93 ),
        new Student("Jose",3, 67 ),
        };
        var toolkit = new StudentArrayToolkit();
        System.out.println("Original order:");
        for (Student st : students) {
            System.out.print(st.getName() + ": " + st.getGpa() + " | ");
        }

        Student[] sortedByGpa = toolkit.copySortedByGpaDesc(students);
        System.out.println("\nSorted by GPA:");
        for (Student st : sortedByGpa) {
            System.out.print(st.getName() + ": " + st.getGpa() + " | ");
        }

        Student[] topNth = toolkit.topNByGpa(students, 3);
        System.out.println("\nTop 3 students by GPA:");
        for (Student st : topNth) {
            System.out.print(st.getName() + ": " + st.getGpa() + " | ");
        }

        System.out.println("\nStudent with an ID number of 28:");
        for (Student st : students) {
            if (st.getId() == 28) {
                System.out.print(st.getName());
            }
        }
    }
}
