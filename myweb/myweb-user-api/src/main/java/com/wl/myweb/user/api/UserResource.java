package com.wl.myweb.user.api;

import com.wl.myweb.api.Resource;
import com.wl.myweb.user.model.SignRequest;
import com.wl.myweb.user.model.TestModel;
import com.wl.myweb.user.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wul on 2016/8/17.
 */
@Path("/myweb")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserResource extends Resource {

    @GET
    @Path("/hello")
    TestModel sayHello(@QueryParam("say") String say);

    @GET
    @Path("/login")
    User login(@QueryParam("userName") String userName, @QueryParam("password") String password);

    @POST
    @Path("/sign")
    User sign(SignRequest signRequest);

}
