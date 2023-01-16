package Practice;

import java.util.HashMap;
import java.util.Map;

abstract class car{
    public int sum() {
        return 2;
    }
    public int s() {return 0;}
}
public class Impl extends car{

    @Override
    public int sum() {
        return 1;
    }
    public static void main(String[] args) {
        car c = new Impl();
        c.s();
        System.out.println(c.sum());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();


    }
}
