package com.fclass;


public class Main {

    public static void main(String[] args) {

        CustomHashMap<String, String> head = new CustomHashMap<>(4);
        head.put("First", "Ali");
        System.out.println(head.getHashIndex());
        head.put("Second", "Raffay");
        System.out.println(head.getHashIndex());
        head.put("Third", "Ayesha");
        System.out.println(head.getHashIndex());
        head.put("Fourth", "Nabia");
        System.out.println(head.getHashIndex());
        head.put(null, "Nabia");
        System.out.println(head.getHashIndex());
        head.put(null, "Raffayaa");
        System.out.println(head.getHashIndex());
        System.out.println("these are the values");
        head.printAll();
        System.out.println("--------get method ___________");
        System.out.println(head.get(null));
        System.out.println(head.get("Second"));
        System.out.println(head.get("First"));
        System.out.println(head.get("hahha"));
        System.out.println(head.get("Third"));
        System.out.println(head.get("Fourth"));

        head.put(null, "Radjalsffayaa");
        System.out.println(head.get(null));

        try {

            Node<String, String> removed = head.remove("First");
            System.out.println(removed.getValue());
            Node<String, String> removed1 = head.remove("afsld");
            System.out.println(removed1.getValue());


        } catch (Exception e){
            System.out.println("Null Pointer Exception: one of the object might be not exist in the hashMap anymore.");
        }

    }
}