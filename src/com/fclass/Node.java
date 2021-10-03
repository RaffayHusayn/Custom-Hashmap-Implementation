package com.fclass;

public class Node<K, V> {
    private final K key;
    private V value;
    private Node<K,V> next;

    // Constructor
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //Getter
    public K getKey(){
        return key;
    }

    public V getValue() {
        return value;
    }
   //Setter for value but not for Key because key can never change
    public void  setValue(V value){
        this.value = value;
    }
}
