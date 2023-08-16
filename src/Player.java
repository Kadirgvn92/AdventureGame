import java.util.Scanner;

public class Player {

    protected int damage;
    protected int health;
    protected int realHealth;
    protected int money;
    protected String name;
    protected String chaName;

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    protected Inventory inv;


    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCha(){
        switch (chaMenu()) {
            case 1 :
                initPlayer("Samuray", 5, 21, 15);
                break;
            case 2 :
                initPlayer("Okçu", 7, 18, 20);
                break;
            case 3 :
                initPlayer("Samuray", 8, 24, 5);
                break;
            default:
                initPlayer("Samuray", 5, 21, 15);
                break;
        }
    }
    public int chaMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen bir karakter seçiniz!");
        System.out.println("1 - Samuray\t Hasar :5\t, Sağlık :21, \t Para :15");
        System.out.println("2 - Okçu\t Hasar :7\t, Sağlık :18, \t Para :20");
        System.out.println("3 - Şövalye\t Hasar :8\t, Sağlık :24, \t Para :5");
        System.out.print("Karakter seçiminiz : ");
        int chaId = scan.nextInt();

        while (chaId < 1 && chaId >3){
            System.out.println("Lütfen geçerli giriş yapınız!");
            chaId = scan.nextInt();
        }
        return chaId;
    }
    public void initPlayer (String name, int dmg, int helth, int mny){
        setChaName(chaName);
        setDamage(dmg);
        setHealth(helth);
        setMoney(mny);
        setRealHealth(helth);
    }
    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChaName() {
        return chaName;
    }

    public void setChaName(String chaName) {
        this.chaName = chaName;
    }
    public int getRealHealth() {
        return realHealth;
    }
    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }
}
