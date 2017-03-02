package com.magic.maoshaco.matrix;

import com.magic.maoshaco.vector.DoubleVector;

/**
 * Created by Mao Shaco on 3/2/2017.
 */
public interface Matrix {

    double get(int row, int col);

    double[] getColumn(int column);

    double[] getRow(int row);

    DoubleVector getRowVector(int row);

    int columns();

    double[][] toDenseArray();

    int rows();

    void set(int row, int col, double val);

    void setColumn(int column, double[] values);

    void setColumn(int column, DoubleVector values);

    void setRow(int row, double[] values);

    void setRow(int row, DoubleVector values);
}
