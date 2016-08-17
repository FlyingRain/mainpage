package com.wl.myweb.user.resourceimpl;


import com.wl.myweb.user.api.UserResource;
import com.wl.myweb.user.model.TestModel;
import org.springframework.stereotype.Component;

/**
 * Created by wul on 2016/8/17.
 */
@Component
public class UserResourceImpl implements UserResource{

    public TestModel sayHello(String say) {
        return new TestModel("wulei",say);
    }
}
