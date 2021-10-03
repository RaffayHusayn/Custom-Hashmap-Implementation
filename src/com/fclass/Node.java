package com.fclass;

import java.util.Objects;

public class Node<K, V> {
    private final K key;
    private V value;
    private Node<K,V> next;
    private int hash;

    // Constructor
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.hash = key.hashCode();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(getKey(), node.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }
}
