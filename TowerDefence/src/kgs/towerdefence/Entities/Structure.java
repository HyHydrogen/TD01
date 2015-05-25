package kgs.towerdefence.Entities;

public class Structure {
    private float health;
    private int x,y;
    private int type;
    public int damage, attackRange, magicResist, Armor;

    public void Turret(){
        health = 2000;
        int x = 0;
        int y = 0;
        int type = 1;
        int damage = 152;
        int attackRange = 775;
        int Armor =100;
        int magicResist =100;


    }

    public void Inhibitor(){
        health = 4000;
        int x = 0;
        int y = 0;
        int type = 2;
    }

    public void Nexus() {
        health = 5500;
        int x = 0;
        int y = 0;
        int type = 3;
    }

}
