package com.example.demo;

import com.example.demo.daointerfaces.OrganizationDao;
import com.example.demo.models.Office;
import com.example.demo.models.Organization;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class NewTest {

    @Autowired
    private OrganizationDao organizationDao;

    @Test
    public void test() {
        Organization organization = new Organization(1, "Bad Organization", "Организация имени Ивана Нерусского",
                0, 564573865, 433475475, "ул.Цюрупы, 16", "89235445754", true);
        Set<Office> list = new HashSet<>();
        Office office = new Office(2, 0, "Офис реконструкции мебели", "ул.Металлургов, 43", "89275413931", false);
        office.setOrganizations(organization);
        organization.setOffices(list);
        list.add(office);
        organizationDao.save(organization);
        organizationDao.getById(1).toString();

//        List<Organization> organizations = organizationDao.list();
//        Assert.assertNotNull(organizations);
//
//        office.setOrganizations(organization);
//
//        Assert.assertFalse(organizations.isEmpty());
//
//        Set<Office> officeList = organizations.get(0).getOffices();
//
//        Assert.assertNotNull(officeList);
//        Assert.assertEquals(1, officeList.size());
//
//        Office office1 = new Office(1, 0, "Офис мебели", "ул.Металлургов, 4", "89275413931", false);
//        list.add(office1);
//
//        organizations = organizationDao.list();
//        officeList = organizations.get(0).getOffices();
//        Assert.assertNotNull(office);
//        Assert.assertEquals(2, officeList.size());
    }
}
