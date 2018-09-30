package com.example.demo;

import com.example.demo.daoimplementations.OrganizationDaoImpl;
import com.example.demo.daointerfaces.OrganizationDao;
import com.example.demo.models.Organization;
import com.example.demo.serviceimplementations.OrganizationServiceImpl;
import com.example.demo.serviceinterfaces.OrganizationService;
import com.example.demo.views.OrganizationView;
import com.example.demo.views.OrganizationViewList;
import com.example.demo.views.OrganizationViewSave;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@Transactional
@DirtiesContext
@AutoConfigureMockMvc
public class DAOTest {

    @LocalServerPort
    private int port;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private OrganizationDaoImpl organizationDaoImpl;

    @Autowired
    private OrganizationServiceImpl organizationService;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test() throws Exception {
        Organization org = new Organization();
        org.setIsActive(true);
        org.setName("reryhehr");
        org.setoId(1);
        org.setAddress("erhehrthrtjhtjt346");

        OrganizationViewSave orgSave = new OrganizationViewSave();
        orgSave.setAddress("rth5h5");
        orgSave.setName("Trye");
        orgSave.setFullName("reyeryeryr");
        orgSave.setInn(5436);
        orgSave.setKpp(223);
        orgSave.setAddress("5hdfhfh6");
        orgSave.setVersion(0);
        orgSave.setIsActive(true);

        OrganizationViewSave orgSave2 = new OrganizationViewSave();
        orgSave.setAddress("rtfg5");
        orgSave.setName("retertertertre");
        orgSave.setFullName("reygyr");
        orgSave.setInn(54356);
        orgSave.setKpp(2223);
        orgSave.setAddress("5hdyyh6");
        orgSave.setVersion(0);
        orgSave.setIsActive(false);

        organizationService.save(orgSave);

//        mockMvc.perform(get("/get?voucherId=1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(voucher)))
//                .andExpect(status().isOk());



        testRestTemplate.postForObject("/organization/save", orgSave, String.class);

        testRestTemplate.postForObject("/organization/save", orgSave2, String.class);
        Integer id = 1;
        System.out.println(id);
        String s1 = new JSONObject(testRestTemplate.getForObject("/organization/getby/"+id, HashMap.class)).toString();
        String s2 = new JSONObject(testRestTemplate.getForObject("/organization/list", String.class, HashMap.class)).toString();
        System.out.println(s1 + s2);

    }
}
