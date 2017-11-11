package com.company;

import java.awt.*;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {


//    private static Stack<Log> editHistory = new Stack<>();


    public static void main(String[] args) {


//  When a user inputs a string that string should be saved into the edit history.
//  When they copy, the last string stored in the edit history should be re-entered into the history.
// When they delete the last string should be removed.
//  When they undo the last string removed should be added back into the history again.
//     And when they quit the program should terminate.


        Stack<String> editHistory = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Input a String");


        String userInput = input.nextLine();

        editHistory.push((userInput));

        System.out.println("");

        String holdsLastPop = " ";

        int zero = 0;
        while (zero < 1) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("What would like to do with is String? Copy, Undo , Delete , Edit, or  Quit");
            String userInput2 = input2.next().toLowerCase();
            try {
                switch (userInput2) {

                    case "copy":
                        System.out.println(editHistory.peek());
                        editHistory.push(userInput);
                        break;
                    case "undo":
                        System.out.println(editHistory.peek());
                        editHistory.push(holdsLastPop);
                        break;
                    case "delete":
//                    System.out.println(editHistory.peek());
                        holdsLastPop = String.valueOf(editHistory.pop());
                        System.out.println(holdsLastPop);
                        editHistory.pop();
                        break;
                    case "quit":
                        System.out.println("You Last String was :"+ editHistory.peek());
                        System.out.println("Good bye : P ");
                        zero = 1;
                        break;
                    case "edit":
                        System.out.println("This is your current String: " + editHistory.peek());
                        System.out.println("Would you like to  change  this string or  add onto to the string ?");
                        Scanner input3 = new Scanner(System.in);
                        String userInput3 = input3.nextLine().toLowerCase();

                        if (userInput3.equals("change")) {
                            System.out.println("Type what you want to change,make sure spelling matches what's  shown in string");
                            Scanner input4 = new Scanner(System.in);
                            String userInput4 = input4.nextLine().toLowerCase();
                            System.out.println("What would you like to change it into");
                            Scanner input5 = new Scanner(System.in);
                            String userInput5 = input5.nextLine();
                            String replacement = userInput5;
                            String replaceString = editHistory.peek().replace(userInput4, replacement);
                            editHistory.push(replaceString);
                            System.out.println("Awesome this is your new String :  " + replaceString);
                        } else if (userInput3.equals("add")) {
                            System.out.println("Type what you will like to add?");
                            String add = input3.nextLine();
                            String newString = editHistory.peek() + "" + add;
                            System.out.println("Your new String is :  " + newString);
                            editHistory.push(newString);

                        }
                        break;

                    default:
                        System.out.println("Check for spelling and Pick one of the fallowing");
                        break;
                }
            } catch (EmptyStackException e) {
                System.out.println("Error.. History is empty!! ");
            }
        }






    }
}
