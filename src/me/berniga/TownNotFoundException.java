package me.berniga;

public class TownNotFoundException extends Exception{
    public TownNotFoundException(){super();}
    public String toString(){
        return "Sorry!! The town you are searching is not in the list";
    }
}
