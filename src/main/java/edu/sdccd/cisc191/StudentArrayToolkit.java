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

        // More idiomatic use of Java's Comparator API - readable and compact.
        Comparator<Student> gpaComparator = Comparator
            .comparingDouble(Student::getGpa).reversed() // Compare GPA descending
            .thenComparing(Student::getName); // Compare name ascending (tie-breaker)

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
        if (n < 0) {
            // Always add a message to exceptions
            throw new IllegalArgumentException("Cannot retrieve negative number of Students");
        }

        // Total number of students or N, whichever is smaller.
        // More efficient code-wise, avoids repetition.
        int numStudents = Math.min(n, students.length);

        // Java's Arrays API is more well-utilized.
        return Arrays.copyOf(copySortedByGpaDesc(students), numStudents);
    }
}
