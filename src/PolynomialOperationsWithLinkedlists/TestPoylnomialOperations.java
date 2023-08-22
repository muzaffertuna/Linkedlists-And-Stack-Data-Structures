package PolynomialOperationsWithLinkedlists;

import java.util.Scanner;
/**
 *
 * @author tokta
 */
public class TestPoylnomialOperations {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MyLinkedList poly1 = new MyLinkedList();
        MyLinkedList poly2 = new MyLinkedList();

        System.out.println("Enter the coefficient and power of the first polynomial. Type 0 at the end: ");
        while (true) {
            int coef = input.nextInt();
            if (coef == 0) {
                break;
            }
            int pow = input.nextInt();
            poly1.insertSortedList(coef, pow);
            System.out.println("-----------------");
        }

        System.out.println("\nEnter the coefficient and power of the second polynomial. Type 0 at the end: ");
        while (true) {
            int coef = input.nextInt();
            if (coef == 0) {
                break;
            }
            int pow = input.nextInt();
            poly2.insertSortedList(coef, pow);
            System.out.println("-----------------");
        }

        System.out.println("\nThe entered polynomials are: ");
        System.out.println(poly1.printPolynomial());
        System.out.println(poly2.printPolynomial());
        System.out.println("---------------------------------------------------");

        int menu;

        do {
            System.out.println("\nWhich task you want to do?\n"
                    + "\n"
                    + "1- Add\n"
                    + "2- Multiply\n"
                    + "3- Print\n"
                    + "4- Delete\n"
                    + "5- Exit\n");

            System.out.println("Please enter a digit(1-5): ");
            menu = input.nextInt();
            System.out.println("");

            switch (menu) {
                case 1:
                    System.out.println("Adding two polynomials: ");
                    MyLinkedList sumPoly = poly1.add(poly2);
                    System.out.println(sumPoly.printPolynomial());
                    break;
                case 2:
                    System.out.println("Multiplying two polynomials: ");
                    MyLinkedList multiPoly = poly1.multiply(poly2);
                    System.out.println(multiPoly.printPolynomial());
                    break;
                case 3:
                    System.out.println("The polynomials are: ");
                    System.out.println(poly1.printPolynomial());
                    System.out.println(poly2.printPolynomial());
                    break;
                case 4:
                    System.out.println("Which power you want to be deleted from both polynomials: ");
                    int pow = input.nextInt();

                    System.out.print("first polynomial: ");
                    poly1.removeWithGivenPower(pow);

                    System.out.print("second polynomial: ");
                    poly2.removeWithGivenPower(pow);
                    break;
                default:
                    System.out.println("Exiting the program...");
                    break;
            }
            System.out.println("---------------------------------------------------");
        } while (menu < 5);
    }

}
