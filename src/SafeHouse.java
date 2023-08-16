public class SafeHouse extends NormalLoc{


    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    public boolean getLocation() {
        player.setHealth(player.getRealHealth());
        System.out.println("Canınız Fullendi");
        System.out.println("Şuan Güvenli Evdesiniz");
        return true;
    }


}
