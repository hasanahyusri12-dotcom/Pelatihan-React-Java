public class Cat implements Animal {
    @Override
    public String eat() {
        return "Kucing makan ikan bakar";
    }

    @Override
    public String sleep() {
        return "Kucing tidur di kamar tidur";
    }
}