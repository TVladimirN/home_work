package main.java;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class Warrior implements WarriorInter, Cloneable {

    protected int damage;
    protected long health;
    protected String squadName;
    protected String warriorName;

    public Warrior(){
    }

    public String getSquadName(){
        return this.squadName;
    }

    public String getWarriorName(){
        return this.warriorName;
    }

    @Override
    public int attack() {
        return this.damage;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    @Override
    public boolean isAlive() {
        if(health > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void setSquadName(String name) {
        this.squadName = name;
    }

    @Override
    public String toString(){
        //Вывод имя, клас и пренадлежность к отряду
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Имя: %s\n", this.warriorName));
        sb.append(String.format("Класс: %s\n", this.getClass().getSimpleName()));
        sb.append(String.format("Отряд: %s\n", this.squadName));
        return sb.toString();
    }

    @Override
    public Warrior clone(){
        Warrior w = null;
        switch (this.getClass().getSimpleName()){
            case "Archer":
                w = new Archer(this.warriorName, this.squadName);
                break;
            case "Viking":
                w = new Viking(this.warriorName, this.squadName);
                break;
        }
        return w;
    }

    public void getInfo(){
        System.out.println("Дамаг: " + this.damage + "\nХП: " + this.health);
    }
}
