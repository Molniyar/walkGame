package game;

public class Player {
    private final int index;
    int progress = 1;
    String userName;
    private int maxHealth = 5;
    private int health = maxHealth;

    Inventory inventory = new Inventory();


    public Player(int index, String userName) {
        this.index = index;
        this.userName = userName;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int damage) {
        System.out.println("Вы получили урон");
        health -= damage;
        if (health <= 0){
            kill();
        }
    }
    public void kill() {
        System.out.println("Вы умерли");
        progress = 1;
        health = maxHealth;
    }

    public void treat(int addHealth) {
        health += addHealth;
        if (health > maxHealth){
            health = maxHealth;
        }
    }
    public void jump (int jumpLength) {
        progress += jumpLength;
        if (progress > 100) {
            progress = 100;
        }
        if (progress < 0) {
            progress = 0;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getProgress() {
        return progress;
    }
    public void setProgress(int value) {
        progress = value;
    }
}
