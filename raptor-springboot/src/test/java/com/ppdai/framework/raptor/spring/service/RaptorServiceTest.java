package com.ppdai.framework.raptor.spring.service;

import com.ppdai.framework.raptor.spring.RaptorSpringBootTest;
import com.ppdai.framework.raptor.spring.TestApplication;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SocketUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author yinzuolong
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RaptorServiceTest extends RaptorSpringBootTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testService() {
        String url = "http://localhost:" + port + "/more?name=ppdai";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        Assert.assertTrue(response.contains("ppdai"));
    }
}
