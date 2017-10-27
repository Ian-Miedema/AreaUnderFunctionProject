package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        //sets up the input stream reader and buffered reader to get user input

        Scanner sc = new Scanner(System.in);
        //sets up the scanner to get user input

        /*
        note: this program uses both the scanner for numbers and the input stream reader/buffered reader for string answers.
        This is because using the buffered reader fixed a glitch, but the scanner is better suited to get numbers.
        */

        AreaBtwn Area = new AreaBtwn();
        //allows the main class to call methods from the AreaBtwn class

        boolean cont = true;            //used to continue the while loop
        boolean rad;                    //used to determine if the user want
        double a;                       //the slope of the linear equation, the a-value of the quadratic equation, and the vertical stretch/compression of the sine and cosine functions
        double b;                       //the vertical shift of the linear equation, the b-value of the quadratic equation, the horizontal stretch/compression of the sine and cosine functions
        double c;                       //the c-value of the quadratic equation and the horizontal translation of the sine and cosine functions
        double d;                       //the vertical translation of the sine and cosine functions
        double Dom;                     //the variable for the first domain value
        double Dom2;                    //the variable for the second domain value
        double g;                       //the variable for the g(x) function
        int iterations;                 //the variable that determines the number of iterations
        double deg;                     //the variable used to display the equation if the user uses degrees (when the user chooses degrees the d variable is changed to radians)
        String ans;                     //the variable to get the users answer when a string answer is needed
        ABFunctions f;                  //allows the enumerated type to be used in the main class
        //-------------------------------------------------------------------
        //initializes all the variables needed
        //

        System.out.println("This program is used to calculate the area from one function, known as f(x), to another function, g(x), between two domain values.\n" +
                "The g(x) function is a straight line while the f(x) function can be a linear function, a quadratic function, or a sinusoidal function.");
        //describes the purpose of the program

        while (cont) {

            System.out.println("Please enter the type of function you wish to use for your f(x) function\n" +
                    "The options are:\n" +
                    "1: Linear\n" +
                    "2: Quadratic\n" +
                    "3: Sine\n" +
                    "4: Cosine");
            String Num = br.readLine();
            //-------------------------------------------------------------------
            //first asks which type of function the user wants and provides them options, then reads their answer
            //

            switch (Num){
                case "1":
                    f = ABFunctions.LINEAR;
                    break;
                case "2":
                    f = ABFunctions.QUADRATIC;
                    break;
                case "3":
                    f = ABFunctions.SINE;
                    break;
                case "4":
                    f = ABFunctions.COSINE;
                    break;
                default:
                    f = ABFunctions.INVALID;
                    break;
            }
            //changes the number answer to the enumerated

            switch (f) {
                case LINEAR:

                    System.out.println("For the equation f(x) = mx + b");

                    System.out.println("Please enter the slope (m value) of the f(x) function");
                    a = sc.nextDouble();
                    //------------------------------------------------------------
                    //The block above asks for and then sets the slope of the function based on user input
                    //

                    System.out.println("Please enter the vertical shift (b value) of the f(x) function");
                    b = sc.nextDouble();
                    //------------------------------------------------------------
                    //The block above asks for and then sets the vertical shift of the function based on user input
                    //

                    System.out.println("Please enter the domain of which the area should be calculated.\nthe lower domain: ");
                    Dom = sc.nextDouble();
                    System.out.println("the upper domain: ");
                    Dom2 = sc.nextDouble();
                    if (Dom >= Dom2){
                        System.out.println("the lower domain must be a lower value than the upper domain");
                        break;
                    }
                    Area.setDomain(Dom, Dom2);
                    //------------------------------------------------------------
                    //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                    //

                    System.out.println("Please enter the value of the g(x) function");
                    g = sc.nextDouble();
                    Area.set_Gx(g);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the g(x) value based on user input
                    //

                    System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                    iterations = sc.nextInt();
                    Area.setIterations(iterations);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the number of iterations based on user input
                    //

                    System.out.println("Your f(x) equation is: f(x) = " + a + "x + " + b +
                            " and your g(x) equation is: g(x) = " + g);
                    System.out.println("The area between the two functions is " + Area.CalcAreaBetween(a, b) + " units squared");
                    //------------------------------------------------------------
                    //confirms the equation then states the area under the line between the domain
                    //

                    //Area.asdf(f); was used for testing

                    break;
                case QUADRATIC:

                    System.out.println("For the equation y = a(x-h)^2 + c");

                    System.out.println("Please enter the a-value of the equation");
                    a = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the a-value based on user input
                    //

                    System.out.println("Please enter the h-value of the equation");
                    b = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the b-value based on user input
                    //

                    System.out.println("Please enter the c-value of the equation");
                    c = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the c-value based on user input
                    //

                    System.out.println("Please enter the domain of which the area should be calculated.\nthe lower value: ");
                    Dom = sc.nextDouble();
                    System.out.println("the upper value: ");
                    Dom2 = sc.nextDouble();
                    if (Dom >= Dom2){
                        System.out.println("the lower domain must be a lower value than the upper domain");
                        break;
                    }
                    Area.setDomain(Dom, Dom2);
                    //------------------------------------------------------------
                    //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                    //

                    System.out.println("Please enter the value of the g(x) function");
                    g = sc.nextDouble();
                    Area.set_Gx(g);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the g(x) value based on user input
                    //

                    System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                    iterations = sc.nextInt();
                    Area.setIterations(iterations);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the number of iterations based on user input
                    //

                    System.out.println("Your f(x) equation is: f(x) = " + a + "x^2 + " + b + "x + " + c +
                            " and your g(x) equation is: g(x) = " + g);
                    System.out.println("The area between the two functions is " + Area.CalcAreaBetween(a, b, c) + " units squared");
                    //------------------------------------------------------------
                    //confirms the equation then states the area under the line between the domain
                    //

                    break;
                case SINE:

                    System.out.println("For the equation y = a*sin(k(x-d)) + c");

                    System.out.println("Do you want to use radians?\nType 'y' to use radians");
                    ans = br.readLine();
                    if (ans.equalsIgnoreCase("y")){
                        rad = true;
                    }
                    else {
                        rad = false;
                    }

                    System.out.println("Please enter the a-value of the equation");
                    a = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the a-value based on user input
                    //

                    System.out.println("Please enter the k-value of the equation");
                    b = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the b-value based on user input
                    //

                    System.out.println("Please enter the d-value of the equation");
                    c = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the c-value based on user input
                    //

                    System.out.println("Please enter the c-value of the equation");
                    d = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the c-value based on user input
                    //

                    System.out.println("Please enter the domain of which the area should be calculated.\nthe lower value: ");
                    Dom = sc.nextDouble();
                    System.out.println("the upper value: ");
                    Dom2 = sc.nextDouble();
                    if (Dom >= Dom2){
                        System.out.println("the lower domain must be a lower value than the upper domain");
                        break;
                    }

                    deg = d;
                    if (rad) {
                        Area.setDomain(Dom, Dom2);
                    }
                    else {
                        Dom = Math.toRadians(Dom);
                        Dom2 = Math.toRadians(Dom2);
                        c = Math.toRadians(c);
                        Area.setDomain(Dom, Dom2);
                    }
                    //------------------------------------------------------------
                    //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                    //It then looks at if the user is using radians or degrees, if they are using degrees it sets the values of the domains and the d variable to radians
                    //

                    System.out.println("Please enter the value of the g(x) function");
                    g = sc.nextDouble();
                    Area.set_Gx(g);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the g(x) value based on user input
                    //

                    System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                    iterations = sc.nextInt();
                    Area.setIterations(iterations);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the number of iterations based on user input
                    //

                    System.out.println("Your f(x) equation is: f(x) = " + a + "x*sin(" + b + "(x - " + deg + ") + " + c +
                            " and your g(x) equation is: g(x) = " + g);
                    System.out.println("The area under the function is " + Area.CalcAreaBetween(f, a, b, c, d) + " units squared");
                    //------------------------------------------------------------
                    //confirms the equation then states the area under the line between the domain
                    //

                    break;
                case COSINE:

                    System.out.println("For the equation y = a*sin(k(x-d)) + c");

                    System.out.println("Do you want to use radians?\nType 'y' to use radians");
                    ans = br.readLine();
                    if (ans.equalsIgnoreCase("y")){
                        rad = true;
                    }
                    else {
                        rad = false;
                    }

                    System.out.println("Please enter the a-value of the equation");
                    a = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the a-value based on user input
                    //

                    System.out.println("Please enter the k-value of the equation");
                    b = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the b-value based on user input
                    //

                    System.out.println("Please enter the d-value of the equation");
                    c = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the c-value based on user input
                    //

                    System.out.println("Please enter the c-value of the equation");
                    d = sc.nextDouble();
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the c-value based on user input
                    //

                    System.out.println("Please enter the domain of which the area should be calculated.\nthe lower value: ");
                    Dom = sc.nextDouble();
                    System.out.println("the upper value: ");
                    Dom2 = sc.nextDouble();
                    if (Dom >= Dom2){
                        System.out.println("the lower domain must be a lower value than the upper domain");
                        break;
                    }

                    deg = d;
                    if (rad) {
                        Area.setDomain(Dom, Dom2);
                    }
                    else {
                        Dom = Math.toRadians(Dom);
                        Dom2 = Math.toRadians(Dom2);
                        c = Math.toRadians(c);
                        Area.setDomain(Dom, Dom2);
                    }
                    //------------------------------------------------------------
                    //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                    //It then looks at if the user is using radians or degrees, if they are using degrees it sets the values of the domains and the d variable to radians
                    //

                    System.out.println("Please enter the value of the g(x) function");
                    g = sc.nextDouble();
                    Area.set_Gx(g);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the g(x) value based on user input
                    //

                    System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                    iterations = sc.nextInt();
                    Area.setIterations(iterations);
                    //-------------------------------------------------------------------
                    //The block above asks for and then sets the number of iterations based on user input
                    //

                    System.out.println("Your f(x) equation is: f(x) = " + a + "x*sin(" + b + "(x - " + deg + ") + " + c +
                            " and your g(x) equation is: g(x) = " + g);
                    System.out.println("The area under the function is " + Area.CalcAreaBetween(f, a, b, c, d) + " units squared");
                    //------------------------------------------------------------
                    //confirms the equation then states the area under the line between the domain
                    //

                    break;
                case INVALID:
                    System.out.println("Error, number chosen is not an option");
                    break;
                // The default deals with all options aside from the ones given. It tells the user that their choice is invalid then breaks
            }// end of switch

            System.out.println("Do you want to continue?");
            //asks if the user wishes to go through the program again

            ans = br.readLine();
            //gets the users answer

            if (ans.equalsIgnoreCase("no")){
                cont = false;
                //checks to see if the user said to stop
            }// end of if

            Area.resetData();
        }// end of while
    }
}
