package jiabin.spring;

import jiabin.spring.core.PerfectBean;
import jiabin.spring.core.PerfectBeanFactory;
import jiabin.spring.core.PerfectBeanProperty;
import jiabin.spring.core.PerfectBox;
import jiabin.spring.parser.XmlParser;
import jiabin.spring.test.bean.Animal;
import jiabin.spring.test.bean.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {

        PerfectBox perfectBox = XmlParser.loadResource("perfectContext.xml");


        /**
         * like :
         * <bean name="student" class="jiabin.spring.test.bean.Student">
         *      <property name="name">jiabin.niu</property>
         *      <property name="age">12</property>
         *      <property name="an" ref="animal"></property>
         * </bean>
         */
        /**
         * TODO  1.增加singleton 和 prototype属性  2. 增加xml配置文件解析
         */

        /**
         * ---------------------    创建学生bean -------------------------
         */
        PerfectBean perfectBean = PerfectBeanFactory.create();
        perfectBean.setBeanName("student").setClassPath("jiabin.spring.test.bean.Student");

        PerfectBeanProperty propertyName = new PerfectBeanProperty();
        propertyName.setName("name").setValue("jiabin.niu");

        PerfectBeanProperty propertyAge = new PerfectBeanProperty();
        propertyAge.setName("age").setValue("12");

        List<PerfectBeanProperty> properties = new ArrayList<>();
        properties.add(propertyName);
        properties.add(propertyAge);


        /**
         * ---------------------    创建动物bean -------------------------
         */
        PerfectBean perfectBeanAnimal = PerfectBeanFactory.create();
        perfectBeanAnimal.setBeanName("animal").setClassPath("jiabin.spring.test.bean.Animal");

        PerfectBeanProperty propertyName2 = new PerfectBeanProperty();
        propertyName2.setName("name").setValue("jiabin.niu1");

        PerfectBeanProperty propertyAge2 = new PerfectBeanProperty();
        propertyAge2.setName("age").setValue("122");

        PerfectBeanProperty propertyNameRef = new PerfectBeanProperty();
        propertyNameRef.setName("animal").setReferenceBean(perfectBeanAnimal);

        List<PerfectBeanProperty> properties2 = new ArrayList<>();
        properties2.add(propertyName2);
        properties2.add(propertyAge2);
        perfectBeanAnimal.setBeanPropertyList(properties2);


        properties.add(propertyNameRef);
        perfectBean.setBeanPropertyList(properties);

        PerfectBox.registerBean(perfectBeanAnimal);
        PerfectBox.registerBean(perfectBean);
        Student student = PerfectBox.getBean("student");
        Animal animal = PerfectBox.getBean("animal");

        System.out.println(animal);
        System.out.println(student.getAnimal().getName());
    }
}
