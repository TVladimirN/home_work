package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class Squad {

    private List<Warrior> warriors = new ArrayList<>();
    private List<Warrior> aliveWarriors = new ArrayList<>();
    private String squadName;
    private Random random;

    public Squad(){
    }

    public Squad(String squadname){
        this.squadName = squadname;
    }

    public Warrior getRandomWarrior(){
//        for(;;){
            random = new Random(System.currentTimeMillis());
//            Warrior w = warriors.get(random.nextInt(warriors.size()));
//            if(w.isAlive()){
//                return w;
//            }else{
//                continue;
//            }
//        }
        return aliveWarriors.get(random.nextInt(aliveWarriors.size()));
    }

    public void addWarrior(Warrior warrior){
        warrior.setSquadName(this.squadName);
        this.aliveWarriors.add(warrior);
        this.warriors.add(warrior);
    }

    public boolean hasAliveWarriors(){
        Boolean result = false;
        for(Warrior w : warriors){
            if(!w.isAlive()){
                aliveWarriors.remove(w);
            }
        }
        return (aliveWarriors.size() > 0);
//        for(Warrior w : warriors){
//            if(w.isAlive()){
//                result = true;
//                break;
//            }
//        }
//        return result;
    }

    @Override
    public String toString(){
        return this.squadName;
    }

    @Override
    public Squad clone(){
        List<Warrior> newWarriors = new ArrayList<>();
        for(Warrior w : warriors){
            switch (w.getClass().getSimpleName()){
                case "Archer":
                    newWarriors.add(new Archer());
                case "Viking":
                    newWarriors.add(new Viking());
            }
        }
        Squad s = new Squad(this.squadName+"_copy");
        s.warriors.clear();
        s.warriors.addAll(newWarriors);
        return s;
    }
}
