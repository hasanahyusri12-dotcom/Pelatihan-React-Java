public abstract class Character {
    // Atribut atau properti
    private String name;

    // Constructor
    public Character(String name) {
        this.name = name;
    }

    // Method abstrak
    public abstract void attack(); // menyediakan wadah tampungan kosong yang akan di gunakan di kelas anaknya yang harus diisi  

    // Method biasa
    public void survive() {
        System.out.println("Karakter bertahan");
    }

    // Method Getter
    public String getName() {
        return name;
    }

    // Method Setter
    public void setName(String name) {
        this.name = name;
    }
}