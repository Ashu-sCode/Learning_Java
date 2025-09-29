package maths;

public class basicCalc {
    
    public long addition(int num1, int num2){

        return num1 + num2;     

    }

    public long substraction(int num1, int num2){

        return num1 - num2;     

    }

    public long multiplication(int num1, int num2){

        return num1 * num2;     

    }

    public double division(int num1, int num2){

        if(num2 == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return (double) num1 / num2;     

    }

    

}
