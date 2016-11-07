/**
 * Created by Acer on 30.10.2016.
 */
public interface Calculator {
    @Cache
    int doHardWork1(String name) throws InterruptedException;

    int doHardWork2(String name) throws InterruptedException;

    @Save
    int doHardWork3(String name) throws InterruptedException;
}