package com.example.demo;

import com.example.demo.daointerfaces.DocDao;
import com.example.demo.serviceinterfaces.DocService;
import com.example.demo.serviceinterfaces.OfficeService;
import com.example.demo.views.DocView;
import com.example.demo.views.OfficeView;
import com.example.demo.views.OfficeViewSave;
import com.example.demo.views.OfficeViewUpdate;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
@DirtiesContext
public class DocTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    DocService officeService;

    @Autowired
    DocDao docDao;

    private final List<Integer> docId = new ArrayList<>();

    @Before
    public void testBefore() {
    }

    @Test
    public void testSaveDoc() throws JSONException { // добавить офис
        DocView docView = new DocView();
        docView.setName("testName");
        docView.setVersion(0);
        docView.setCode(643);

//
//        String s = restTemplate.postForObject("/docs", docView, String.class);
//        String result = new JSONObject(s).getString("result");
//        Assert.assertEquals("success", result);
    }

    @Test
    public void testDocList() throws JSONException { // получить офис по ид

        JSONObject doc = new JSONObject(restTemplate.getForObject("/docs", DocView.class, HashMap.class).toString());
        System.out.println(doc);
        Assert.assertEquals(3, doc.length());
    }
//
//    @Test
//    public void testUpdateDoc() throws JSONException { // обновить офис
//        OfficeViewUpdate office = new OfficeViewUpdate();
//        office.setId(officeId.get(0));
//        office.setIsActive(true);
//        office.setPhone("phone");
//        office.setName("SetName");
//        office.setAddress("address");
//
//        String s = restTemplate.postForObject("/office/update", office, String.class);
//        String result = new JSONObject(s).getString("result");
//        Assert.assertEquals("success", result);
//
//    }
//
//    @Test
//    public void testOrgOffice() throws JSONException { // Все офисы данной организации
//        OfficeView office = new OfficeView();
//        office.setName("");
//
//        String officeIn = restTemplate.postForObject("/office/list/0", office, String.class);
//        Assert.assertTrue(new JSONObject(officeIn).getJSONArray("Data").length() >= 2);
//    }
//
//    @After
//    public void testAfter() {
//        officeId.forEach(id -> officeService.delete(id));
//    }
}
