import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    Obstacle obstacle;
    protected String award;
    protected int defaultObstacleHealth;
    Scanner scan = new Scanner(System.in);

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
        this.defaultObstacleHealth = getDefaultObstacleHealth();
    }
    public boolean getLocation() {
        int obsCount = obstacle.obsCount();
        defaultObstacleHealth = obstacle.getHealth();
        System.out.println("Şu an buradasınız " + this.getName());
        System.out.println("Dikkatli olun! Burada " + obsCount + " tane " + obstacle.getName() + " vardır.");
        System.out.println("<S>avaş veya <K>aç");
        String selCase = scan.next();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")){
            if (combat(obsCount)){
            System.out.println("Tüm düşmanları temizlediniz. Tebrikler!");
                if(this.award.equals("Food") && player.getInv().food == false){
                    System.out.println(this.award + " kazandınız.");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && player.getInv().water == false){
                    System.out.println(this.award + " kazandınız");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && player.getInv().firewood == false){
                    System.out.println(this.award + " kazandınız");
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if (player.getHealth() <= 0){
                System.out.println();
                return false;
            }
        } else {
            return true;
        }
        return true;
    }

    public boolean combat(int obsCount){
        for (int i = 0; i < obsCount; i++){
            playerStats();
            enemyStats();
            while(player.getHealth() > 0 && obstacle.getHealth() > 0 ){
                System.out.println("<V>ur veya <K>aç");
                String selCase = scan.next();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println("Siz vurdunuz");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println("Düşman size vurdu");
                        player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (obstacle.getHealth() < player.getHealth() && obstacle.getHealth() <= 0){
                System.out.println("Düşmanı yendiniz.");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel Paranız : " + player.getMoney());
                obstacle.setHealth(defaultObstacleHealth);
            } else  if (player.getHealth() <= 0) {
                System.out.println();
                System.out.println("Öldünüz. Game Over");
                return false;
            }
            System.out.println("------------------------------------------");
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Oyuncu Canı : " + player.getHealth());
        System.out.println("Düşmanın Canı : " + obstacle.getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri\n ---------------------");
        System.out.println("Can : " + player.getHealth());
        System.out.println("Hasar : " + player.getDamage());
        System.out.println("Para : " + player.getMoney());
        if (player.getInv().getDamage() < 0){
            System.out.println("Silah : " + player.getInv().getWeaponName());
        }
        if (player.getInv().getArmor() < 0 ){
            System.out.println("Zırh : " + player.getInv().getArmorName());
        }
    }

    public void enemyStats(){
        System.out.println("\n " + obstacle.getName() + " Değerleri \n---------------------");
        System.out.println("Can : " + obstacle.getHealth());
        System.out.println("Hasar : " + obstacle.getDamage());
        System.out.println("Ödül : " + obstacle.getAward());
    }


    public int getDefaultObstacleHealth() {
        return defaultObstacleHealth;
    }

    public void setDefaultObstacleHealth(int defaultObstacleHealth) {
        this.defaultObstacleHealth = defaultObstacleHealth;
    }
}
