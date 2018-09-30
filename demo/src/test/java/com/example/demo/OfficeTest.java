package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.serviceinterfaces.OfficeService;
import com.example.demo.views.OfficeView;
import com.example.demo.views.OfficeViewSave;
import com.example.demo.views.OfficeViewUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
@DirtiesContext
public class OfficeTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    OfficeService officeService;

    private final List<Integer> officeId = new ArrayList<>();

    @Before
    public void testBefore() {
        OfficeViewSave office = new OfficeViewSave();
        office.setIsActive(true);
        office.setPhone("phone");
        office.setName("name");
        office.setAddress("address");
        officeService.save(office);
        officeId.add(0);
    }

    @Test
    public void testSaveOffice() throws JSONException { // добавить офис
        OfficeViewSave office = new OfficeViewSave();
        office.setIsActive(true);
        office.setPhone("phone");
        office.setName("testName");
        office.setAddress("address");

        String s = restTemplate.postForObject("/office/save", office, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);
    }

    @Test
    public void testOfficeId() { // получить офис по ид
        Integer id = officeId.get(0);
        Map<String, String> params = new HashMap<>();
        params.put("id", id.toString());

        OfficeView office = restTemplate.getForObject("/office/{id}", OfficeView.class, params);
        Assert.assertEquals(id, office.getId());
    }

    @Test
    public void testUpdateOffice() throws JSONException { // обновить офис
        OfficeViewUpdate office = new OfficeViewUpdate();
        office.setId(officeId.get(0));
        office.setIsActive(true);
        office.setPhone("phone");
        office.setName("SetName");
        office.setAddress("address");

        String s = restTemplate.postForObject("/office/update", office, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);

    }

    @Test
    public void testOrgOffice() throws JSONException { // Все офисы данной организации
        OfficeView office = new OfficeView();
        office.setName("");

        String officeIn = restTemplate.postForObject("/office/list/0", office, String.class);
        Assert.assertTrue(new JSONObject(officeIn).getJSONArray("Data").length() >= 2);
    }

    @After
    public void testAfter() {
        officeId.forEach(id -> officeService.delete(id));
    }
}
