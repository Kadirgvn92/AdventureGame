import java.util.Scanner;

public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Dükkan");
    }

    public boolean getLocation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Para " + player.getMoney());
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış");
        System.out.println("Seçiminiz : ");
        int selTool = scan.nextInt();
        int selItemId;
        switch (selTool) {
            case 1:
                selItemId = weaponMenu();
                buyWeapon(selItemId);
                break;
            case 2:
                selItemId = armorMenu();
                buyArmor(selItemId);
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Tabanca\t <Para : 25 - Hasar : 2>");
        System.out.println("2 - Kılıç\t <Para : 35 - Hasar : 3>");
        System.out.println("3 - Tüfek\t <Para : 45 - Hasar : 7>");
        System.out.println("4 - Çıkış");
        System.out.println("Silah Seçiniz : ");
        int selWeaponId = scan.nextInt();
        return selWeaponId;
    }
    public int armorMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Hafif Zırh\t <Koruma : 1 - Para : 15>");
        System.out.println("2 - Orta Zırh\t <Koruma : 3 - Para : 25>");
        System.out.println("3 - Ağır Zırh\t <Koruma : 5 - Para : 40>");
        System.out.println("Çıkış");
        System.out.println("Zırh Seçiniz : ");
        int selArmorId = scan.nextInt();
        return selArmorId;
    }
    public void buyArmor(int itemId) {
        int avoid = 0, price = 0;
        String armorName = null;
        switch (itemId) {
            case 1:
                avoid= 1;
                armorName = "Hafif Zırh";
                price = 15;
                break;
            case 2:
                avoid= 3;
                armorName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                avoid= 5;
                armorName = "Ağır Zırh";
                price = 40;
                break;
            case 4 :
                System.out.println("Çıkış yapılıyor");
                break;
            default:
                System.out.println("Lütfen geçerli bir değer giriniz");
                break;
        }
        if (price > 0 ){
            if (player.getMoney() >= price){
                player.getInv().setArmor(avoid);
                player.getInv().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println(armorName + " satın aldınız, Koruma : " + player.getInv().getArmor());
                System.out.println("Kalan para " + player.getMoney());
            } else {
                System.out.println("Silahı alacak paran yeterli değil!");
            }
        }
    }
    public void buyWeapon(int itemId) {
        int damage = 0, price = 0;
        String weaponName = null;
        switch (itemId) {
            case 1:
                damage = 2;
                weaponName = "Tabanca";
                price = 25;
                break;
            case 2:
                damage = 3;
                weaponName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Tüfek";
                price = 45;
                break;
            case 4 :
                System.out.println("Çıkış yapılıyor");
                break;
            default:
                System.out.println("Lütfen geçerli bir değer giriniz");
                break;
        }
        if (price > 0 ){
            if (player.getMoney() > price) {
                player.getInv().setDamage(damage);
                player.getInv().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println(weaponName + " satın aldınız, Önceki hasar : " + player.getDamage() + "Yeni Hasar :" + player.getTotalDamage());
                System.out.println("Kalan para " + player.getMoney());
            } else {
                System.out.println("Silahı alacak paran yeterli değil!");
            }
        }
    }
}