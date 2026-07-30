
public class App {
    public static void main(String[] args) throws Exception {
        // Instansiasi objek dari class Cat dan Crocodile
        Cat kucing = new Cat();
        Crocodile buaya = new Crocodile();
        // Memanggil method yang ada di setiap class
        System.out.println(kucing.eat());
        System.out.println(kucing.sleep());
        System.out.println(buaya.eat());
        System.out.println(buaya.sleep());
    }
}