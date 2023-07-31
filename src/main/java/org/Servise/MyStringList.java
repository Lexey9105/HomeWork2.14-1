package org.Servise;

import org.Exception.IndexNotFoundException;
import org.Interface.IntegerList;


public class MyStringList implements IntegerList {

private final  int SIZE=10;
private  Integer[] stringArray=new Integer[SIZE];
private  int pointer=0;
    @Override
    public Integer add(Integer item) {
        if(pointer==stringArray.length-1){
            extension(pointer*2);}
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i]==null){
                stringArray[i]=item;
            }
        }pointer++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if(pointer==stringArray.length-1){
            extension(pointer*2);}
        if (index>stringArray.length){throw new IndexNotFoundException();}
        else{
            Integer[] addArray=new Integer[stringArray.length];
        for (int i = index+1; i < stringArray.length; i++) {
           addArray[i]=stringArray[i-1];
        }stringArray[index]=item;
        for (int i = index+1; i < stringArray.length; i++) {
stringArray[i]=addArray[i];
        }}
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index>=stringArray.length){throw new IndexNotFoundException();}
        else{stringArray[index]=item;}
        return item;
    }

    @Override
    public Integer remove(Integer item) {
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
    public Integer remove(int index) {
        if (index>=stringArray.length){throw new IndexNotFoundException();}
        Integer item=stringArray[index];
        for (int i = index; i < stringArray.length; i++) {
            stringArray[i]=stringArray[i+1];
        }stringArray[pointer]=null;
        pointer--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy= toArray();
        mergeSort(storageCopy);
    return binarySearch(storageCopy,item);}

    @Override
    public int indexOf(Integer item) {
        int index=-1;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].equals(item)){index=i;}
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int index=-1;
        for (int i = stringArray.length-1; i > 0; i--) {
            if(stringArray[i].equals(item)){index=i;}
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        if (index>=stringArray.length){throw new IndexNotFoundException();}
        Integer getI=stringArray[index];
        return getI;
    }

    @Override
    public boolean equals(IntegerList otherList) {
        boolean e=true;
        if (this == otherList) e=true;
        if (otherList == null || getClass() != otherList.getClass()) e=false;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].equals( otherList.get(1))){e=true;}
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
    public Integer[] toArray() {
        Integer[] storageCopy=new Integer[stringArray.length];
        System.arraycopy(stringArray, 0, storageCopy, 0, stringArray.length);
    return storageCopy;
    }
    @Override
    public void extension(int newLength) {
        Integer[] newArray=new Integer[newLength];
        System.arraycopy(stringArray, 0, newArray, 0, pointer);
        stringArray=newArray;
    }
    @Override
    public  Integer[] mSort(){Integer[] storageCopy= toArray();
        mergeSort(storageCopy);
        return stringArray=storageCopy;}

    public  static void mergeSort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }



    public static void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean binarySearch(Integer[] arr, Integer items) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (items == arr[mid]) {
                return true;
            }

            if (items < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
