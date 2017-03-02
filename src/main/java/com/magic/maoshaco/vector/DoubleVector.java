package com.magic.maoshaco.vector;

/**
 * Created by Mao Shaco on 3/2/2017.
 */
public interface DoubleVector extends Vector<Double> {


    double add(int index, double delta);


    double get(int index);

    Double getValue(int index);

    void set(int index, double value);

    double[] toArray();
}