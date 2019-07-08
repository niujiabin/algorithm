package jiabin.dubbo.spi;

/**
 * @author : jiabin.niu
 * @date : 2019.07.06 2:14
 */
public class PersonRobot implements Robot {
    @Override
    public void go() {
        System.out.println("person");
    }
}
