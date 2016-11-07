/**
 * Created by Acer on 30.10.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Calculator cacheCalculator = CalculatorCache.getProxy(new SimpleCalculator());
        System.out.println(cacheCalculator.doHardWork1("lol"));
        System.out.println(cacheCalculator.doHardWork1("lol"));
        System.out.println(cacheCalculator.doHardWork3("lol"));
        System.out.println(cacheCalculator.doHardWork2("lol"));
        System.out.println(cacheCalculator.doHardWork3("lol"));
        System.out.println(cacheCalculator.doHardWork1("lol"));
        System.out.println(cacheCalculator.doHardWork1("lol"));
//        Calculator c = new SimpleCalculator();
//        System.out.println(c.doHardWork("Stephan"));
//        System.out.println(c.doHardWork("Nikita"));
//        System.out.println(c.doHardWork("Stephan"));
    }
}
