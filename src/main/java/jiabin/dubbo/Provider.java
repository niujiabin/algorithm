package jiabin.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        //接口实现类
        TestService testService = new TestServiceImpl();

        //应用信息
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("testApp");

        //Registry Info
        RegistryConfig registryConfig = new RegistryConfig();
        //注册地址
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        registryConfig.setUsername("jiabin.niu");
        registryConfig.setPassword("qunar.1234");

        //使用协议
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);

        //服务暴露方   维持着serversocket实例
        //为了防止内存泄漏，最好缓存，正好spring使用了单例模式
        ServiceConfig<TestService> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig);
        service.setProtocol(protocolConfig);

        //使用哪个实现类暴露给外部
        service.setRef(testService);
        service.setVersion("1.0.0");
        service.setInterface(TestService.class);

        //本地注册与暴露
        service.export();

        System.out.println("按任意键退出");
        System.in.read();
    }
}
