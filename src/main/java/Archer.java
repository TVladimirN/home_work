package main.java;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class Archer extends Warrior implements Cloneable{


    public Archer(){
        damage = 95;
        health = 105;
    }

    public Archer(String warriorName, String squadName){
        damage = 95;
        health = 105;
        this.warriorName = warriorName;
        this.squadName = squadName;
    }

    public Archer(String warriorName){
        damage = 95;
        health = 105;
        this.warriorName = warriorName;
    }
}
