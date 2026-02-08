package edu.sdccd.cisc191;

/**
 * Module 1 - Part B
 * Student data model with validation.
 */
public class Student {

    private final String name;
    private final double gpa;
    private final int id;

    /**
     * Validation rules:
     * - name must not be null or blank
     * - gpa must be in [0.0, 4.0]
     * - id must be > 0
     *
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Student(String name, double gpa, int id) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        if  (gpa <= 0.0 || gpa >= 4.0) {
            throw new IllegalArgumentException();
        }
        this.gpa = gpa;
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public String getName() {
        if (this.name == null) {
            throw new IllegalArgumentException();
        }
        return this.name;
    }

    public double getGpa() {
        if  (this.gpa <= 0.0 || this.gpa >= 4.0) {
            throw new IllegalArgumentException();
        }
        return this.gpa;
    }

    public int getId() {
        if  (this.id < 0) {
            throw new IllegalArgumentException();
        }
        return this.id;
    }

    @Override
    public String toString() {
        // TODO: return readable summary, e.g. "Student{id=..., name='...', gpa=...}"
        return ("Student [ id =" + this.id + ", name = " + this.name + ", gpa = " + this.gpa + " ]");
    }
}
