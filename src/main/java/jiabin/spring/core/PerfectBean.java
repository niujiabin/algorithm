package jiabin.spring.core;

import jiabin.spring.test.bean.Student;

/**
 * @author Administrator
 */
public class PerfectBean<T> {

    private Object bean;
    private String beanName;
    private String classPath;

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public String getBeanName() {
        return beanName;
    }

    public PerfectBean<T> setBeanName(String beanName) {
        this.beanName = beanName;
        return this;
    }

    public String getClassPath() {
        return classPath;
    }

    public PerfectBean<T> setClassPath(String classPath) {
        this.classPath = classPath;
        return this;
    }
}
