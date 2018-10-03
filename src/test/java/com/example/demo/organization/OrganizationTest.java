package com.example.demo.organization;

import com.example.demo.Application;
import com.example.demo.views.OrganizationViewUpdate;
import org.junit.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.serviceinterfaces.OrganizationService;
import com.example.demo.views.OrganizationViewSave;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class OrganizationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    OrganizationService organizationService;

    /**
     * Сохранить организацию в таблицу organization и проверить возвращаемое значение на наличие строки "success"
     */
    @Test
    public void testSaveOrganization() {
        OrganizationViewSave organizationViewSave = new OrganizationViewSave();
        organizationViewSave.setName("testName");
        organizationViewSave.setFullName("TestFullName");
        organizationViewSave.setVersion(0);
        organizationViewSave.setInn(2636754);
        organizationViewSave.setKpp(86854223);
        organizationViewSave.setAddress("TestAddress");
        organizationViewSave.setPhone("89278763421");
        organizationViewSave.setIsActive(true);

        JSONObject s = new JSONObject(restTemplate.postForObject("/organization/save", organizationViewSave, HashMap.class));

        boolean result = s.toString().contains("success");

        Assert.assertTrue(result);

//        JSONObject showData = new JSONObject(restTemplate.getForObject("/organization/list", HashMap.class));
//        System.out.println(showData.toString());

    }

    /**
     * Получить организацию из таблицы organization по заданному Id и проверить в результате наличие строки organization_id:Id
     */
    @Test
    public void testIdOrganization() {
        int id = 4;
        JSONObject jsonObject = new JSONObject(restTemplate.getForObject("/organization/"+id, HashMap.class));

        boolean result = jsonObject.toString().contains("organization_id:" + id);

        Assert.assertTrue(result);

//        System.out.println(jsonObject.toString());

    }

    /**
     * Обновить поле в таблицу organization по значению Id и проверить возвращаемое значение на наличие строки "success"
     * @throws JSONException
     */
    @Test
    public void testUpdateOrganization() throws JSONException {
        OrganizationViewUpdate organizationViewUpdate = new OrganizationViewUpdate();
        organizationViewUpdate.setId(1);
        organizationViewUpdate.setName("testUpdateName");
        organizationViewUpdate.setFullName("testUpdateFullName");
        organizationViewUpdate.setVersion(1);
        organizationViewUpdate.setInn(321);
        organizationViewUpdate.setKpp(321);
        organizationViewUpdate.setAddress("testUpdateAddress");
        organizationViewUpdate.setPhone("phone");
        organizationViewUpdate.setIsActive(true);

        JSONObject jsonObject = new JSONObject(restTemplate.postForObject("/organization/update", organizationViewUpdate, String.class));

        boolean result = jsonObject.toString().contains("success");

        Assert.assertTrue("success", result);

//        JSONObject showData = new JSONObject(restTemplate.getForObject("/organization/list", HashMap.class));
//        System.out.println(showData.toString());

    }

    /**
     * Получить все записи из таблицы organization
     */
    @Test
    public void testListOrganization() {

        JSONObject jsonObject = new JSONObject(restTemplate.getForObject("/organization/list", HashMap.class));

        boolean firstField = jsonObject.toString().contains("Bad Organization");
        boolean secondField = jsonObject.toString().contains("164178866");
        boolean thirdField = jsonObject.toString().contains("Новая организация");

        Assert.assertTrue(firstField && secondField && thirdField);

//        System.out.println(jsonObject.toString());
    }
    
}