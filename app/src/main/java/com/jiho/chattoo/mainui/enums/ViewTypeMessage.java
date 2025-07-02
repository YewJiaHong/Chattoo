package com.jiho.chattoo.mainui.enums;

public enum ViewTypeMessage{
    SENT(1),
    RECEIVED(2),
    ;

    private int numVal;

    ViewTypeMessage(int numVal){
        this.numVal = numVal;
    }

    public int getVal(){
        return numVal;
    }
}