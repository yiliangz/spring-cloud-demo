package cn.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class RibbonRestTemplateService {
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostConstruct
    public void init() {
        setRibbonTimeOut(restTemplate, 5000);
    }

    @Autowired
    private RestTemplate restTemplate;

    public RestTemplate getTemplate() {
        return restTemplate;
    }

    /**
     * 设置timeOut
     *
     * @param restTemplate
     * @param timeOut      毫秒
     */
    private void setRibbonTimeOut(RestTemplate restTemplate, int timeOut) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(timeOut);
        requestFactory.setConnectTimeout(timeOut);
        restTemplate.setRequestFactory(requestFactory);
    }

}
