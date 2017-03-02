package com.magic.maoshaco;

import com.magic.maoshaco.matrix.ArrayMatrix;
import com.magic.maoshaco.matrix.Matrix;

public class MiningApplication {

    public static void main(String[] args) {
        ArrayMatrix matrix = new ArrayMatrix(new double[][]{
                {190, 98, 80, 120, 36.6, 72, 5, 2, 72, 91, 84, 58, 225, 39},
                {178, 82, 90, 132, 36.7, 74, 6, 3, 91, 92, 170, 62, 150, 45},
                {194, 84, 82, 124, 36.8, 71, 6, 4, 89, 92, 140, 47, 300, 49},
                {178, 74, 82, 126, 36.6, 70, 5, 6, 72, 93, 132, 49, 235, 40},
                {168, 67, 80, 121, 36.5, 72, 6, 7, 67, 99, 110, 54, 160, 44},
                {172, 70, 84, 132, 36.8, 69, 5, 5, 92, 91, 90, 56, 290, 48},
                {180, 78, 90, 138, 36.9, 72, 6, 5, 90, 89, 156, 62, 215, 39},
                {179, 72, 92, 138, 36.6, 73, 7, 6, 81, 90, 88, 56, 170, 44},
                {164, 67, 94, 140, 36.7, 72, 4, 4, 82, 87, 90, 54, 289, 48},
                {163, 57, 81, 122, 36.7, 71, 4, 3, 76, 98, 120, 62, 220, 40},
                {177, 67, 82, 122, 36.7, 70, 5, 7, 78, 89, 160, 60, 156, 45},
                {182, 83, 90, 130, 36.7, 72, 6, 5, 67, 90, 98, 48, 283, 49},
                {179, 84, 80, 121, 36.6, 71, 7, 7, 56, 92, 120, 52, 218, 40},
                {185, 83, 79, 122, 36.8, 70, 6, 8, 59, 91, 164, 61, 168, 44},
                {190, 94, 91, 136, 36.8, 69, 5, 9, 90, 95, 110, 48, 296, 49},
                {185, 87, 81, 121, 36.9, 73, 5, 10, 80, 96, 142, 49, 232, 40},
                {189, 91, 84, 123, 36.5, 74, 4, 7, 76, 97, 158, 50, 152, 44},
                {162, 56, 83, 124, 36.6, 72, 6, 8, 69, 98, 134, 54, 274, 48},
                {164, 58, 85, 125, 36.7, 71, 7, 6, 59, 95, 98, 52, 200, 39},
                {158, 52, 80, 120, 36.8, 71, 5, 7, 91, 96, 120, 53, 154, 45},
                {196, 79, 86, 127, 36.7, 72, 4, 8, 73, 96, 110, 55, 300, 49},
                {175, 73, 85, 126, 36.6, 73, 5, 9, 78, 90, 145, 56, 220, 40},
                {164, 59, 81, 121, 36.7, 72, 4, 2, 87, 93, 165, 57, 160, 44},
                {189, 93, 80, 120, 36.8, 71, 5, 3, 59, 92, 170, 58, 288, 49},
                {187, 82, 82, 122, 36.9, 72, 4, 4, 58, 93, 88, 53, 154, 39},
                {191, 95, 89, 130, 37.0, 73, 5, 5, 62, 94, 90, 54, 230, 45}
        });
        byCorrelation(matrix, false);
        System.out.println(matrix);
    }

    public static void byCorrelation(Matrix m, boolean saveNegatives) {
        double totalSum = 0;

        // Generate the total value in each row and column.
        double[] rowSums = new double[m.rows()];
        double[] colSums = new double[m.columns()];
        for (int i = 0; i < m.rows(); ++i) {
            for (int j = 0; j < m.columns(); ++j) {
                totalSum += m.get(i, j);
                colSums[j] += m.get(i, j);
                rowSums[i] += m.get(i, j);
            }
        }

        // Use the row and column totals to compute the correlation.
        for (int i = 0; i < m.rows(); ++i) {
            for (int j = 0; j < m.columns(); ++j) {
                double newVal =
                        (totalSum * m.get(i, j) - rowSums[i] * colSums[j]) /
                                Math.sqrt(rowSums[i] * (totalSum - rowSums[i]) *
                                        colSums[j] * (totalSum - colSums[j]));

                // Store the computed value.
                if (saveNegatives)
                    m.set(i, j, newVal);
                else
                    m.set(i, j, newVal > 0 ? newVal : 0);
            }
        }
    }
}
