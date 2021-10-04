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






    //----------------PUT METHOD-------------- for inserting key value pair in the hashmap
    public void put(K key , V val){

    Node<K,V> nodeToEnter = new Node<>(key, val);

    //IMPORTANT: USING BITWISE AND OPERATOR (&) INSTEAD OF MODULUS TO DEAL WITH NEGATIVE HASHCODE VALUES
    this.hashIndex = nodeToEnter.hashCode() & (initialCap -1); //this is Bitwise AND operator


    //First see what's at the HashIndex
    Node<K,V> nodeToCheck = bucket[hashIndex];
    if(nodeToCheck == null){
        bucket[hashIndex] = nodeToEnter;
    }else {

        while (nodeToCheck.next != null) {
            if(nodeToCheck.getKey().equals(key)){

                nodeToCheck.setValue(val);
                return;
            }

            nodeToCheck = nodeToCheck.next;
        }

        //checking the last Node because we aren't doing that in the loop

        if (nodeToCheck.getKey().equals(key)){
            nodeToCheck.setValue(val);
            return;
        }


        nodeToCheck.next = nodeToEnter;
    }

    }





    //----------------GET METHOD-------------- for retrieving key value pair from the hashmap

    public V get(K key){

        Node<K,V> tempNode = new Node<>(key, null);
        int checkIndex;
        if(key == null){
            checkIndex = 0;
        }else {

            checkIndex = tempNode.hashCode() & (initialCap - 1);
        }
        tempNode = bucket[checkIndex];


        //this handles if there hasn't been any entries on that index before like if
        //index 0 has no node then tempNode will be null and throws a null exception
        //if we dont check it before hand
        if(tempNode == null) {
            return null;
        }
        System.out.println("setting value of i");
        int i = 0;
        while(tempNode != null){
            System.out.println("key : " + i + "  " + tempNode.getKey());
            if(tempNode.getKey().equals(key)){
                return tempNode.getValue();
            }
            tempNode = tempNode.next;
            i++;
        }


        return null;

    }



    public int getHashIndex() {
        return hashIndex;
    }

    public void printAll(){
//        for(int i =0 ; i < initialCap; i++){
//            try {
//                System.out.println(bucket[i].getValue());
//            }catch(Exception e){
//                System.out.println("there was a null at point : " + i );
//            }
//        }

        for(int i= 0 ; i < initialCap ; i++ ){

            Node<K,V > n = bucket[i];
            if( n == null){
                System.out.println("nothing on Index : " + i);
            }else{
                System.out.println("Values on Index : " + i);
                while(n.next != null){
                    System.out.println(n.getValue());
                    n = n.next;
                }

                System.out.println(n.getValue());
            }
        }



    }
}
