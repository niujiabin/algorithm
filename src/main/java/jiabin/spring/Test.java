package jiabin.spring;

import jiabin.spring.core.PerfectBean;
import jiabin.spring.core.PerfectBeanFactory;
import jiabin.spring.core.PerfectBox;
import jiabin.spring.test.bean.Student;

public class Test {

    public static void main(String[] args) {

        PerfectBean perfectBean = PerfectBeanFactory.create();
        perfectBean.setBeanName("student").setClassPath("jiabin.spring.test.bean.Student");

        PerfectBox.registerBean(perfectBean);
        Student student = PerfectBox.getBean("student", Student.class);

        System.out.println(student.getName());
    }
}
