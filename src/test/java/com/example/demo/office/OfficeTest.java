package com.example.demo.office;

import com.example.demo.Application;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.serviceinterfaces.OfficeService;
import com.example.demo.views.OfficeViewSave;
import com.example.demo.views.OfficeViewUpdate;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class OfficeTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    OfficeService officeService;

    /**
     * Сохранить офис в таблицу office и проверить возвращаемое значение на наличие строки "success"
     */
    @Test
    public void testSaveOffice() {
        OfficeViewSave officeViewSave = new OfficeViewSave();
        officeViewSave.setOrgId(2);
        officeViewSave.setVersion(0);
        officeViewSave.setName("testName");
        officeViewSave.setAddress("address");
        officeViewSave.setPhone("phone");
        officeViewSave.setIsActive(true);

        JSONObject jsonObject = new JSONObject(restTemplate.postForObject("/office/save", officeViewSave, HashMap.class));

        boolean result = jsonObject.toString().contains("success");

        Assert.assertTrue(result);

//        JSONObject showData = new JSONObject(restTemplate.getForObject("/office/list/"+2, HashMap.class));
//        System.out.println(showData.toString());
    }

    /**
     * Получить офис из таблицы office по заданному Id и проверить в результате наличие строки id:Id
     */
    @Test
    public void testByIdOffice() {
        Integer id = 1;

        JSONObject jsonObject = new JSONObject(restTemplate.getForObject("/office/" + id, HashMap.class));

        boolean result = jsonObject.toString().replaceAll("\"", "").contains("id:" + id);

        Assert.assertTrue(result);

//      System.out.println(jsonObject.toString());
    }

    /**
     * Обновить поле в таблице organization по значению Id и проверить возвращаемое значение на наличие строки "success"
     */
    @Test
    public void testUpdateOffice() {
        OfficeViewUpdate officeViewUpdate = new OfficeViewUpdate();
        officeViewUpdate.setId(2);
        officeViewUpdate.setVersion(1);
        officeViewUpdate.setName("SetName");
        officeViewUpdate.setAddress("address");
        officeViewUpdate.setPhone("phone");
        officeViewUpdate.setIsActive(true);

        JSONObject jsonObject = new JSONObject(restTemplate.postForObject("/office/update", officeViewUpdate, HashMap.class));

        boolean result = jsonObject.toString().contains("success");

        Assert.assertTrue(result);

//        System.out.println(jsonObject.toString());
    }

    /**
     * Получить все поля в таблице office по значению orgId и проверить в результате наличие строки orgId:orgId
     */
    @Test
    public void testListOffice() {
        Integer id = 1;

        JSONObject jsonObject = new JSONObject(restTemplate.getForObject("/office/list/" + id, HashMap.class));

        boolean result = jsonObject.toString().replaceAll("\"", "").contains("orgId:" + id);

        Assert.assertTrue(result);

//        System.out.println(jsonObject.toString());
    }

}
