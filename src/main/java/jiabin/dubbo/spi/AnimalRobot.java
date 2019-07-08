package jiabin.dubbo.spi;

/**
 * @author : jiabin.niu
 * @date : 2019.07.06 2:15
 */
public class AnimalRobot implements Robot {
    @Override
    public void go() {
        System.out.println("animal");
    }
}
