package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    int x1;
    int x2;
    int y1;
    int y2;
    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2) { // <--add 2 string parameters to this constructor
        x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 1, coord1.indexOf(")")));
        x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 1, coord2.indexOf(")")));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
    public void setX1(int newX1) {
        x1 = newX1;
    }
    public void setY1(int newY1) {
        y1 = newY1;
    }
    public void setX2(int newX2) {
        x2 = newX2;
    }
    public void setY2(int newY2) {
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance() {
        int xDist = Math.abs(x2 - x1);
        int yDist = Math.abs(y2 - y1);
        return roundedToHundredth(Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)));
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt() {
        double intercept;
        if (slope() != -999.99) {
            if (y1 != 0 || y2 != 0) {
                if (y1 >= 0) {
                    intercept = y1 - slope() * x1;
                } else {
                    intercept = y1 - slope() * x1;
                }
            } else if (y1 == 0 && y2 != 0) {
                intercept = y1;
            } else {
                intercept = y2;
            }
        } else {
            intercept = -999.99;
        }
        return roundedToHundredth(intercept);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope() {
        double slope = ((double) (y2 - y1)) / ((double) (x2 - x1));
        if (x2 == x1) {
            return -999.99;
        } else {
            return roundedToHundredth(slope);
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation() {
        String yIntercept = Double.toString(yInt());
        if (slope() != 0 && slope() != -999.99) {
            if (yInt() < 0 ) {
                return "y=" + slope() + "x-" + yIntercept.substring(1);
            } else if (yInt() == 0) {
                return "y=" + slope() + "x";
            } else {
                return "y=" + slope() + "x+" + yInt();
            }
        } else if (slope() == -999.99) {
                return "undefined"; 
        } else {
            if (yInt() < 0 ) {
                return "y=" + yIntercept.substring(1);
            } else if (yInt() == 0) {
                return "y=" + 0;
            } else {
                return "y=" + yInt();
            }
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x) {
        if (x > 0) {
            return ((int) ((x * 100) + 0.5)) / 100.0;
        } else if (x < 0) {
            return ((int) ((x * 100) - 0.5)) / 100.0;
        } else {
            return 0;
        }
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}