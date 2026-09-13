package Task5_StudentCourseRegistrationSystem;

import java.util.*;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;

    Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String studentID;
    String name;
    List<Course> registeredCourses = new ArrayList<>();

    Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }
}

public class StudentCourseRegistrationSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("C101", "Java Basics", "Intro to Java", 2, "Mon-Wed 10AM"));
        courses.add(new Course("C102", "Python Fundamentals", "Learn Python", 3, "Tue-Thu 2PM"));
        courses.add(new Course("C103", "Data Structures", "DS in Java", 1, "Fri 11AM"));

        // Sample student
        Student student = new Student("S001", "Naman");

        int choice = 0;
        do {
            System.out.println("\n===== Student Course Registration System =====");
            System.out.println("1. List Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            try {
                choice = scanner.nextInt();
            } catch (Exception e ) {
                System.out.println("Invalid input! Please enter a number. ");
                scanner.next();
                continue;
            }    
            switch (choice) {
                case 1:
                    listCourses(courses);
                    break;
                case 2:
                    listCourses(courses);
                    System.out.print("Enter course code to register: ");
                    String regCode = scanner.next();
                    Course regCourse = findCourse(courses, regCode);
                    if (regCourse != null) {
                        registerCourse(student, regCourse);
                    } else {
                        System.out.println(" Course not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to drop: ");
                    String dropCode = scanner.next();
                    dropCourse(student, dropCode);
                    break;
                case 4:
                    viewRegisteredCourses(student);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println(" Invalid choice!");
            }
        } while (choice != 5);
    }

    static void listCourses(List<Course> courses) {
        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            System.out.println(c.courseCode + " - " + c.title + " | Seats: " + c.capacity + " | Schedule: " + c.schedule);
        }
    }

    static Course findCourse(List<Course> courses, String code) {
        for (Course c : courses) {
            if (c.courseCode.equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    static void registerCourse(Student student, Course course) {
        if(student.registeredCourses.contains(course)) {
           System.out.println("You are already registered for " + course.title);
           return;
        }

        if (course.capacity > 0) {
            student.registeredCourses.add(course);
            course.capacity--;
            System.out.println( student.name + " registered for " + course.title);
        } else {
            System.out.println(" No seats available for " + course.title);
        }
    }

    static void dropCourse(Student student, String code) {
        Course toRemove = null;
        for (Course c : student.registeredCourses) {
            if (c.courseCode.equalsIgnoreCase(code)) {
                toRemove = c;
                break;
            }
        }
        if (toRemove != null) {
            student.registeredCourses.remove(toRemove);
            toRemove.capacity++;
            System.out.println("Dropped course: " + toRemove.title);
        } else {
            System.out.println(" Course not found in your registered list!");
        }
    }

    static void viewRegisteredCourses(Student student) {
        System.out.println("\nRegistered Courses for " + student.name + ":");
        if (student.registeredCourses.isEmpty()) {
            System.out.println("No courses registered yet.");
        } else {
            for (Course c : student.registeredCourses) {
                System.out.println(c.courseCode + " - " + c.title);
            }
        }
    }
}
