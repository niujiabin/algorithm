package jiabin.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

public class Consumer {

    public static void main(String[] args) {


        // Application Info
        ApplicationConfig application = new ApplicationConfig();
        application.setName("yyy");

        // Registry Info
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");
        registry.setUsername("aaa");
        registry.setPassword("bbb");

        // NOTES: ReferenceConfig holds the connections to registry and providers, please cache it for performance.

        // Refer remote service
        ReferenceConfig<TestService> reference = new ReferenceConfig<>();
        // In case of memory leak, please cache.
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(TestService.class);
        reference.setVersion("1.0.0");

        // Use xxxService just like a local bean
        TestService service = reference.get();
        // NOTES: Please cache this proxy instance.
        service.test();
    }
}
