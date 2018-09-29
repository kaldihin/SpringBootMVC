package com.example.demo;

import com.example.demo.daoimplementations.OrganizationDaoImpl;
import com.example.demo.daointerfaces.OrganizationDao;
import com.example.demo.models.Organization;
import com.example.demo.views.OrganizationViewList;
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
    TestRestTemplate testRestTemplate;

    @Test
    public void test() {
        Organization org = new Organization();
        org.setIsActive(true);
        org.setName("reryhehr");
        org.setoId(1);
        org.setAddress("erhehrthrtjhtjt346");

        this.mockMvc.perform("organization/save")

        organizationDaoImpl.save(org);
        System.out.println(organizationDaoImpl.getById(1).getName());
        List<Organization> list = organizationDaoImpl.list();
        for (Organization organization : list) {
            System.out.println(organization.getName());
            System.out.println(organization.getAddress());
        }

    }
}
