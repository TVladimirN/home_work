package main.java;

import java.util.Random;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class Battle {

    //Вывести дату и время начала сражения
    // взять случайного бойца первой и второй команды
    // первый боец атакует второго
    // перематывается время
    // проверяется победа первой команды
    // снова берутся случайные бойцы,
    // второй атакует первого, проверяется победа второй команды
    // и так далее до победы.
    // В конце вывести имя победившего отряда и общее время поединка

    private static DateHelper dh = new DateHelper();
    private static Squad squadFirst;// = new Squad();
    private static Squad squadSecond;// = new Squad();

    public static void main(String... args){
        prepairedForBattle();

        startBattle();
    }

    private static void startBattle(){
        System.out.println("Начало бойя: " + dh.getFormattedStartDate());
        int round = 1;
        while(true){
            System.out.printf("Раунд: %d\n", round);
            Warrior first = squadFirst.getRandomWarrior();
            Warrior second = squadSecond.getRandomWarrior();

            fight(first, second, round);
            dh.skipTime();
            if(checkVictory(squadFirst, squadSecond, round)){
                break;
            }
            round++;

        }
        System.out.println("Длительность боя: " + dh.getFormattedDiff());
    }

    private static Boolean checkVictory(Squad firstTeam, Squad secondTeam, int roundNumber){
        switch(roundNumber%2){
            case 1:
                if(!secondTeam.hasAliveWarriors() && firstTeam.hasAliveWarriors()){
                    System.out.printf("Победила команда \"%s\"\n", firstTeam.toString());
                    return true;
                }
            case 0:
                if(!firstTeam.hasAliveWarriors() && secondTeam.hasAliveWarriors()){
                    System.out.printf("Победила команда \"%s\"\n", secondTeam.toString());
                    return true;
                }
            default:
                return false;
        }
    }

    private static void fight(Warrior firstWarrior, Warrior secondWarrior, int roundNumber){
        switch(roundNumber%2){
            case 1:
                secondWarrior.takeDamage(firstWarrior.attack());
                System.out.printf("Боец \"%s\" команды \"%s\" наносит \"%d\" урона бойцу команды \"%s\"\n", firstWarrior.getWarriorName(),
                        firstWarrior.getSquadName(), firstWarrior.attack(), secondWarrior.getSquadName());
                if(!secondWarrior.isAlive()){
                    System.out.printf("Погиб боец: %s\n", secondWarrior.toString());
                }
                break;
            case 0:
                firstWarrior.takeDamage(secondWarrior.attack());
                System.out.printf("Боец \"%s\" команды \"%s\" наносит \"%d\" урона бойцу команды \"%s\"\n", secondWarrior.getWarriorName(),
                        secondWarrior.getSquadName(), secondWarrior.attack(), firstWarrior.getSquadName());
                if(!firstWarrior.isAlive()){
                    System.out.printf("Погиб боец: %s\n", firstWarrior.toString());
                }
                break;
        }
    }

    private static void prepairedForBattle(){
        Random random = new Random(System.currentTimeMillis());
        squadFirst = new Squad("Красные");
        squadSecond = new Squad("Синие");

        squadFirst.addWarrior(new Archer("name_1_1"));
        squadFirst.addWarrior(new Viking("name_1_2"));
        squadFirst.addWarrior(new Archer("name_1_3"));
        squadFirst.addWarrior(new Viking("name_1_4"));
        squadFirst.addWarrior(new Archer("name_1_5"));
        squadFirst.addWarrior(new Viking("name_1_6"));
        squadFirst.addWarrior(new Archer("name_1_7"));


        squadSecond.addWarrior(new Viking("name_2_1"));
        squadSecond.addWarrior(new Archer("name_2_2"));
        squadSecond.addWarrior(new Archer("name_2_3"));
        squadSecond.addWarrior(new Viking("name_2_4"));
        squadSecond.addWarrior(new Archer("name_2_5"));
        squadSecond.addWarrior(new Viking("name_2_6"));
        squadSecond.addWarrior(new Viking("name_2_7"));



    }

}