import java.util.Scanner;

public class SmartStudentManagement {

    // Function to calculate grade
    static char calculateGrade(double average) {

        if (average >= 90)
            return 'A';

        else if (average >= 75)
            return 'B';

        else if (average >= 50)
            return 'C';

        else
            return 'F';
    }

    // Function to display topper
    static void displayTopper(int rollNo, String name,
                              int total, double average, char grade) {

        System.out.println("\n Topper Details:");

        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }

    // Main Function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Arrays to store details
        int[] rollNo = new int[n];
        String[] name = new String[n];
        int[] total = new int[n];
        double[] average = new double[n];
        char[] grade = new char[n];

        // Variables for topper
        int highest = 0;
        int topperIndex = 0;

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Roll No: ");
            rollNo[i] = sc.nextInt();

            sc.nextLine(); // clear buffer

            System.out.print("Name: ");
            name[i] = sc.nextLine();

            System.out.print("Marks 1: ");
            int m1 = sc.nextInt();

            System.out.print("Marks 2: ");
            int m2 = sc.nextInt();

            System.out.print("Marks 3: ");
            int m3 = sc.nextInt();

            // Calculate total
            total[i] = m1 + m2 + m3;

            // Calculate average
            average[i] = total[i] / 3.0;

            // Function call for grade
            grade[i] = calculateGrade(average[i]);

            // Topper Logic
            if (total[i] > highest) {
                highest = total[i];
                topperIndex = i;
            }
        }

        // Display all student details
        System.out.println("\n--- Student Details ---");

        for (int i = 0; i < n; i++) {

            System.out.println("Roll No: " + rollNo[i]);
            System.out.println("Name: " + name[i]);
            System.out.println("Total: " + total[i]);
            System.out.println("Average: " + average[i]);
            System.out.println("Grade: " + grade[i]);

            System.out.println();
        }

        // Function call to display topper
        displayTopper(
                rollNo[topperIndex],
                name[topperIndex],
                total[topperIndex],
                average[topperIndex],
                grade[topperIndex]
        );

        sc.close();
    }
}