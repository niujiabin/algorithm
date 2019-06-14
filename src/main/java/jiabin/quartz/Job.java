package jiabin.quartz;

import java.util.Map;

/**
 * @author : jiabin.niu
 * @date : 2019.06.14 17:10
 */
public class Job {

    public void execute(Map<String,String> jobData){
        System.out.println("exe_job");
    }
}
