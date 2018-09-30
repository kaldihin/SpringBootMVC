package com.example.demo;

import com.example.demo.models.Organization;
import com.example.demo.views.OrganizationViewUpdate;
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
import com.example.demo.serviceinterfaces.OrganizationService;
import com.example.demo.views.OrganizationView;
import com.example.demo.views.OrganizationViewList;
import com.example.demo.views.OrganizationViewSave;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class OrganizationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    OrganizationService organizationService;

    private List<Integer> idList = new ArrayList<>();

//    private Organization organization;

    @Before
    public void testBefore() {

    }

    @Test
    public void testSaveOrganization() throws JSONException { // добавить организацию
        OrganizationViewSave organizationViewSave = new OrganizationViewSave();
        organizationViewSave.setName("testName");
        organizationViewSave.setFullName("TestFullName");
        organizationViewSave.setVersion(0);
        organizationViewSave.setInn(123);
        organizationViewSave.setKpp(123);
        organizationViewSave.setAddress("TestAddress");
        organizationViewSave.setPhone("89278763421");
        organizationViewSave.setIsActive(true);

        String s = restTemplate.postForObject("/organization/save", organizationViewSave, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);

//        OrganizationViewList orgDelete = new OrganizationViewList();
//        orgDelete.setName(organizationViewSave.getName());
//        organizationService.list().forEach(filter -> orgId.add(filter.getId()));
    }

    @Test
    public void testOrganizationId() { // получить Organization по ид
//        Integer id = idList.get(0);
//        OrganizationView orgNew = restTemplate.getForObject("/organization/"+id, OrganizationView.class);
//        Assert.assertEquals(id, orgNew.getId());
    }

    @Test
    public void testUpdateOrganization() throws JSONException { // обновить Organization
        OrganizationViewUpdate organizationViewUpdate = new OrganizationViewUpdate();
        organizationViewUpdate.setName("testUpdateName");
        organizationViewUpdate.setFullName("testUpdateFullName");
        organizationViewUpdate.setVersion(1);
        organizationViewUpdate.setInn(321);
        organizationViewUpdate.setKpp(321);
        organizationViewUpdate.setAddress("testUpdateAddress");
        organizationViewUpdate.setPhone("phone");
        organizationViewUpdate.setIsActive(true);

        String s = restTemplate.postForObject("/organization/update", organizationViewUpdate, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);
    }


//    @After
//    public void testAfter() {
//        orgId.forEach(id -> organizationService.delete(id));
//    }
    
}