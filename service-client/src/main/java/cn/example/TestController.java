package cn.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MassiveStars on 2018/1/28.
 */
@Controller(value = "TestControllerV1")
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private RibbonRestTemplateService ribbonService;

    @RequestMapping(value = "ribbon", method = RequestMethod.GET)
    public ResponseEntity<String> getData() {

        HttpHeaders headers = new HttpHeaders();

        final HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        Map<String, Object> vars = new HashMap<String, Object>();

        String result = ribbonService.getTemplate().exchange("http://service-server/test/server", HttpMethod.GET,
                requestEntity, String.class, vars).getBody();

        System.out.println("get response from service server");

        return ResponseEntity.ok("this is client");
    }

}
