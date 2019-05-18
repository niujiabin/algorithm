package jiabin.spring.core;

import jiabin.spring.core.PerfectBean;
import jiabin.spring.test.bean.Student;

public class PerfectBeanFactory<T> {

    public static PerfectBean create() {
        return new PerfectBean();
    }
}
