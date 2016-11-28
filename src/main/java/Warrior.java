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

    public Warrior(Warrior w){
        this.squadName = w.getSquadName();
        this.warriorName = w.getWarriorName();
        this.health = w.getHealth();
        this.damage = w.getDamage();
    }

    public int getDamage(){
        return this.damage;
    }

    public long getHealth(){
        return this.health;
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
        try {
            Warrior w = (Warrior) super.clone();

            return w;
        }catch (Exception e){return null;}
    }

    public String getInfo(){
        return ("Дамаг: " + this.damage + "\nХП: " + this.health);
    }
}
