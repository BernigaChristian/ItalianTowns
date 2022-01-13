package me.berniga;

public class NoTownsInRangeException extends Exception{
    public NoTownsInRangeException(){super();}
    public String toString(){
        return "Sorry!! There are no towns in this range";
    }
}
