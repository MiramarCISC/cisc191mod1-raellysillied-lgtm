package edu.sdccd.cisc191;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Module 1 - Part C
 * Utility methods for working with Student[].
 *
 * IMPORTANT:
 * - Methods that return Student[] must return NEW arrays (defensive copy).
 * - For sorting, use a Comparator created with a lambda or method references.
 */
public class StudentArrayToolkit {

    /**
     * Returns a NEW array sorted by:
     * 1) GPA descending
     * 2) name ascending (tie-breaker)
     *
     * Must not modify the original array.
     */
    public static Student[] copySortedByGpaDesc(Student[] students) {
        // TODO: defensive copy + Arrays.sort with Comparator lambda
        Student[] gpaStudents = new Student[students.length];
        System.arraycopy(students, 0, gpaStudents, 0, students.length);

        Comparator<Student> gpaComparator = (Student s1, Student s2) -> {
            int gpaCompared = Double.compare(s2.getGpa(), s1.getGpa());
            if (gpaCompared != 0) {
                return gpaCompared;
            }
            return s1.getName().compareTo(s2.getName());
        };
        Arrays.sort(gpaStudents, gpaComparator);
        return gpaStudents;
    }

    /**
     * Linear search for a student by id.
     * Returns the Student if found, otherwise null.
     */
    public static Student findByIdLinear(Student[] students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Returns a NEW array containing the top N students by GPA desc (ties: name asc).
     * If n > students.length, return all students (sorted).
     * If n == 0, return an empty array.
     * @throws IllegalArgumentException if n < 0
     */
    public static Student[] topNByGpa(Student[] students, int n) {
        Student[] topNth = new Student[n];
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return topNth;
        }
        if (n > students.length) {
            System.arraycopy(copySortedByGpaDesc(students), 0, topNth, 0, students.length);
        } else {
            System.arraycopy(copySortedByGpaDesc(students), 0, topNth, 0, n);
        }
        return topNth;
    }
}
