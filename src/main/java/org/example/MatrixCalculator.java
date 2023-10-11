package org.example;

import java.util.Random;

public class MatrixCalculator {
    private float[][] matrix;

    public MatrixCalculator(int rows, int cols, float minValue, float maxValue) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive");
        }
        matrix = generateRandomMatrix(rows, cols, minValue, maxValue);
    }

    public static float[][] generateRandomMatrix(int rows, int cols, float minValue, float maxValue) {
        float[][] generatedMatrix = new float[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                generatedMatrix[i][j] = minValue + random.nextFloat() * (maxValue - minValue);
            }
        }
        return generatedMatrix;
    }

    public void printMatrix() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}

