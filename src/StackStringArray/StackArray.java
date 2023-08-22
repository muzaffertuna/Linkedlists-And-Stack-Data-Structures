/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StackStringArray;

/**
 *
 * @author tokta
 */
public class StackArray {

    private String[] data; // array to hold items
    private int top; // the top most item index

    public StackArray(int size) {
        data = new String[size];
        top = -1;
    }

    private boolean isEmpty() {
        return (top == - 1);
    }

    private boolean isFull() {
        return (top == data.length - 1);
    }

    private int size() {
        return (top + 1);
    }

    public void push(String element) {
        if (isFull()) {
            resize(data.length * 2);   // double size of array if necessary
        }

        top++;
        data[top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            top--;
            return data[top + 1];
        }
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];

        for (int i = 0; i <= top; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void printStack() {
        if (isEmpty()) {
            return;
        }

        String temp = pop();
        System.out.print(temp + " ");
        printStack();
        push(temp);
    }

    public boolean isPalindrome() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        StackArray tempStack = new StackArray(this.size());

        String normal = "";
        String reverse = "";

        while (!this.isEmpty()) {
            String s = this.pop();
            tempStack.push(s);
            reverse = reverse + s;
        }

        while (!tempStack.isEmpty()) {
            String s = tempStack.pop();
            this.push(s);
            normal = normal + s;
        }

        return (normal.equalsIgnoreCase(reverse));
    }

    public String deleteMiddle() {
        int length = this.size();

        if (length % 2 == 1) {
            StackArray tempStack = new StackArray(length);

            for (int i = 0; i < length / 2; i++) {
                tempStack.push(this.pop());
            }

            String middleElement = this.pop();

            while (!tempStack.isEmpty()) {
                this.push(tempStack.pop());
            }
            return "The middle element(" + middleElement + ") has been deleted.";
        }
        return "There is no middle element as the size of stack is even.";
    }

}