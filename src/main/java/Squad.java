package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class Squad implements Cloneable{

    private List<Warrior> warriors = new ArrayList<>();
    private List<Warrior> aliveWarriors = new ArrayList<>(); //плохая идея хранить одних и тех же бойцов в двух списках. мертвые нам сейчас не нужны, их можно сразу удалять из отряда.
    private String squadName;
    private Random random;

    public Squad(){
    }

    public Squad(String squadname){
        this.squadName = squadname;
    }

    public Warrior getRandomWarrior(){
        random = new Random(System.currentTimeMillis());
        return aliveWarriors.get(random.nextInt(aliveWarriors.size()));
    }

    public void addWarrior(Warrior warrior){
        warrior.setSquadName(this.squadName);
        this.aliveWarriors.add(warrior);
        this.warriors.add(warrior);
    }

    public boolean hasAliveWarriors(){
        for(Warrior w : warriors){
            if(!w.isAlive()){
                aliveWarriors.remove(w);
            }
        }
        return (aliveWarriors.size() > 0);
    }

    @Override
    public String toString(){
        return this.squadName;
    }

    @Override
    public Squad clone(){
        Squad s = null;
        try {
            List<Warrior> newWarriors = new ArrayList<>();
            for (Warrior w : warriors) {
                newWarriors.add(w.clone());
            }
            s = new Squad(this.squadName + "_copy");
            s.warriors.addAll(newWarriors);

        }catch (Exception e){}
        return s;
    }

    public String getInfoSquad(){
        String result = "";
        result += this.squadName+"\n";
        for(Warrior w : this.warriors){
            result += w.toString(); //конкатенация строк в цикле порождает кучу ненужных объектов! тут НУЖНО использовать StringBuilder.
            result += w.getInfo() + "\n\n";
        }
        return result;
    }
}
