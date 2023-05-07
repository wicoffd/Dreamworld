package model;

import java.math.BigInteger;
import java.util.ArrayList;

public class SkillAction {
    private final int MAX_LEVEL = 200;
    private final int LEVEL_INDEX = 1;
    private final int XP_INDEX = 2;
    private final int SKILL_COUNT = 136;
    private int totalLevel = 0;

    static ArrayList<Object>[] skills = new ArrayList[3];
    static String[] skillNames = new String[5];
    ArrayList<Object> xpNeeded = new ArrayList<>(MAX_LEVEL);
    ArrayList<Object>[] skillAbilities = new ArrayList[2];

    private SkillAction(){
        skillNames = new String[]{"Agility", "Acid Resistance", "Blocking", "Taming"};

        for (int i = 0; i < 3; i++) {
            skills[i] = new ArrayList<>();
            skills[i].add(skillNames[i]);
            skills[i].add(0);
            skills[i].add(0);
        }

    }
    private void setXP(Object skill, Object xp){
        switch(skill.toString().toLowerCase()){
            case "blocking":
                skills[2].set(XP_INDEX, xp);
                getNewLevel(skill, skills[2].get(XP_INDEX));
                break;


        }
    }

    private int getNewLevel(Object skill, Object currentXP){
        int xp = (Integer) currentXP;
        switch(skill.toString().toLowerCase()){
            case ("blocking"):

                break;

        }
        return 1;
    }
    private void getLevelCalculator(Object skill){

    }

    private void getSkillMenu(Object skill){

    }

    private int getTotalLevel(){

        return totalLevel;
    }

    private void setLevel(Object skill, Object level) {
        switch(skill.toString().toLowerCase()){
            case "blocking":
                skills[2].set(LEVEL_INDEX, level);
                break;


        }

    }

    public static void main(String[] args)
    {

        SkillAction skillAction = new SkillAction();

        BigInteger big = new BigInteger("123456789123456789"); // BigInteger is an immutable class. So whenever you do any arithmetic, you have to reassign the output to a variable.
        // TODO figure out a way to overcome this roadblock. BigInteger values are not scalable to a multiplayer game due to the nature of adding and assigning new values.

        //skillAction.setLevel( "blocking", 2 );
        skillAction.setXP("blocking", 200);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                System.out.print(skillAction.skills[i].get(j) + " ");
            }
            System.out.println();
        }

    }

}
