/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StackStringArray;

import java.util.Scanner;

/**
 *
 * @author tokta
 */
public class StackArrayMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StackArray stack = new StackArray(1);

        int menu;

        do {
            System.out.println("\nWhich task you want to do?\n"
                    + "\n"
                    + "1- push\n"
                    + "2- pop\n"
                    + "3- print\n"
                    + "4- Delete Middle\n"
                    + "5- isPalindrome\n"
                    + "6- exit\n"
            );

            System.out.println("Please enter a digit(1-5): ");
            menu = input.nextInt();
            System.out.println("");

            switch (menu) {
                case 1:
                    System.out.println("How many pushes you want to do?");
                    int numOfPush = input.nextInt();

                    System.out.println("\nEnter " + numOfPush + " strings: ");
                    for (int i = 0; i < numOfPush; i++) {
                        String tmp = input.next();
                        stack.push(tmp);
                    }
                    break;
                case 2:
                    String top = stack.pop();
                    System.out.println("The top element(" + top + ") has been deleted.");
                    break;
                case 3:
                    System.out.println("The content of stack is: ");
                    stack.printStack();
                    System.out.println("");
                    break;
                case 4:
                    System.out.println(stack.deleteMiddle());
                    break;
                case 5:
                    if (stack.isPalindrome()) {
                        System.out.println("The stack is palindrome.");
                    } else {
                        System.out.println("The stack is not palindrome.");
                    }
                    break;
                default:
                    System.out.println("Exiting the program...");
                    break;
            }
            System.out.println("--------------------------"
                    + "-----------------------------------");
        } while (menu < 6);
    }

}