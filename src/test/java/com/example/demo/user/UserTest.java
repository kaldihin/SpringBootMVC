package com.example.demo.user;

import com.example.demo.Application;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.serviceinterfaces.UserService;
import com.example.demo.views.UserViewSave;
import com.example.demo.views.UserViewUpdate;

import java.sql.Date;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class UserTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserService userService;

    /**
     * Сохранить сотрудника в таблицу user и проверить возвращаемое значение на наличие строки "success"
     */
    @Test
    public void testSaveUser() {
        UserViewSave userViewSave = new UserViewSave();
        userViewSave.setOfficeId(1);
        userViewSave.setVersion(0);
        userViewSave.setFirstName("firstName_test");
        userViewSave.setSecondName("SecondNameTest");
        userViewSave.setMiddleName("MiddleNameTest");
        userViewSave.setLastName("LastNameTest");
        userViewSave.setPosition("position_test");
        userViewSave.setDocCode(13);
        userViewSave.setDocName("DocNameTest");
        userViewSave.setDocNumber(4);
        userViewSave.setDocDate(Date.valueOf("2017-09-09"));
        userViewSave.setCitizenshipName("Angola");
        userViewSave.setCitizenshipCode(659);
        userViewSave.setPhone("89378679564");
        userViewSave.setIdentified(false);

        JSONObject jsonObject = new JSONObject(restTemplate.postForObject("/user/save", userViewSave, HashMap.class));

        boolean result = jsonObject.toString().contains("success");

        Assert.assertTrue(result);

//        JSONObject showData = new JSONObject(restTemplate.getForObject("/user/list", HashMap.class));
//        System.out.println(showData.toString());
    }

    /**
     * Получить сотрудника из таблицы user по заданному Id и проверить в результате наличие строки id:Id
     */
    @Test
    public void testUserId() {
        Integer id = 1;

        JSONObject jsonObject = new JSONObject(restTemplate.getForObject("/user/"+ id, HashMap.class));

        boolean result = jsonObject.toString().replaceAll("\"", "").contains("id:" + id);

        Assert.assertTrue(result);

//        System.out.println(jsonObject.toString());
    }

    /**
     * Обновить поле в таблице user и проверить возвращаемое значение на наличие строки "success"
     */
    @Test
    public void testUpdateUser() {
        UserViewUpdate userViewUpdate = new UserViewUpdate();
        userViewUpdate.setId(2);
        userViewUpdate.setOfficeId(2);
        userViewUpdate.setVersion(1);
        userViewUpdate.setFirstName("FirstNameTest");
        userViewUpdate.setSecondName("SecondNameTest");
        userViewUpdate.setMiddleName("MiddleNameTest");
        userViewUpdate.setLastName("LastNameTest");
        userViewUpdate.setPosition("PositionTest");
        userViewUpdate.setDocCode(21);
        userViewUpdate.setDocName("DocNameTest");
        userViewUpdate.setDocNumber(2);
        userViewUpdate.setDocDate(Date.valueOf("2013-12-12"));
        userViewUpdate.setCitizenshipName("CitizenshipNameTest");
        userViewUpdate.setCitizenshipCode(784);
        userViewUpdate.setPhone("89424657832");
        userViewUpdate.setIdentified(true);

        JSONObject jsonObject = new JSONObject(restTemplate.postForObject("/user/update", userViewUpdate, HashMap.class));
        System.out.println(jsonObject.toString());

        boolean result = jsonObject.toString().contains("success");

        Assert.assertTrue(result);

//        JSONObject showData = new JSONObject(restTemplate.getForObject("/user/list", HashMap.class));
//        System.out.println(showData.toString());
    }

    /**
     * Получить все записи из таблицы user
     */
    @Test
    public void testListUser() {

        JSONObject jsonObject = new JSONObject(restTemplate.getForObject("/user/list", HashMap.class));

        boolean firstField = jsonObject.toString().contains("Федя");
        boolean secondField = jsonObject.toString().contains("659");
        boolean thirdField = jsonObject.toString().contains("8573542310");

        Assert.assertTrue(firstField && secondField && thirdField);

//        System.out.println(jsonObject.toString());
    }
}