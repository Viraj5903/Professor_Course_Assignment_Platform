# Professor Course Assignment Platform (PCAP)

## Overview

The **Professor Course Assignment Platform (PCAP)** is a Java-based system designed to efficiently manage and match professors to courses within the Computer Science Department at LaSalle College. The platform features advanced data structures, including a priority queue, to optimize professor assignments based on seniority and requested hours, while also handling course and professor representations.

## Description
### Features
- **Generic Circular Queue:** Implements a circular queue with array and linked list representations, with methods to handle standard queue operations as well as priority queue functionality.

- **Priority Queue:** Extends the generic queue to handle priority-based operations, including enqueuing based on priority, and displaying elements by priority.

- **Professor Representation:** Models professors with attributes such as ID, name, seniority, hiring date, disciplines, and affected courses. Implements comparison based on seniority and hire date.

- **Course Representation:** Models courses with attributes like ID, title, discipline, number of hours, and number of groups. Includes a copy constructor.

- **Department Representation:** Manages a collection of courses and professors, with methods for course assignment based on professor preferences and constraints.

- **Matching Algorithm:** Efficiently assigns courses to professors based on their preferences, available courses, and constraints like maximum weekly hours and discipline match.

## Technology Used
- **Java:** The core programming language used for implementing the data structures, classes, and algorithms.
- **JavaDocs:** For generating documentation.
- **JAR Files:** For packaging the application.

## Setup Instructions
1. **Clone the Repository:**
   ```
    git clone https://github.com/Viraj5903/Professor_Course_Assignment_Platform.git
   ```
2. **Ensure Java is Installed:**
   - Make sure you have Java Development Kit (JDK) installed. You can download it from [Oracle's official website](https://www.oracle.com/ca-en/java/technologies/downloads/).

3. **Open in IDE:**
    - Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

4. **Build the Project:**
    - **Compile:** Use your IDE's build tool or run javac commands to compile the source code.
    - **Generate JAR Files:** Use the build tools provided by your IDE or the command line.

5. **Run the Main Application:**
   - Execute the Main.java file to process professor preferences and course availability.

## File Structure
- `src/`: Contains Java source code files.
  - `Main.java`: Main application for processing professor preferences and course availability.
  - `models/`: Contains classes representing core entities.
    - `Professor.java`: Class representing professors.
    - `Course.java`: Class representing courses.
    - `Department.java`: Class representing the Computer Science Department.
  - `datastructures/queue/`: Contains implementations of various queue types.
    - `CircularQueue.java`: Implements the generic circular queue using array.
    - `QueueLinkedList.java`: Implements the generic queue using Linked List.
    - `PriorityQueue.java`: Implements the generic priority queue.

- `docs/`: Contains project documentation.
  - `JavaDocs/`: Generated JavaDocs for the project.

- `Text_files/`: Contains sample input files. 
  - `Professors.txt`: File containing professor preferences.
  - `Courses`: File containing course availability.
  - `{professor_id}_select.txt`: File containing the total hours availability and preferred courses for the specified professor.

- `Class_Diagram/`: Contains class diagrams.
  - `ClassDiagram.drawio`: Class diagram of the project, created with draw.io.

- `jar/`: Contains the packaged JAR file for distribution.
  - `ProfessorCourseAssignmentPlatform.jar`: Executable JAR file containing the compiled application.

- `README.md`: This README file.

## Author
[Viraj Patel \(@Viraj5903\)](https://github.com/Viraj5903)
- Creator and maintainer of the Professor Course Assignment Platform (PCAP). Responsible for designing and implementing the system’s features, including professor and course management, advanced data structures, and the course matching algorithm.