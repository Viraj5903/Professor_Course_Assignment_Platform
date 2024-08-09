package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Department class represents a department in a university. It contains a mapping of courses offered by the department and a list of professors working in the department.
 */
public class Department {

    /**
     * A mapping of course codes to Course objects offered by the department.
     */
    private HashMap<String, Course> courseMap;

    /**
     * A list of professors working in the department.
     */
    private ArrayList<Professor> listOfProfs;

    // Partially parametrized constructor
    /**
     * Partially parametrized constructor for the Department class.
     *
     * @param listOfProfs The list of professors working in the department.
     */
    public Department(ArrayList<Professor> listOfProfs) {
        this.courseMap = new HashMap<>();
        this.listOfProfs = listOfProfs;
    }

    /**
     * Retrieves the course mapping of the department.
     *
     * @return The mapping of course codes to Course objects.
     */
    public HashMap<String, Course> getCourseMap() {
        return this.courseMap;
    }

    /**
     * Sets the course mapping of the department.
     *
     * @param courseMap The mapping of course codes to Course objects to be set.
     */
    public void setCourseMap(HashMap<String, Course> courseMap) {
        this.courseMap = courseMap;
    }

    /**
     * Retrieves the list of professors working in the department.
     *
     * @return The list of professors.
     */
    public ArrayList<Professor> getListOfProfs() {
        return this.listOfProfs;
    }

    /**
     * Sets the list of professors working in the department.
     *
     * @param listOfProfs The list of professors to be set.
     */
    public void setListOfProfs(ArrayList<Professor> listOfProfs) {
        this.listOfProfs = listOfProfs;
    }

    // toString Method
    /**
     * Returns a string representation of the Department object.
     *
     * @return A string representation of the Department object.
     */
    @Override
    public String toString() {
        return "Department = {\n" + "courseMap =\n" + this.courseMap + ", \nlistOfProfs=\n" + this.listOfProfs + "}";
    }
}
