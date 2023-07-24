package org.example;

import org.Interface.StringList;
import org.Servise.MyStringList;

public class Main {
    public static void main(String[] args) {

        StringList list=new MyStringList();
        list.add("1");
        //list.add("3");
        //list.add("4");
        list.add(1,"2");
        list.add(2,"3");
        list.add(3,"5");
        list.add(3,"4");
        list.add(4,"8");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
    }
}