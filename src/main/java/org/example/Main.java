package org.example;


import org.Interface.IntegerList;
import org.Servise.MyStringList;

public class Main {
    public static void main(String[] args) {

        IntegerList ints=new MyStringList();
        ints.add(9);
        ints.add(1,5);
        ints.add(2,11);
        ints.add(3,7);
        ints.add(4,1);

        ints.mSort();
        System.out.println(ints.get(0));
    }
}