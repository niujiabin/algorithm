package jiabin.spring;

import jiabin.spring.core.PerfectBean;
import jiabin.spring.core.PerfectBeanFactory;
import jiabin.spring.core.PerfectBeanProperty;
import jiabin.spring.core.PerfectBox;
import jiabin.spring.test.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        PerfectBean perfectBean = PerfectBeanFactory.create();
        perfectBean.setBeanName("student").setClassPath("jiabin.spring.test.bean.Student");

        PerfectBeanProperty propertyName = new PerfectBeanProperty();
        propertyName.setName("name");
        propertyName.setValue("jiabin.niu");

        PerfectBeanProperty propertyAge = new PerfectBeanProperty();
        propertyAge.setName("age");
        propertyAge.setValue("12");

        List<PerfectBeanProperty> properties = new ArrayList<>();
        properties.add(propertyName);
        properties.add(propertyAge);
        perfectBean.setBeanPropertyList(properties);

        PerfectBox.registerBean(perfectBean);
        Student student = PerfectBox.getBean("student", Student.class);

        System.out.println(student.getName());
    }
}
