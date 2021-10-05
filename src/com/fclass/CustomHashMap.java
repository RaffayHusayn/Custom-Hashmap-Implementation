package com.fclass;

public class CustomHashMap<K, V> {

    //Total no of the linked lists this HashMap can have
    private int initialCap = 16;
    private Node<K, V>[] bucket; //this is the array that will be the head node of each eventual linked list
    private int hashIndex;

    //An array of 16 is made when no size is mentioned
    public CustomHashMap() {
        this.bucket = new Node[initialCap];

    }

    //Constructor for custom size array
    public CustomHashMap(int size) {
        this.initialCap = size;
        this.bucket = new Node[size];
    }


    //----------------PUT METHOD-------------- for inserting key value pair in the hashmap
    public void put(K key, V val) {

        Node<K, V> nodeToEnter = new Node<>(key, val);

        //IMPORTANT: USING BITWISE AND OPERATOR (&) INSTEAD OF MODULUS TO DEAL WITH NEGATIVE HASHCODE VALUES
        if (key == null) {
            this.hashIndex = 0;
            bucket[hashIndex] = nodeToEnter; // always override the last null value, no linked list here
        } else {
            this.hashIndex = nodeToEnter.hashCode() & (initialCap - 1); //this is Bitwise AND operator
            if (hashIndex == 0) {
                hashIndex++; //because index =0  is reserved for null key
            }


            //First see what's at the HashIndex
            Node<K, V> nodeToCheck = bucket[hashIndex];
            if (nodeToCheck == null) {
                bucket[hashIndex] = nodeToEnter;
            } else {

                while (nodeToCheck.next != null) {
                    if (nodeToCheck.getKey().equals(key)) {

                        nodeToCheck.setValue(val);
                        return;
                    }

                    nodeToCheck = nodeToCheck.next;
                }

                //checking the last Node because we aren't doing that in the loop

                if (nodeToCheck.getKey().equals(key)) {
                    nodeToCheck.setValue(val);
                    return;
                }


                nodeToCheck.next = nodeToEnter;
            }

        }

    }


    //----------------GET METHOD-------------- for retrieving key value pair from the hashmap
    public V get(K key) {

        Node<K, V> tempNode = new Node<>(key, null);
        int checkIndex;
        if (key == null) {
            return bucket[0].getValue();
        } else {
            checkIndex = tempNode.hashCode() & (initialCap - 1); //this is Bitwise AND operator
            if (checkIndex == 0) {
                checkIndex++; //because index =0  is reserved for null key
            }
        }
        tempNode = bucket[checkIndex];


        //this handles if there hasn't been any entries on that index before like if
        //index 0 has no node then tempNode will be null and throws a null exception
        //if we dont check it before hand
        if (tempNode == null) {
            return null;
        }
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode.getValue();
            }
            tempNode = tempNode.next;
        }


        return null;

    }


    //----------------REMOVE METHOD-------------- for removing key value pair from the hashmap and returing the removed Node

    public Node<K, V> remove(K key) {
        Node<K, V> tempNode = new Node<>(key, null);
        int removeIndex;
        if (key == null) {
            removeIndex = 0;
            tempNode = bucket[removeIndex];
            bucket[removeIndex] = null;
            return tempNode;
        } else {

            removeIndex = tempNode.hashCode() & (initialCap - 1); //this is Bitwise AND operator
            if (removeIndex == 0) {
                removeIndex++; //because index =0  is reserved for null key
            }
            tempNode = bucket[removeIndex];


            //this if statement checks if there's any Node at the particular removeIndex of the argument given to the remove Method
            //only executes when there's no linkedList at the index
            if (tempNode == null) {
                System.out.println("nothing to remove");
                return null;
            }

            if(tempNode.getKey().equals(key)){
                bucket[removeIndex] = tempNode.next;
                tempNode.next = null;
                return tempNode;
            }

            Node<K,V> prev = tempNode;
            tempNode = tempNode.next;

            while(tempNode != null){
                if(tempNode.getKey().equals(key)){
                    prev.next = tempNode.next;
                    tempNode.next = null;
                    return tempNode;
                }
                //incrementing for while loop
                prev = tempNode;
                tempNode = tempNode.next;
            }

        }
        return null;
    }


    public int getHashIndex() {
        return hashIndex;
    }

    public void printAll() {

        for (int i = 0; i < initialCap; i++) {

            Node<K, V> n = bucket[i];
            if (n == null) {
                System.out.println("nothing on Index : " + i);
            } else {
                System.out.println("Values on Index : " + i);
                while (n.next != null) {
                    System.out.println(n.getValue());
                    n = n.next;
                }

                System.out.println(n.getValue());
            }
        }


    }
}
