package jiabin.spring.core;

import jiabin.spring.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 完美盒子  管理对象的容器   作为Spring的练习
 *
 * @author Administrator
 */
public class PerfectBox<T> {

    protected static Map<String, PerfectBean> singletonMap = new ConcurrentHashMap<>();

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
                        bean.setBean(object);
                        singletonMap.putIfAbsent(beanName, bean);
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
            } else if (field.getType() == int.class || field.getType() == Integer.class) {
                field.set(bean, Integer.valueOf(property.getValue()));
            }
            //存在引用
            //TODO 解决循环依赖问题
            if (property.getReferenceBean() != null) {
                if (singletonMap.get(property.getName()) != null) {
                    field.set(bean, singletonMap.get(property.getName()).getBean());
                } else {
                    //创建bean

                }
            }
            //TODO 添加其它数据类型的支持
        }

        return bean;
    }

    public static <T> T getBean(String beanName) {
        return (T) singletonMap.get(beanName).getBean();
    }
}
