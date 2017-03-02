package com.magic.maoshaco.vector;

/**
 * Created by Mao Shaco on 3/2/2017.
 */
public interface Vector<T extends Number> {


    boolean equals(Object o);


    Number getValue(int index);


    int hashCode();


    int length();

    double magnitude();

    void set(int index, Number value);
}