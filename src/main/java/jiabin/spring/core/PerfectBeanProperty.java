package jiabin.spring.core;

/**
 * @author Administrator
 */

public class PerfectBeanProperty {

    private String name;
    private String value;
    private PerfectBean referenceBean;

    public PerfectBean getReferenceBean() {
        return referenceBean;
    }

    public PerfectBeanProperty setReferenceBean(PerfectBean referenceBean) {
        this.referenceBean = referenceBean;
        return this;
    }

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
