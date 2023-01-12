
/*
 *SportActivityApp.java
 *@author JiayuMeng
 *13/11/2022
 */
import java.util.Scanner;

public class SportActivityApp {
    public static void main(String[] args) {
        /*declare variables:
        1.index is the actual number of elements in array;
        2.choice is the option from 1 to 6;
        3.the array is to save sport objects
         */
        int index=0,choice,duration;
        String name,address;
        SportActivity[] sport =new SportActivity[200];

        // Declare and create objects
        Operation operation = new Operation();
        Scanner sc = new Scanner(System.in);

        //display the "sport activity" and the menu
        while (true) {
            SportActivity sa = new SportActivity();
            System.out.println("Welcome to the application menu for sport activity");
            System.out.println("**************** 1. Add an item ***************");
            System.out.println("***** 2. Display the first sport activity *****");
            System.out.println("***** 3. Display the last sport activity ******");
            System.out.println("** 4. Display the average value of durations **");
            System.out.println("*5.Display the sport with the minimum duration*");
            System.out.println("****************** 6. Exit ********************");
            System.out.println("Please choose from 1 to 6:");
            //use try catch to make the program robust
            while(true){try {
                choice = sc.nextInt();
                break;
            } catch (Exception InputMisMatchException) {
                sc = new Scanner(System.in);
                System.out.println("Please input an integer from 1 to 6:");
            }}

            switch (choice) {
                //Input: add an item
                case 1:
                    if(index>=sport.length){
                        System.out.println("You are not allowed to enter more items");
                        continue;
                    }
                    System.out.println("please enter the name of the sport");
                    name = sc.next();
                    System.out.println("please enter the place where you do the sport");
                    address = sc.next();
                    System.out.println("please enter the duration of the sport");
                    while(true) {
                        try {
                            duration = sc.nextInt();
                            break;
                        } catch (Exception InputMisMatchException) {
                            sc = new Scanner(System.in);
                            System.out.println("Please input an integer");
                        }
                    }
                    while (duration < 30 || duration > 28800) {
                        System.out.println("please enter the duration between 30 and 28800 seconds");
                        duration = sc.nextInt();
                    }
                    sa.setName(name);
                    sa.setDuration(duration);
                    sa.setPlace(address);
                    sport[index]=sa;
                    index++;
                    break;
                //output:Display the details of the first entered item
                case 2:
                    if (index == 0) {
                        System.out.println("You have no sports in the system. Please enter sport item first!");
                        continue;
                    }
                    operation.showFirst(sport);
                    break;
                //output:Display the details of the last entered item
                case 3:
                    if (index == 0) {
                        System.out.println("You have no sports in the system. Please enter sport item first!");
                        continue;
                    }
                    operation.showLast(sport,index);
                    break;
                //compute and display(average)
                case 4:
                    if (index == 0) {
                        System.out.println("You have no sports in the system. Please enter sport item first!");
                        continue;
                    }
                    int avg = operation.avg(sport,index);
                    System.out.println("The average value of all durations is: "+avg);
                    break;
                //process and output (get object with the lowest duration)
                case 5:
                    if (index == 0) {
                        System.out.println("You have no sports in the system. Please enter sport item first!");
                        continue;
                    }
                    operation.getMin(sport,index);
                    break;
                //exit
                case 6:
                    System.out.println("System exit...");
                    //System.exit(0);
                    return;
                //in case people choose a number out of the range
                default:
                    System.out.println("Wrong number! Please enter number from 1 to 6.");
            }

        }
    }
}

