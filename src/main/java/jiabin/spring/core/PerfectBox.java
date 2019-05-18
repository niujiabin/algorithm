package jiabin.spring.core;

import jiabin.spring.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 完美盒子  管理对象的容器
 *
 * @author Administrator
 */
public class PerfectBox<T> {

    protected static Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    public static void registerBean(PerfectBean bean) {
        try {
            String beanName = bean.getBeanName();
            if (StringUtils.isNotEmpty(beanName)) {
                if (!singletonMap.containsKey(beanName)) {
                    String classPath = bean.getClassPath();
                    if (StringUtils.isNotEmpty(classPath)) {
                        Class<?> clazz = Class.forName(classPath);
                        Constructor constructor = clazz.getConstructor();
                        Object object = constructor.newInstance();
                        if (!singletonMap.containsKey(beanName)) {
                            singletonMap.put(beanName, object);
                        }
                    }
                    throw new RuntimeException("class path can not be empty");
                }
                throw new RuntimeException("bean name" + beanName + " haven been existed");
            }
            throw new RuntimeException("bean name can not be empty!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) singletonMap.get(beanName);
    }
}
