package com.wl.myweb.user.resourceimpl;


import com.wl.myweb.basic.utils.ModelToView;
import com.wl.myweb.user.api.UserResource;
import com.wl.myweb.user.model.SignRequest;
import com.wl.myweb.user.model.TestModel;
import com.wl.myweb.user.model.User;
import com.wl.myweb.user.service.UserService;
import com.wl.myweb.user.service.models.UserModel;
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
        logger.info("get request!" + say);
        return new TestModel("wulei", say);
    }

    @Override

    public User login(String userName, String password) {

        logger.info("accept request : userName=" + userName);
        UserModel userModel = userService.getUserByNamePwd(userName,password);
        return ModelToView.modelToView(userModel,User.class);
    }

    @Override
    public User sign(SignRequest signRequest) {
        logger.info("start sign:" + signRequest);

        return null;
    }
}
