package jiabin.quartz;

/**
 * @author : jiabin.niu
 * @date : 2019.06.14 17:16
 */
public class Trigger implements Comparable<Trigger> {

    private String jobKey;
    private long nextFireTime;


    @Override
    public int compareTo(Trigger o) {
        return (int) (this.nextFireTime - o.nextFireTime);
    }

    public void reset() {
        setNextFireTime(nextFireTime);
    }

    public String getJobKey() {
        return jobKey;
    }

    public Trigger setJobKey(String jobKey) {
        this.jobKey = jobKey;
        return this;
    }

    public long getNextFireTime() {
        return nextFireTime;
    }

    public Trigger setNextFireTime(long nextFireTime) {
        this.nextFireTime = nextFireTime;
        return this;
    }
}
