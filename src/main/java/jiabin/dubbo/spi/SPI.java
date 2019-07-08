package jiabin.dubbo.spi;

import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author : jiabin.niu
 * @date : 2019.07.06 2:13
 */
public class SPI {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        serviceLoader.forEach(new Consumer<Robot>() {
            @Override
            public void accept(Robot robot) {
                robot.go();
            }
        });
    }
}
