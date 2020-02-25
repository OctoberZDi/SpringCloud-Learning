package com.didispace;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * description: ConsumerService <br>
 * date: 2020/1/2 9:53 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String fallback() {
        return "fallbck";
    }

    @HystrixCommand(fallbackMethod = "fallback2")
    public String testException() {
        int i = 1 / 0;

        return "2222";
    }

    public String fallback2() {
        return "Exception";
    }
}
