public class Hero extends Character {
    public Hero(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Pahlawan menyerang musuh !!!");
    }
}