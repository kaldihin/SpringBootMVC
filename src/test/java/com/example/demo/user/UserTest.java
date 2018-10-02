package com.example.demo.user;

import com.example.demo.Application;
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
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.serviceinterfaces.UserService;
import com.example.demo.views.UserView;
import com.example.demo.views.UserViewSave;
import com.example.demo.views.UserViewUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class UserTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserService userService;

    private final List<Integer> userId = new ArrayList();

    @Before
    public void testBefore() {
        UserViewSave user = new UserViewSave();
        user.setFirstName("firstName");
        user.setPosition("position");
        userId.add(0);
    }

    @Test
    public void testSaveUser() throws JSONException { // добавить user
        UserViewSave user = new UserViewSave();
        user.setFirstName("firstName_test");
        user.setVersion(0);
        user.setPosition("position_test");

        String s = restTemplate.postForObject("/user/save", user, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);
    }

    @Test
    public void testUserId() { // получить user по ид
        Integer id = userId.get(0);
        Map<String, String> params = new HashMap<>();
        params.put("id", id.toString());

        UserView user = restTemplate.getForObject("/user/{id}", UserView.class, params);
        Assert.assertEquals(id, user.getId());
    }

    @Test
    public void testUpdateUser() throws JSONException { // обновить user
        UserViewUpdate user = new UserViewUpdate();
        user.setFirstName("firstName");
        user.setPosition("position");
        user.setId(userId.get(0));

        String s = restTemplate.postForObject("/user/update", user, String.class);
        String result = new JSONObject(s).getString("result");
        Assert.assertEquals("success", result);
    }

    @Test
    public void testOrgOffice() throws JSONException { // Кто работает в данном офисе
        UserView userView = new UserView();
        userView.setId(1);

        String officeIn = restTemplate.postForObject("/user/list", userView, String.class);
        Assert.assertTrue(new JSONObject(officeIn).getJSONArray("Data").length() >= 2);
    }

    @After
    public void testAfter() {
        userId.forEach(id -> userService.delete(id));
    }
}