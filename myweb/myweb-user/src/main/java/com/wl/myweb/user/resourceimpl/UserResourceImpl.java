package com.wl.myweb.user.resourceimpl;


import com.wl.myweb.user.api.UserResource;
import com.wl.myweb.user.model.TestModel;
import com.wl.myweb.user.service.UserService;
import com.wl.myweb.user.service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.QueryParam;

/**
 * Created by wul on 2016/8/17.
 */
@Component
public class UserResourceImpl implements UserResource {


    @Autowired
    UserService userService;

    public TestModel sayHello(String say) {
        return new TestModel("wulei", say);
    }

    @Override
    public String login(@QueryParam("userName") String userName, @QueryParam("password") String password) {

        User user = userService.getUserByNamePwd(userName, password);

        if (user == null) {
            return "wrong userName or password!";
        } else {
            return "Hello," + userName + "!";
        }
    }
}
