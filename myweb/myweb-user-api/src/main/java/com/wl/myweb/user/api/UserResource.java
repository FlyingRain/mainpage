package com.wl.myweb.user.api;

import com.wl.myweb.api.Resource;
import com.wl.myweb.user.model.TestModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wul on 2016/8/17.
 */
@Path("/myweb")
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource extends Resource {

    @GET
    @Path("/hello")
    TestModel sayHello(@QueryParam("say") String say);

    @GET
    @Path("/login")
    String login(@QueryParam("userName") String userName, @QueryParam("password") String password);

}
