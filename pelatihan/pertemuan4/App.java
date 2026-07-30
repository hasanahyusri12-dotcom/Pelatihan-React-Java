public class App {
    public static void main(String[] args) throws Exception {
        // Instansiasi objek
        Hero hero = new Hero("Anas");
        Enemy enemy = new Enemy("Jokowow");
        // Memanggil method attack() dari kedua kubu
        hero.attack();
        enemy.attack();
    }
}