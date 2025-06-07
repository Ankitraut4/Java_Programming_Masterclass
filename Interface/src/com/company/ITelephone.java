package com.company;

public interface ITelephone {
    void powerOn();//here we can write public 0r private void powerOn() but it not neccesary because we can define it during implementing interface class
    void dial(int phoneNumber);//here we can write public 0r private
    void answer();//here we can write public 0r private
    boolean callPhone(int phoneNumber);//here we can write public 0r private
    boolean isRinging();//here we can write public 0r private



}
