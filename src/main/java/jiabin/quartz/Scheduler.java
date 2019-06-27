package jiabin.quartz;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author : jiabin.niu
 * @date : 2019.06.14 17:19
 */
public class Scheduler {

    private List<JobDetail> jobDetailList = new ArrayList<>();
    private TreeSet<Trigger> triggerList = new TreeSet<>();
    private Object lockObject = new Object();
    SchedulerThread thread = new SchedulerThread();

    /**
     * Scheduler 同时维护了JobDetail和Trigger
     *
     * @param jobDetail
     * @param trigger
     */
    public void schedulerJob(JobDetail jobDetail, Trigger trigger) {
        synchronized (lockObject) {
            jobDetailList.add(jobDetail);
            trigger.setJobKey(jobDetail.getJobName());
            triggerList.add(trigger);
        }
    }

    public void start() {
        System.out.println("start");
        thread.run();
    }

    public void halt() {
        System.out.println("halt");
        thread.halt();
    }

    class SchedulerThread implements Runnable {

        private boolean shutDown = false;

        @Override
        public void run() {
            synchronized (lockObject) {
                while (!shutDown) {
                    try {
                        //获取第一个执行器
                        final Trigger trigger = triggerList.pollFirst();
                        //当前线程获取不到执行器trigger 释放对象monitor  阻塞一段时间
                        if (trigger == null) {
                            lockObject.wait(100);
                            continue;
                        }
                        long curr = System.currentTimeMillis();
                        long nextTime = trigger.getNextFireTime();
                        //没有达到下次触发的时间
                        while (nextTime > curr && !shutDown) {
                            curr = System.currentTimeMillis();

                            //没有到达下次触发的时间  暂停此任务 直到下次执行开始
                            if (nextTime > curr + 1) {
                                lockObject.wait(nextTime - curr);
                            }

                            //执行器的任务开始执行
                            if (!shutDown) {
                                //获取该trigger中的任务
                                int index = jobDetailList.indexOf(new JobDetail(trigger.getJobKey(), null));
                                JobDetail jobDetail = jobDetailList.get(index);
                                Job job = jobDetail.getClazz().newInstance();
                                job.execute(jobDetail.getJobData());
                                //执行后重置时间
                                trigger.reset();
                                nextTime = trigger.getNextFireTime();
                                if (nextTime != -1) {
                                    //继续放入任务队列
                                    triggerList.add(trigger);
                                } else {
                                    break;
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        public void halt() {
            synchronized (lockObject) {
                shutDown = true;
                lockObject.notifyAll();
            }
        }

    }

}
