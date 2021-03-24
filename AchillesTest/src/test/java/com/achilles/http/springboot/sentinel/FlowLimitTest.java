package com.achilles.http.springboot.sentinel;

import com.SpringbootApplicationTests;
import com.achilles.tool.http.HttpGetUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class FlowLimitTest extends SpringbootApplicationTests {

    private final static Logger log = LoggerFactory.getLogger(FlowLimitTest.class);

    String url = "http://localhost:8080/achilles/demo/flow/";

    @Test
    public void flowTest() throws Exception{

        int max = 10;
        CountDownLatch count = new CountDownLatch(max);
        for (int i = 0; i < max; i++) {
            final int m=i;
            new Thread(()->{
                String result = HttpGetUtil.get(url+m,null);
                log.info("-----------------"+m+"------------------"+result);
                count.countDown();
            }).start();
        }
        count.await();
        log.info("-----------------over----------------");
    }
}
