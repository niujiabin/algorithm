package jiabin.quartz;

/**
 * @author : jiabin.niu
 * @date : 2019.06.14 17:54
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        final JobDetail jobDetail1 = new JobDetail("job1",Job.class);
        jobDetail1.getJobData().put("type","job1");
        final JobDetail jobDetail2 = new JobDetail("job2",Job.class);
        jobDetail2.getJobData().put("type","job2");
        final Trigger trigger1 = new Trigger();
        trigger1.setNextFireTime(System.currentTimeMillis() + 30001);
        final Trigger trigger2 = new Trigger();
        trigger2.setNextFireTime(System.currentTimeMillis() + 10001);

        Scheduler scheduler = new Scheduler();
        scheduler.schedulerJob(jobDetail1,trigger1);
        scheduler.schedulerJob(jobDetail2,trigger2);

        scheduler.start();
        Thread.sleep(100001);
        scheduler.halt();
    }
}
