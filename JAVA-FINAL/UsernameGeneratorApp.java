
import java.util.Scanner;

public class UsernameGeneratorApp {
    public static void main(String[] args) {
        //declare variables
        String fullName;
        String userName;
        String answer;
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int length;


        //create new object
        UsernameGenerator ug = new UsernameGenerator();

        //using while true to realize loop
        while (true) {
            //input the value of full name
            System.out.println("please enter your full name(forename surname)");
            fullName = sc.nextLine();

            //call method to set full name
            ug.setFullName(fullName);
            //call method to generate username
            ug.generateUser();
            //call method to get username
            userName = ug.getUsername();

            //output username
            System.out.println("Your username is: " + userName);

            //ask users whether they would like to enter another full name
            System.out.println("Do you want to generate another username? enter 'yes' to continue.");
            answer = sc.nextLine();
            if ("yes".equalsIgnoreCase(answer)) {
                continue;
            }
            //if the answer is other stuff except "yes", the system will jump out of the while loop
            System.out.println("Thank you for using the generator");
            break;
        }
        //Question 2 to validate usernames
        //input the number of usernames
        System.out.println("Please enter the number of usernames you would like to validate");
        while (true) {
            try {
                length = sc.nextInt();
                break;
            } catch (Exception e) {
                sc = new Scanner(System.in);
                System.out.println("Please enter a number");
            }
        }

        sc.nextLine();

        String[] usenames = new String[length];

        //input the value of username one by one
        while (length > 0) {
            System.out.println("Please enter the username");
            String s = sc.nextLine();
            //convert username to lowercase letters
            s = s.toLowerCase();
            //add username in the String array
            usenames[index++] = s;
            length--;
        }
        // call method validateUser() to get the boolean values for an array of usernames
        boolean[] booleans = ug.validateUser(usenames);
        System.out.print("The result is: ");
        for (int i = 0; i < booleans.length; i++) {
            if (i == booleans.length - 1) {
                System.out.println(booleans[i]);
                break;
            }
            System.out.print(booleans[i] + ",");
        }
    }
}
