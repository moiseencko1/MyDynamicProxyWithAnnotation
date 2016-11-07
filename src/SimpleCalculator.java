/**
 * Created by Acer on 30.10.2016.
 */
public class SimpleCalculator implements Calculator {

    @Override
    public int doHardWork1(String name) throws InterruptedException {
        Thread.sleep(2000);
        return name.hashCode() % 100;
    }


    @Override
    public int doHardWork2(String name) throws InterruptedException {
        Thread.sleep(3000);
        return name.hashCode() % 100;
    }

    @Override
    public int doHardWork3(String name) throws InterruptedException {
        Thread.sleep(5000);
        return name.hashCode() % 100;
    }
}
