package cn.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MassiveStars on 2018/1/28.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "server", method = RequestMethod.GET)
    public ResponseEntity<String> getData() {

        HttpHeaders headers = new HttpHeaders();

        final HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        Map<String, Object> vars = new HashMap<String, Object>();

        return ResponseEntity.ok("this is service server");
    }

}
