package com.wl.myweb.user.resourceimpl;


import com.wl.myweb.user.api.UserResource;
import com.wl.myweb.user.model.TestModel;
import com.wl.myweb.user.service.UserService;
import com.wl.myweb.user.service.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wul on 2016/8/17.
 */
@Service
public class UserResourceImpl implements UserResource {
    Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

    @Autowired
    UserService userService;


    public TestModel sayHello(String say) {
        return new TestModel("wulei", say);
    }

    @Override
    public String login(String userName,String password) {
        logger.info("accept request : userName=" + userName);
        User user = userService.getUserByNamePwd(userName, password);

        if (user == null) {
            return "wrong userName or password!";
        } else {
            return "Hello," + userName + "!";
        }
    }
}
