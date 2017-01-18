package com.wl.myweb.user.resourceimpl;


import com.wl.myweb.api.model.Result;
import com.wl.myweb.api.model.ReturnCode;
import com.wl.myweb.basic.utils.ModelToView;
import com.wl.myweb.user.api.UserResource;
import com.wl.myweb.user.model.User;
import com.wl.myweb.user.model.TestModel;
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

    public Result<User> login(String userName, String password) {

        logger.info("accept request : userName=" + userName);
        UserModel userModel = userService.getUserByNamePwd(userName,password);
        return new Result<>(ReturnCode.SUCCESS.code,ReturnCode.SUCCESS.value,ModelToView.modelToView(userModel,User.class));
    }

    @Override
    public Result<User> sign(User signRequest) {
        logger.info("start sign:" + signRequest);
        if(userService.getUserByUserName(signRequest.getUserName())!=null){
            return new Result<>(ReturnCode.FAIL_HAVE_EXIST.code,ReturnCode.FAIL_HAVE_EXIST.value,null);
        }

        UserModel user = userService.sign(signRequest);

        return new Result<>(ReturnCode.SUCCESS.code,ReturnCode.SUCCESS.value,ModelToView.modelToView(user,User.class));
    }

    @Override
    public Result<String> getPassword(String email) {
        String password = userService.getPwdByEmail(email);
        return new Result<>(ReturnCode.SUCCESS.code,ReturnCode.SUCCESS.value,password);
    }
}
