// Importing user defined classes.
import model.Course;
import model.Department;
import model.Professor;
import datastructures.queue.PriorityQueue;

// Importing necessary packages and classes.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("\nJava Project.");
            ArrayList<Professor> professorArrayList = extractProfessors();

            System.out.println("Priority Queue for Professor.");
            PriorityQueue<Professor> profProcessingQueue = new PriorityQueue<>(professorArrayList);

            profProcessingQueue.displayAllElement(); // Test Code.

            System.out.println("\n\nCS Department.");
            Department csDepartment = new Department(professorArrayList);

            extractCourses(csDepartment);

            System.out.println(csDepartment);

            System.out.println("\nCS Department Courses: ");
            for (String i : csDepartment.getCourseMap().keySet()) {
                System.out.print("Course ID = " + i + "; Course = " + csDepartment.getCourseMap().get(i));
            }
            System.out.println();

            assignCoursesToProfessors(profProcessingQueue, csDepartment);

            System.out.println();

            professorArrayList.forEach(professor -> {
                System.out.println(professor.toString());
                System.out.println();
            });

        }
        catch (Exception exception) {
            System.out.println("Error = " + exception.getMessage());
            System.out.println("Error track = " + Arrays.toString(exception.getStackTrace()));
        }
    }

    /**
     * Extracts the list of professors and their information from a text file and returns an ArrayList of Professor objects.
     *
     * @return An ArrayList containing the extracted professor objects.
     * @throws RuntimeException If there is an error while reading the file or parsing the professor data.
     */
    public static ArrayList<Professor> extractProfessors() {

        // Initialize an ArrayList to store Professor objects extracted from the text file.
        ArrayList<Professor> professorArrayList = new ArrayList<>();

        // Open the Professors.txt file for reading using a Scanner (try-with-resources ensures the Scanner is closed after use).
        try (Scanner professorScanner = new Scanner(new File("./Text_files/Professors.txt"))) {

            String[] professorDetailArray; // Declare an array to store the details of each professor.
            Professor professor; // Declare a variable(reference) to hold each Professor object.

            // Loop through each line in the Professors.txt file.
            while (professorScanner.hasNextLine()) {

                // Split the current line into an array of strings using ":" as the delimiter.
                professorDetailArray = professorScanner.nextLine().split(":");

                // Check if the array contains all required fields for a professor.
                if (professorDetailArray.length == 5) {

                    // Create a new Professor object using the parsed details from the professorDetailArray array.
                    // Parse and set the professor's ID. Set the professor's name. Parse and set the professor's seniority level. Parse and set the hiring date in the format dd-MM-yyyy. Create a HashSet of disciplines the professor is qualified to teach by splitting the string into an array of strings using "," as the delimiter and converting that array into a HashSet using Arrays.asList() method.
                    professor = new Professor(Integer.parseInt(professorDetailArray[0].trim()), professorDetailArray[1].trim(), Double.parseDouble(professorDetailArray[2].trim()), LocalDate.parse(professorDetailArray[3].trim(), DateTimeFormatter.ofPattern("d-M-yyyy")), new HashSet<>(Arrays.asList(professorDetailArray[4].trim().split(","))));

                    // Add the created Professor object to the professorArrayList ArrayList.
                    professorArrayList.add(professor);
                }

                else {
                    // Print a message indicating an invalid line format if the array does not contain all required fields.
                    System.out.println("Invalid line format: " + Arrays.toString(professorDetailArray));
                }
            }

            // Scanner is automatically closed due to try-with-resources.

        } catch (Exception exception) {
            // If an error occurs during file processing, throw a RuntimeException with the error message.
            throw new RuntimeException(exception.getMessage());
            // throw new RuntimeException("Error = " + error.getMessage());
        }

        // Return the ArrayList containing extracted Professor objects.
        return professorArrayList;
    }

    /**
     * Extracts the list of courses from a file and populates the course map of the specified department.
     *
     * @param department The department object where the extracted courses will be added.
     * @throws RuntimeException If there is an error while reading the file or parsing the course data.
     */
    public static void extractCourses(Department department) {

        // Open the Courses.txt file for reading using a Scanner (try-with-resources ensures the Scanner is closed after use).
        try(Scanner courseScanner = new Scanner(new File("./Text_files/Courses.txt")))  {

            String[] courseDetailArray; // Declare an array to store the details of each course.
            Course course; // Declare a variable(reference) to hold each Course object.

            // Loop through each line in the Courses.txt file.
            while (courseScanner.hasNextLine()) {

                // Split the current line into an array of strings using ":" as the delimiter.
                courseDetailArray = courseScanner.nextLine().split(":");

                // Check if the array contains all required fields for a course.
                if (courseDetailArray.length == 5) {

                    // Create a new Courses object using the parsed details from the courseDetailArray array.
                    course = new Course(courseDetailArray[0].trim(), courseDetailArray[1].trim(), courseDetailArray[2].trim(), Integer.parseInt(courseDetailArray[3].trim()), Integer.parseInt(courseDetailArray[4].trim()));

                    // Add the created course object to the department course map with key as CourseId and value as created course object.
                    department.getCourseMap().put(course.getId(), course);
                }
                else {
                    System.out.println("Invalid line format: " + Arrays.toString(courseDetailArray));
                }
            }

            // Scanner is automatically closed due to try-with-resources.

        } catch (Exception exception) {
            // Catch any exceptions that occur during the process.
            // If an exception occurs throw a RuntimeException.
            throw new RuntimeException(exception.getMessage());
        }
    }

    // Matching algorithm functions

    /**
     * Assigns courses to professors based on courses availability and their priority, preferences, and availability.
     *
     * @param professorPriorityQueue The priority queue containing professors to be matched with courses.
     * @param department             The department containing courses and professors.
     * @throws RuntimeException If there is an error while matching courses to professors.
     */
    public static void assignCoursesToProfessors(PriorityQueue<Professor> professorPriorityQueue, Department department) {
        while (!professorPriorityQueue.isEmpty()) {

            Professor professor = professorPriorityQueue.dequeue();

            try {
                assignCoursesToProfessor(professor, department);
            } catch (Exception exception) {
                // Catch any exceptions that occur during the process.
                System.out.println("Error: " + exception.getMessage());
                throw new RuntimeException(exception.getMessage());
            }
        }
    }

    /**
     * Assigns courses to a specific professor based on courses availability and their preferences and availability.
     *
     * @param professor  The professor object to be matched with courses.
     * @param department The department object containing the courses and professors.
     * @throws RuntimeException If there is an error while matching courses to the professor.
     */
    public static void assignCoursesToProfessor(Professor professor, Department department) {

        // Create a File object representing the professor's selection file.
        File profFile = new File("./Text_files/" + professor.getId() + "_select.txt");
        if (!profFile.exists()) {

            // If the file does not exist, print a message and return.
            System.out.println("Professor file not found for ID: " + professor.getId() + ". Name = " + professor.getName());
            return;
            // throw new RuntimeException("Professor file not found for ID: " + professor.getId());
        }

        // Use try-with-resources to automatically close the Scanner after use.
        try (Scanner professorFileScanner = new Scanner(profFile)) {

            // Initialize the list of affected courses for the professor.
            professor.setListOfAffectedCourses(new ArrayList<>());

            // Read and parse the maximum requested hours from the file.
            int maxRequestedHours = Integer.parseInt(professorFileScanner.nextLine());

            // Iterate through each remaining line in the file.
            while (professorFileScanner.hasNextLine()) {

                // Split the line by comma and parse it to get the course ID and requested number of groups for that course.
                String[] selection = professorFileScanner.nextLine().split(",");

                String courseId = selection[0].trim();
                int requestedNumberOfGroups = Integer.parseInt(selection[1].trim());

                // Limit the maximum number of hours to 30 if it exceeds.
                if (maxRequestedHours >= 30) {
                    maxRequestedHours = 30;
                }

                // Retrieve the course object from the department's course map using the course ID.
                Course course = department.getCourseMap().get(courseId);

                // Check if the course is not null, has available groups, and the professor is qualified to teach it.
                if (course != null && course.getNumOfGroups() > 0 && professor.getSetOfDisciplines().contains(course.getDiscipline())) {

                    // Calculate the number of hours per week for the course.
                    int courseNumberOfHoursPerWeek = getWeeklyHours(course.getNumberOfHours());

                    // Number of groups that professor can teach according to requestedNumberOfGroups and remaining number of hours. (maxRequestedHours).
                    int groupsCanRequested = (int) Math.min(requestedNumberOfGroups, maxRequestedHours/ courseNumberOfHoursPerWeek);

                    // Number of groups can assign on the based of the number of groups available in the department and number of groups professor can teach. (groupsCanRequested)
                    int numberOfAssignedGroups = Math.min(course.getNumOfGroups(), groupsCanRequested);

                    // If there are groups to assign, update the course and professor information.
                    if (numberOfAssignedGroups > 0) {

                        // Create a new Course object representing the assigned course using copy constructor.
                        Course assignedCourse = new Course(course);

                        // Setting the number of groups as numberOfAssignedGroups.
                        assignedCourse.setNumOfGroups(numberOfAssignedGroups);

                        // Add the assigned course to the list of affected courses for the professor.
                        professor.getListOfAffectedCourses().add(assignedCourse);

                        // Update the remaining requested hours for the professor.
                        maxRequestedHours = maxRequestedHours - (numberOfAssignedGroups * courseNumberOfHoursPerWeek);

                        // Update the number of available groups for the course in the department.
                        course.setNumOfGroups(course.getNumOfGroups() - numberOfAssignedGroups);
                    }
                }
            }

            // If the professor has no affected courses, set the list to null.
            if (professor.getListOfAffectedCourses().isEmpty()) {
                professor.setListOfAffectedCourses(null);
            }

            // Scanner is automatically closed due to try-with-resources.

        } catch (Exception exception) {
            // Catch any exceptions that occur during the process.
            // If an exception occurs throw a RuntimeException.
            System.out.println("Error: " + exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }

    /**
     * Determines the number of hours per week based on the total number of hours for a course.
     *
     * @param totalHours The total number of hours for the course.
     * @return The number of hours per week for the given course.
     */
    public static int getWeeklyHours(int totalHours) {

        // Using switch statement to determine the number of hours per week based on the total hours for the course.
        return switch (totalHours) {
            case 45 -> 3; // If total hours is 45, return 3 hours per week.
            case 60 -> 4; // If total hours is 60, return 4 hours per week.
            case 75 -> 5; // If total hours is 75, return 5 hours per week.
            case 90 -> 6; // If total hours is 90, return 6 hours per week.
            default -> 0; // For any other value, return 0.
        };
    }

}