package main.java;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public interface WarriorInter {

    int attack();//возвращает урон, нанесенный бойцом при атаке
    void takeDamage(int damage);//отнимает у бойца указанное количество здоровья
    boolean isAlive();//проверяет, жив боец или нет
    void setSquadName(String name);//устанавливает имя отряда, к которому принадлежит боец
}
