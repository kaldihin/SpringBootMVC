package com.example.demo.doc;

import com.example.demo.Application;
import com.example.demo.serviceinterfaces.DocService;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class DocTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    DocService officeService;

    /**
     * Получить все поля таблицы doc и проверить соответствуют ли они содержимому
     */

    @Test
    public void testDocList() {

        JSONObject js = new JSONObject(restTemplate.getForObject("/docs", JSONObject.class));

        boolean firstField = js.toJSONString().contains("Паспорт гражданина Российской Федерации");
        boolean secondField = js.toJSONString().contains("13");
        boolean thirdField = js.toJSONString().contains("Свидетельство о рождении");

        Assert.assertTrue(firstField && secondField && thirdField);
    }
}
