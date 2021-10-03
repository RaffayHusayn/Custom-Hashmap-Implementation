package com.fclass;

public class Main {

    public static void main(String[] args) {
	// write your code here

        CustomHashMap<Integer, String> head = new CustomHashMap<>(116);
        head.put(1212123 , "Ali");
        System.out.println(head.getHashIndex());
    }
}
