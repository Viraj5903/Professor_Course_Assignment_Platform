package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * The Professor class represents a professor working in a department. It includes attributes such as the professor's ID, name, seniority level, hiring date, set of disciplines they teach, and a list of courses they are associated with.
 */
public class Professor implements Comparable<Professor> {

    /**
     * The unique identifier for the professor.
     */
    private int id;

    /**
     * The name of the professor.
     */
    private String name;

    /**
     * The seniority level of the professor.
     */
    private double seniorityLevel;

    /**
     * The date when the professor was hired.
     */
    private LocalDate hiringDate;

    /**
     * The set of disciplines the professor is qualified to teach.
     */
    private HashSet<String> setOfDisciplines;

    /**
     * The list of courses the professor is assigned to teach.
     */
    private ArrayList<Course> listOfAffectedCourses;

    // Constructors
    /**
     * Constructor for creating a Professor object.
     *
     * @param id               The unique identifier for the professor.
     * @param name             The name of the professor.
     * @param seniorityLevel   The seniority level of the professor.
     * @param hiringDate       The date when the professor was hired.
     * @param setOfDisciplines The set of disciplines the professor is qualified to teach.
     */
    public Professor(int id, String name, double seniorityLevel, LocalDate hiringDate, HashSet<String> setOfDisciplines) {
        setId(id);
        setName(name);
        setSeniorityLevel(seniorityLevel);
        setHiringDate(hiringDate);
        setSetOfDisciplines(setOfDisciplines);
        this.listOfAffectedCourses = null;
    }

    /**
     * Retrieves the professor's ID.
     *
     * @return The professor's ID.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the professor's ID.
     *
     * @param id The professor's ID to be set.
     */
    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Please enter an positive ID.");
            throw new RuntimeException("Invalid ID.");
        }
        this.id = id;
    }

    /**
     * Retrieves the professor's name.
     *
     * @return The professor's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the professor's name.
     *
     * @param name The professor's name to be set.
     * @throws NullPointerException If the name is null.
     */
    public void setName(String name) {
        if (name == null) {
            System.out.println("Name cannot be null.");
            throw new NullPointerException("Name cannot be null.");
        }
        this.name = name;
    }

    /**
     * Retrieves the professor's seniority level.
     *
     * @return The professor's seniority level.
     */
    public double getSeniorityLevel() {
        return this.seniorityLevel;
    }

    /**
     * Sets the professor's seniority level.
     *
     * @param seniorityLevel The professor's seniority level to be set.
     * @throws RuntimeException If the seniority level is not within the valid range.
     */
    public void setSeniorityLevel(double seniorityLevel) {
        if (seniorityLevel <= 0 || seniorityLevel > 60) {
            System.out.println("Seniority level must be between 0.00 to 60.00.");
            throw new RuntimeException("Seniority level must be between 0.00 to 60.00.");
        }
        this.seniorityLevel = seniorityLevel;
    }

    /**
     * Retrieves the date when the professor was hired.
     *
     * @return The hiring date of the professor.
     */
    public LocalDate getHiringDate() {
        return this.hiringDate;
    }

    /**
     * Sets the date when the professor was hired.
     *
     * @param hiringDate The hiring date of the professor to be set.
     */
    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    /**
     * Retrieves the set of disciplines the professor is qualified to teach.
     *
     * @return The set of disciplines.
     */
    public HashSet<String> getSetOfDisciplines() {
        return this.setOfDisciplines;
    }

    /**
     * Sets the set of disciplines the professor is qualified to teach.
     *
     * @param setOfDisciplines The set of disciplines to be set.
     * @throws NullPointerException If the Set of Disciplines is null.
     */
    public void setSetOfDisciplines(HashSet<String> setOfDisciplines) {
        if (setOfDisciplines == null) {
            System.out.println("Set Of Disciplines cannot be null.");
            throw new NullPointerException("Set Of Disciplines cannot be null.");
        }
        this.setOfDisciplines = setOfDisciplines;
    }

    /**
     * Retrieves the list of courses the professor is assigned to teach.
     *
     * @return The list of courses.
     */
    public ArrayList<Course> getListOfAffectedCourses() {
        return this.listOfAffectedCourses;
    }

    /**
     * Sets the list of courses the professor is assigned to teach.
     *
     * @param listOfAffectedCourses The list of courses to be set.
     */
    public void setListOfAffectedCourses(ArrayList<Course> listOfAffectedCourses) {
        this.listOfAffectedCourses = listOfAffectedCourses;
    }

    // CompareTo method
    /**
     * Compares this professor with another professor based on seniority level, hiring date and id.
     *
     * @param other The other professor to compare to.
     * @return A negative integer, zero, or a positive integer as this professor is less than, equal to, or greater than
     * the specified professor.
     */
    @Override
    public int compareTo(Professor other) {

        if (this.seniorityLevel > other.seniorityLevel) {
            return 1;
        }
        // If seniority level are equal then comparing via hiring date.
        else if (this.seniorityLevel == other.seniorityLevel) {
            int compare =  this.hiringDate.compareTo(other.hiringDate);

            // If hiring date are equal then comparing via id.
            if (compare == 0) {
                return Integer.compare(this.id, other.id) * -1;
            }
            return -1 * compare;
        }
        else {
            return -1;
        }
    }

    // toString method
    /**
     * Returns a string representation of the Professor object.
     *
     * @return A string representation of the Professor object.
     */
    @Override
    public String toString() {
        return "Professor = {" + "id = " + this.id + ", name = '" + this.name + "'" + ", seniorityLevel = " + this.seniorityLevel + ", hiringDate = " + this.hiringDate + ", setOfDisciplines = " + this.setOfDisciplines + ", \nlistOfAffectedCourses = " + this.listOfAffectedCourses + "}\n";
    }

    /**
     * Overriding the equals method based on Professor.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return this.id == ((Professor) obj).id;
    }
}