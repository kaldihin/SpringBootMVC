package com.example.demo.country;

import com.example.demo.Application;
import com.example.demo.serviceinterfaces.DocService;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class CountryTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    DocService officeService;

    @Before
    public void testBefore() {
    }

    /**
     * Получить все поля таблицы country и проверить соответствуют ли они содержимому
     */

    @Test
    public void testCountryList() {

        JSONObject js = new JSONObject(restTemplate.getForObject("/countries", JSONObject.class));

        boolean firstField = js.toJSONString().contains("Россия");
        boolean secondField = js.toJSONString().contains("659");
        boolean thirdField = js.toJSONString().contains("784");

        Assert.assertTrue(firstField && secondField && thirdField);
    }
}
