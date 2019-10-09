/*
A simple calculator

Write a simple calculator that reads the three values from the line: the first number, the operation, and the second number.
The program should apply the operation to the numbers entered ("first number" "operation" "second number") and output the result to the screen. Note that the numbers are long.
The calculator should support:

addition: "+"
subtraction: "-"
integer division: "/"
multiplication: "*"
If a user performs division and the second number is 0, it is necessary to output the line "Division by 0!".

If the input operator is not one from the list, the program should output "Unknown operator".

Note: it's recommended to use the switch statement in your solution.

Sample Input 1:
10000000000 + 20000000000

Sample Output 1:
30000000000

Sample Input 2:
3000 / 0

Sample Output 2:
Division by 0!

Sample Input 3:
10000 ! 300

Sample Output 3:
Unknown operator
*/

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String[] params = scanner.nextLine().split(" ");
        long a = scanner.nextLong();
        String operator = scanner.next();
        long b = scanner.nextLong();

        switch (operator) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "/":
                if(b != 0) {
                    System.out.println(a / b);
                } else {
                    System.out.println("Division by 0!");
                }
                break;
            case "*":
                System.out.println(a * b);
                break;
            default:
                System.out.println("Unknown operator");
                break;

        }
    }
}
