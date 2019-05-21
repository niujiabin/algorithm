package jiabin.spring.core;

import jiabin.spring.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
                //do not allow duplicate registration of beans
                if (!singletonMap.containsKey(beanName)) {
                    String classPath = bean.getClassPath();
                    if (StringUtils.isNotEmpty(classPath)) {
                        //create bean
                        Object object = createBean(bean);
                        singletonMap.putIfAbsent(beanName, object);
                    } else {
                        throw new RuntimeException("class path can not be empty");
                    }
                } else {
                    throw new RuntimeException("bean name" + beanName + " haven been existed");
                }
            } else {
                throw new RuntimeException("bean name can not be empty!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object createBean(PerfectBean perfectBean) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String classPath = perfectBean.getClassPath();
        Class<?> clazz = Class.forName(classPath);
        Constructor constructor = clazz.getConstructor();
        Object bean = constructor.newInstance();
        final List<PerfectBeanProperty> perfectBeanPropertyList = perfectBean.getBeanPropertyList();
        for (PerfectBeanProperty property : perfectBeanPropertyList) {
            Field field = clazz.getDeclaredField(property.getName());
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (field.getType() == String.class) {
                field.set(bean, String.valueOf(property.getValue()));
            }

        }

        return bean;
    }

    public static <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) singletonMap.get(beanName);
    }
}
