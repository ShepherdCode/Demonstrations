/**
 * This simple Java program demonstrates printf().
 * 
 * The official printf documentation is at
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...)
 *   
*/
public class StudentInfo {
    public static void main () {
        
        // Variable delcarations
        String firstName;
        String lastName;
        String major;
        int age;
        
        // Variable assignments -- you should fix these
        firstName = "Jane";
        lastName = "Doe";
        major = "ART";
        age = 65;
        
        // Print using variables
        System.out.printf("My name is %s %s ",
            firstName,lastName);
        System.out.printf("and I am %d years old.\n",
            age);
        System.out.printf("My major is %s.\n",
            major);
    }
}
