package org.Servise;

import org.Exception.IndexNotFoundException;
import org.Interface.StringList;


public class MyStringList implements StringList {

private final  int SIZE=10;
private  String[] stringArray=new String[SIZE];
private  int pointer=0;
    @Override
    public String add(String item) {
        if(pointer==stringArray.length-1){
            toArray(pointer*2);}
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i]==null){
                stringArray[i]=item;
            }
        }pointer++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if(pointer==stringArray.length-1){
            toArray(pointer*2);}
        if (index>stringArray.length){throw new IndexNotFoundException();}
        else{
        String[] addArray=new String[stringArray.length];
        for (int i = index+1; i < stringArray.length; i++) {
           addArray[i]=stringArray[i-1];
        }stringArray[index]=item;
        for (int i = index+1; i < stringArray.length; i++) {
stringArray[i]=addArray[i];
        }}
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index>=stringArray.length){throw new IndexNotFoundException();}
        else{stringArray[index]=item;}
        return item;
    }

    @Override
    public String remove(String item) {
        int index=0;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].equals(item)){index=i;}
        }
        for (int i = index; i < stringArray.length; i++) {
stringArray[i]=stringArray[i+1];
        }stringArray[pointer]=null;
        pointer--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index>=stringArray.length){throw new IndexNotFoundException();}
        String item=stringArray[index];
        for (int i = index; i < stringArray.length; i++) {
            stringArray[i]=stringArray[i+1];
        }stringArray[pointer]=null;
        pointer--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        boolean cont=true;
        for (String s : stringArray) {
            cont = s.equals(item);
        }

        return cont;
    }

    @Override
    public int indexOf(String item) {
        int index=-1;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].equals(item)){index=i;}
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index=-1;
        for (int i = stringArray.length-1; i > 0; i--) {
            if(stringArray[i].equals(item)){index=i;}
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index>=stringArray.length){throw new IndexNotFoundException();}
        String getI=stringArray[index];
        return getI;
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean e=true;
        if (this == otherList) e=true;
        if (otherList == null || getClass() != otherList.getClass()) e=false;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].contains( otherList.get(1))){e=true;}
            else {e=false;}
        }
        return e;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        boolean e=true;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i]!=null){e=false;}
        }
        return e;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i]=null;
        }
    }

    @Override
    public void toArray(int newLength) {
        String[] newArray=new String[newLength];
        System.arraycopy(stringArray, 0, newArray, 0, pointer);
        stringArray=newArray;
    }
}
