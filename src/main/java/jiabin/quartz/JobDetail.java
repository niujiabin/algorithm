package jiabin.quartz;

import java.util.HashMap;

/**
 * @author : jiabin.niu
 * @date : 2019.06.14 17:11
 */
public class JobDetail {

    private Class<? extends Job> clazz;
    private String jobName;
    private HashMap<String, String> jobData;

    public JobDetail() {
        jobData = new HashMap<>();
    }

    public JobDetail(String jobName, Class<? extends Job> clazz) {
        this();
        this.jobName = jobName;
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobDetail jobDetail = (JobDetail) o;
        return jobName != null ? !jobName.equals(jobDetail.jobName) : jobDetail.jobName != null;
    }

    @Override
    public int hashCode() {
        int result = clazz != null ? clazz.hashCode() : 0;
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        return result;
    }

    public Class<? extends Job> getClazz() {
        return clazz;
    }

    public JobDetail setClazz(Class<? extends Job> clazz) {
        this.clazz = clazz;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public JobDetail setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public HashMap<String, String> getJobData() {
        return jobData;
    }

    public JobDetail setJobData(HashMap<String, String> jobData) {
        this.jobData = jobData;
        return this;
    }
}
