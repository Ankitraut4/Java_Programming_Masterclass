package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkList list=new MyLinkList(null);

       String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";


        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));

        }
        list.traverse(list.getRoot());
    }
}
