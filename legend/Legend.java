package legend;

import javafx.scene.media.AudioClip;

import java.util.Random;

public abstract class Legend {
    protected String name;
    protected int HP=100;
    protected  int attackPower;
    protected  int defencePower;
    protected  int recoveryCount;
    public AudioClip shotSound;
    public AudioClip recoveryVoice;
    protected static int recovery=20;;

    Legend(String name,int attackPower,int defencePower,int recoveryCount,AudioClip shotSound,AudioClip recoverySound){
        this.name=name;
        this.attackPower=attackPower;
        this.defencePower=defencePower;
        this.recoveryCount=recoveryCount;
        this.shotSound=shotSound;
        this.recoveryVoice=recoverySound;
    }

    //行動
    public int attack(Legend target){

        Random random=new Random();
        int r=(int)(Math.random()*5);
        double damagebefore=this.attackPower*(1-(target.defencePower/100.0));
        int damage=(int)(damagebefore*(0.8+r*0.1));

        if(target.getHp()-damage<0){
            return -target.getHp();
        }
        else return -damage;
    }


    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.HP;
    }

    public void setDamage(int damage){
        this.HP-=damage;
    }

    public void recoveryHP(){
        if(this.HP+recovery>=100)
        {
            this.HP=100;
        }
        else{
            this.HP+=recovery;
        }

    }

    public int getRecoveryCount(){
        return this.recoveryCount;
    }

    public int recovery(){
        if(this.recoveryCount>=1){
            if(this.HP==100){
                // System.out.println("legend:体力はMAXです。"+"体力は"+this.getTestHp());
                return 0;
            }
            else if(this.HP+recovery>=100) {
                // System.out.println("legend:"+this.name+"の"+(100-this.testHp)+"回復。HP:100");
                int recoveryAmount=100-this.HP;
                this.recoveryCount--;
                return recoveryAmount;
            }
            else{

                //System.out.println("legend:"+this.getName()+"の20回復"+"残り"+this.getTestHp()+"です");
                this.recoveryCount--;
                return recovery;
            }
        }
        else{
            //System.out.println("legend:回復がありません");
            return 0;
        }
    }
    public static int getRecoveryAmount(){
        return recovery;
    }


}