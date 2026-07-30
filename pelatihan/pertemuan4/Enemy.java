public class Enemy extends Character {
    public Enemy(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Musuh menyerang pahlawan !!!");
    }
}