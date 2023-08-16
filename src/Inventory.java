public class Inventory {

    protected boolean water;
    protected boolean firewood;
    protected boolean food;
    protected String armorName;
    protected String weaponName;
    protected int damage;
    protected int armor;

    Inventory(){
        this.setWater(false);
        this.setFood(false);
        this.setFirewood(false);
        this.setArmor(0);
        this.setDamage(0);
        this.setWeaponName(null);
        this.setArmorName(null);
    }


    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
