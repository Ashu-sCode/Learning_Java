package main;

import maths.basicCalc;

public class calculator {
    
    public static void main(String[] args) {
     
            basicCalc calc = new basicCalc();

           long sum = calc.addition(5, 3);
           System.out.println("Addition: " + sum);

          long substraction =  calc.substraction(5, 3);
            System.out.println("Substraction: " + substraction);

              long multiplication =
            calc.multiplication(4,3 );
            System.out.println("Multiplication: " + multiplication);

            double division =
            calc.division(3, 3);
            System.out.println("Division: " + division);

    }

}
