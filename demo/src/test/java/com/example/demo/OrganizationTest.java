package com.example.demo;

import com.example.demo.serviceimplementations.OrganizationServiceImpl;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.DemoApplication;
import com.example.demo.serviceinterfaces.OrganizationService;
import com.example.demo.views.OrganizationView;
import com.example.demo.views.OrganizationViewList;
import com.example.demo.views.OrganizationViewSave;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {DemoApplication.class})
public class OrganizationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    OrganizationService organizationService;

    private final List<Integer> orgId = new ArrayList<>();

    @Before
    public void testBefore() {
        OrganizationViewSave org = new OrganizationViewSave();
        org.setAddress("Address");
        org.setName("name");
        org.setKpp(123);
        org.setInn(123);
        org.setFullName("fullName");
        orgId.add(0);
    }

    @Test
    public void testSaveOrganization() throws JSONException { // добавить организацию
        OrganizationViewSave org = new OrganizationViewSave();
        org.setAddress("TestAddress");
        org.setName("testName");
        org.setKpp(123);
        org.setInn(123);
        org.setFullName("TestFullName");

        String s = restTemplate.postForObject("/organization/save", org, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);

        OrganizationViewList orgDelete = new OrganizationViewList();
        orgDelete.setName(org.getName());
        organizationService.list().forEach(filter -> orgId.add(filter.getId()));
    }

    @Test
    public void testOrganizationId() { // получить Organization по ид
        Integer id = orgId.get(0);
        OrganizationView orgNew = restTemplate.getForObject("/organization/"+id, OrganizationView.class);
        Assert.assertEquals(id, orgNew.getId());
    }

    @Test
    public void testUpdateOrganization() throws JSONException { // обновить Organization
        OrganizationView orgNew = new OrganizationView();
        orgNew.setId(orgId.get(0));
        orgNew.setName("orgNew1");
        orgNew.setAddress("address");
        orgNew.setPhone("phone");
        orgNew.setIsActive(true);
        orgNew.setKpp(321);
        orgNew.setInn(321);
        orgNew.setFullName("fullName");

        String s = restTemplate.postForObject("/organization/update", orgNew, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);
    }


    @After
    public void testAfter() {
        orgId.forEach(id -> organizationService.delete(id));
    }
    
}