package Practice;

abstract class car{
    public int sum() {
        return 2;
    }
}
public class Impl extends car{

    @Override
    public int sum() {
        return 1;
    }
    public static void main(String[] args) {
        car c = new Impl();

        System.out.println(c.sum());



    }
}
