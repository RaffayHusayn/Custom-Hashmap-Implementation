package com.fclass;

public class CustomHashMap<K,V> {

    //Total no of the linked lists this HashMap can have
    private int initialCap = 16;
    private Node<K,V>[] bucket ; //this is the array that will be the head node of each eventual linked list
    private int hashIndex;

    //An array of 16 is made when no size is mentioned
    public CustomHashMap(){
        this.bucket = new Node[initialCap];

    }

    //Constructor for custom size array
    public CustomHashMap(int size){
        this.initialCap = size;
        this.bucket = new Node[size];
    }

    //put method for inserting key value pair in the hashmap
    public void put(K key, V val){
    Node<K,V> node = new Node<>(key, val);



    //IMPORTANT: USING BITWISE AND OPERATOR (&) INSTEAD OF MODULUS TO DEAL WITH NEGATIVE HASHCODE VALUES
    this.hashIndex = node.hashCode() & (initialCap -1); //this is Bitwise AND operator

    }

    public int getHashIndex() {
        return hashIndex;
    }
}
