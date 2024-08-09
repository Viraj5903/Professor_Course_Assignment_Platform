package model;

/**
 * The Course class represents a course offered by a department. It contains information such as the course ID, title, discipline, number of hours, and number of groups.
 */
public class Course {

    /**
     * The unique identifier for the course.
     */
    private String id;

    /**
     * The title of the course.
     */
    private String title;

    /**
     * The discipline or subject area of the course.
     */
    private String discipline;

    /**
     * The total number of hours the course spans.
     */
    private int numberOfHours;

    /**
     * The number of groups or sections the course is divided into.
     */
    private int numOfGroups;

    /**
     * Parameterized constructor for the Course class.
     *
     * @param id            The unique identifier for the course.
     * @param title         The title of the course.
     * @param discipline    The discipline or subject area of the course.
     * @param numberOfHours The total number of hours the course spans.
     * @param numOfGroups   The number of groups or sections the course is divided into.
     */
    public Course(String id, String title, String discipline, int numberOfHours, int numOfGroups) {
        setId(id);
        setTitle(title);
        setDiscipline(discipline);
        setNumberOfHours(numberOfHours);
        setNumOfGroups(numOfGroups);
    }

    /**
     * Copy constructor for the Course class.
     *
     * @param copyCourse The Course object to be copied.
     */
    public Course(Course copyCourse) {

        this.id = copyCourse.id;
        this.title = new String(copyCourse.title);
        this.discipline = new String(copyCourse.discipline);
        this.numberOfHours = copyCourse.numberOfHours;
        this.numOfGroups = copyCourse.numOfGroups;
    }



    /**
     * Retrieves the course ID.
     *
     * @return The course ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the course ID.
     *
     * @param id The course ID to be set.
     * @throws RuntimeException If the ID is not valid.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the course title.
     *
     * @return The course title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the course title.
     *
     * @param title The course title to be set.
     * @throws NullPointerException If the title is null.
     */
    public void setTitle(String title) {
        if (title == null) {
            System.out.println("Title cannot be null.");
            throw new NullPointerException("Title cannot be null.");
        }
        this.title = title;
    }

    /**
     * Retrieves the course discipline.
     *
     * @return The course discipline.
     */
    public String getDiscipline() {
        return this.discipline;
    }

    /**
     * Sets the course discipline.
     *
     * @param discipline The course discipline to be set.
     * @throws NullPointerException If the discipline is null.
     */
    public void setDiscipline(String discipline) {
        if (discipline == null) {
            System.out.println("Discipline cannot be null.");
            throw new NullPointerException("Discipline cannot be null.");
        }
        this.discipline = discipline;
    }

    /**
     * Retrieves the total number of hours the course spans.
     *
     * @return The number of hours.
     */
    public int getNumberOfHours() {
        return this.numberOfHours;
    }

    /**
     * Sets the total number of hours the course spans.
     *
     * @param numberOfHours The number of hours to be set.
     * @throws RuntimeException If the number of hours is not valid.
     */
    public void setNumberOfHours(int numberOfHours) {
        if (numberOfHours <= 0) {
            System.out.println("Please enter an positive number of hours.");
            throw new RuntimeException("Invalid number of hours.");
        }
        this.numberOfHours = numberOfHours;
    }

    /**
     * Retrieves the number of groups or sections the course is divided into.
     *
     * @return The number of groups.
     */
    public int getNumOfGroups() {
        return this.numOfGroups;
    }

    /**
     * Sets the number of groups or sections the course is divided into.
     *
     * @param numOfGroups The number of groups to be set.
     * @throws RuntimeException if the number of groups is not valid.
     */
    public void setNumOfGroups(int numOfGroups) {
        if (numOfGroups < 0) {
            System.out.println("Please enter an positive number of groups.");
            throw new RuntimeException("Invalid number of groups.");
        }
        this.numOfGroups = numOfGroups;
    }

    // toString method
    /**
     * Returns a string representation of the Course object.
     *
     * @return A string representation of the Course object.
     */
    @Override
    public String toString() {
        return "Course = {" + "id = " + this.id + ", title = '" + this.title + "'" + ", discipline = '" + this.discipline + "'" + ", numberOfHours = " + this.numberOfHours + ", numOfGroups = " + this.numOfGroups + "}\n";
    }
}
