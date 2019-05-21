package jiabin.spring.core;

/**
 * @author Administrator
 */

public class PerfectBeanProperty {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public PerfectBeanProperty setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public PerfectBeanProperty setValue(String value) {
        this.value = value;
        return this;
    }
}
