package com.fclass;

public class CustomHashMap<K,V> {

    //Total no of the linked lists this HashMap can have
    private final int INITIAL_CAPACITY= 16;
    private Node<K,V>[] bucket ; //this is the array that will be the head node of each eventual linked list


    //An array of 16 is made when no size is mentioned
    public CustomHashMap(){
        this.bucket = new Node[INITIAL_CAPACITY];

    }

    //Constructor for custom size array
    public CustomHashMap(int size){
        this.bucket = new Node[size];
    }

}
