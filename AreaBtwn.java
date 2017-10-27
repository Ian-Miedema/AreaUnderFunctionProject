package com.company;

/**
 * Created by Ian Miedema on 19/10/2017.
 */


public class AreaBtwn {

    //variables that define the f(x) equation
    private double a_value;               //the slope of the linear equation, the a-value of the quadratic equation, and the vertical stretch/compression of the sine and cosine functions
    private double b_value;               //the vertical shift of the linear equation, the b-value of the quadratic equation, the horizontal stretch/compression of the sine and cosine functions
    private double c_value;               //the c-value of the quadratic equation and the horizontal translation of the sine and cosine functions
    private double d_value;               //the vertical translation of the sine and cosine functions

    //variables that act as restrictions
    private double D1;                      //the first domain
    private double D2;                      //the second domain
    private double slice;                   //the variable used to gather the number of iterations wanted
    private double gx;                      //the variable used for the g(x) function

    //variables used to calculate the area
    private double area;                    //the variable used to add all of the rectangles together and then return the area
    private double rect;                    //the variable used to calculate the area of each iteration
    private double height;                  //the variable used to calculate the height
    private double base;                    //the variable used to calculate the base
    //-------------------------------------------
    //all variables needed are initialized above
    //

    public void resetData () {

        a_value = 0;
        b_value = 0;
        c_value = 0;
        d_value = 0;
        D1 = 0;
        D2 = 0;
        slice = 0;
        gx = 0;
        area = 0;
        rect = 0;
        height = 0;
        base = 0;

    }
    //resets all of the variables in the class

    public void set_Gx (double g) {
        gx = g;
    }
    //sets the value of the G(x) function

    public void setDomain (double Dom, double Dom2){
        D1 = Dom;
        D2 = Dom2;
    }
    //sets the first and second domain

    public void setIterations (int iterations){
        slice = iterations;
    }
    //sets the number of iterations wanted by the user

    public double CalcAreaBetween (double a, double b) {
        SetLineData(a, b);
        calcAreaLinear();
        return area;
    }
    //calculates the are underneath a linear function and returns the area

    public double CalcAreaBetween (double a, double b, double c) {
        SetQuadraticData(a, b, c);
        calcAreaQuadratic();
        return area;
    }
    //calculates the area underneath a quadratic function and returns the area

    public double CalcAreaBetween (ABFunctions f, double a, double b, double c, double d) {
        SetSinusoidalData(a, b, c, d);
        if (f == ABFunctions.LINEAR){
            calcAreaSine();
        }//if the value chosen was 3 then the user wanted to use a sine function
        else {
            calcAreaCosine();
        }//if the value chosen was not 3 then the user wanted to use a cosine function because the only other option is 4
        return area;
        //returns the calculated area
    }
    //calculates the area underneath a sinusoidal function and returns the area

    private void SetLineData (double a, double b) {
        a_value = a;
        b_value = b;
    }
    //sets the linear equation values

    private void SetQuadraticData (double a, double b, double c) {
        a_value = a;
        b_value = b;
        c_value = c;
    }
    //sets the quadratic equation values

    private void SetSinusoidalData (double a, double b, double c, double d) {
        a_value = a;
        b_value = b;
        c_value = c;
        d_value = d;
    }
    //sets the sinusoidal equation values

    private double calcAreaLinear () {

        height = a_value*D1 + b_value - gx;
        //finds the y-value at the beginning of the domain

        base = (D2-D1)/slice;
        //find how big each base there are

        for (int x = 0; x < slice; x++){
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height*base);
            //calculates the area of the rectangle by multiplying the base, which is calculated  by the height, the y-value

            D1 += base;
            //finds the x-value for the next iteration

            height = a_value*D1 + b_value - gx;
            //recalculates the y-value based on the new x-value

            area += rect;
            //adds all of the areas of the rectangles together
        }//end for loop
        return area;
        //returns the area to the main class
    }
    //calculates the area under a linear function

    private double calcAreaQuadratic () {

        height = a_value*(D1 - b_value)*(D1 - b_value) + c_value - gx;
        //finds the y-value at the beginning of the domain

        base = (D2 - D1) / slice;
        //this finds the width of the slices

        for (int i = 0; i < slice; i++) {
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height * base);
            //calculates the area of the rectangle

            D1 += base;
            //moves on to the next iteration

            height = a_value*( D1 - b_value)*(D1 - b_value) + c_value - gx;
            //recalculates the base of the new iteration

            area += rect;
            //adds all of the areas of the rectangles together to get the total area
        }//end of for loop
        return area;
        //returns the total area
    }
    //calculates the area under a quadratic function

    private double calcAreaSine () {

        height = a_value * Math.sin((b_value * (D1 - c_value))) + d_value - gx;
        //finds the y-value at the beginning of the domain


        base = (D2 - D1) / slice;
        //this finds the width of the slices


        for (int i = 0; i < slice; i++) {
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height * base);
            //calculates the area of the rectangle

            D1 += base;
            //moves on to the next iteration

            height = a_value * Math.sin((b_value * (D1 - c_value))) + d_value - gx;
            //recalculates the base of the new


            area += rect;
            //adds all of the areas of the rectangles together to get the total area
        }//end of for loop
        return area;
        //returns the total area
    }
    //calculates the area under a sine function

    private double calcAreaCosine (){

        height = a_value * Math.cos((b_value * (D1 - c_value))) + d_value - gx;
        //finds the y-value at the beginning of the domain

        base = (D2 - D1) / slice;
        //this finds the width of the slices

        for (int i = 0; i < slice; i++) {
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height * base);
            //calculates the area of the rectangle

            D1 += base;
            //moves on to the next iteration

            height = a_value * Math.cos((b_value * (D1 - c_value))) + d_value - gx;
            //recalculates the base of the new

            area += rect;
            //adds all of the areas of the rectangles together to get the total area
        }//end of for loop
        return area;
        //returns the total area
    }
    //calculates the area under a cosine function

    private void displayArea () {
        System.out.println(area);
    }
    //used for testing

    public void asdf (ABFunctions f){
        System.out.println(f);
    }
    //used for testing

}//end of class
