package main.java;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class Warrior implements WarriorInter, Cloneable { //если этот класс не предназначен для создания объектов, его следует сделать абстрактным

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
//        if(health > 0){ //в местах, где проверяется/возвращается результат условия, можно сразу проверять/возвращать. в данном случае просто return health > 0;
//            return true;
//        }else{
//            return false;
//        }
        return health > 0;//Это по привычки расписываю все)

    }

    @Override
    public void setSquadName(String name) {
        this.squadName = name;
    }

    @Override
    public String toString(){
        //Вывод имя, клас и пренадлежность к отряду
        String result = ""; //поправил
        result.concat(String.format("Имя: %s\n", this.warriorName));
        result.concat(String.format("Класс: %s\n", this.getClass().getSimpleName()));
        result.concat(String.format("Отряд: %s\n", this.squadName));
        return result;
    }

    @Override
    public Warrior clone(){
        try {
            Warrior w = (Warrior) super.clone();

            return w;
        }catch (Exception e){return null;} //тут теряется вся информация о произошедшем исключении и возвращается null туда, где ожидается Warrior, что в будущем вызовет null pointer exception.
    }//+ плохое форматирование
    //А как тут тогда следует поступить ? нового чтоли создавать ? эксепшен пробрасывать как правильнее будет ?

    public String getInfo() {//Это эксперементы в задании этого не было поэтому туда не внес
        return ("Дамаг: " + this.damage + "\nХП: " + this.health); //а это не должно быть частью toString?
    }
}
