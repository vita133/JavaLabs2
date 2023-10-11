package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MatrixCalculator matrixCalculator = new MatrixCalculator(3, 3, -10.9F, 5.5F);
        matrixCalculator.calculate();
    }
}
