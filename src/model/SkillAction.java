package model;

import java.util.ArrayList;
import java.util.Random;

public class SkillAction {
    private static final int SKILL_CHECK_RANGE = 100;
    private final int MAX_LEVEL = 10;
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

    private int getNewLevel(Object skill, Object currentXP){ //TODO rework for new xp system related to leveling skills
        int xp = (Integer) currentXP;// xp will now be used as number of times a skill was used including rewards bonuses from events and quests.
        int rollValue = 0;
        switch(skill.toString().toLowerCase()){
            case ("blocking"):
                /*switch (xp){ // old
                    case (int) currentXP:
                        switch(rollValue = random(10)) {
                    }
                    case (rollValue>(int)currentXP):
                    break;
                    default:
                        break;
                }*/
                rollValue = random(10)+(int)currentXP;
                System.out.println(rollValue);
                for (int chance = 0; chance < 24+rollValue+random(10); chance++) {
                    rollValue = random(10);
                    switch (rollValue) {
                        case 10:
                            System.out.println("Extreme Success "+rollValue);
                            break;
                        case 0:
                            System.out.println("Extreme Fail "+rollValue);
                            break;
                        case 1:
                            System.out.println("Close Fail"+rollValue);

                            break;
                            default:
                                System.out.println(""+rollValue);
                                break;
                    }
                }

                break;
        }
        return 1;
    }
    /*private void getLevelCalculator(Object skill){

    }
*/
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

        /*BigInteger big = new BigInteger("123456789123456789"); // BigInteger is an immutable class. So whenever you do any arithmetic, you have to reassign the output to a variable.
        // TODO figure out a way to overcome this roadblock. BigInteger values are not scalable to a multiplayer game due to the nature of adding and assigning new values.

        //skillAction.setLevel( "blocking", 2 );
        skillAction.setXP("blocking", 200);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                System.out.print(skillAction.skills[i].get(j) + " ");
            }
            System.out.println();
        }*/
        for (int i = 0; i < 25; i++) {

            skillCheck(skillAction.MAX_LEVEL);
        }

    }

    private static void skillCheck(int MAX_LEVEL) { //check
        int percent = 0;
        int runCount = 100;
        int passValue = 50;// TODO change this for new xp system
        for (int i = 0; i < runCount; i++) {
            random(SKILL_CHECK_RANGE);
            if(i==(50+random(10))){
                if (random(SKILL_CHECK_RANGE)>=passValue) {
                    System.out.println("true");

                    percent++;
                }else{
                    System.out.println("false");
                }
            }
            //System.out.println(random(SKILL_CHECK_RANGE));

        }
        //System.out.println((float)percent/runCount + "percentage");
    }

    private static int random(int number){ //Utility Random Number
        Random random = new Random();
        return random.nextInt(number);

    }

}
