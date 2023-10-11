package org.example;

import java.util.Random;

public class MatrixCalculator {
    private final float[][] matrix;
    private final float[][] matrixTranspose;

    public MatrixCalculator(int rows, int cols, float minValue, float maxValue) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive");
        }
        matrix = generateRandomMatrix(rows, cols, minValue, maxValue);
        matrixTranspose = new float[cols][rows];
    }

    private float[][] generateRandomMatrix(int rows, int cols, float minValue, float maxValue) {
        float[][] generatedMatrix = new float[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                generatedMatrix[i][j] = minValue + random.nextFloat() * (maxValue - minValue);
            }
        }
        return generatedMatrix;
    }

    private void transposeMatrix() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                matrixTranspose[i][j] = matrix[j][i];
            }
        }
    }

    private float findRowMaxSums() {
        int rows = matrixTranspose.length;
        int cols = matrixTranspose[0].length;
        float result = 0.0F;

        for (int i = 0; i < rows; i++) {
            float max = Float.NEGATIVE_INFINITY;
            for (int j = 0; j < cols; j++) {
                if (matrixTranspose[i][j] > max) {
                    max = matrixTranspose[i][j];
                }
            }
            result += max;
        }
        return result;
    }

    public void calculate(){
        printMatrix(matrix);
        transposeMatrix();
        printMatrix(matrixTranspose);
        System.out.println(findRowMaxSums());
    }
    private void printMatrix(float[][] matrix) {
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

