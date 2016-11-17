package com.yanolabs.resources;

import com.yanolabs.business.LoginBusiness;
import com.yanolabs.entity.ClientBeans;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by willames on 03/11/16.
 */

@Path("/login")
public class LoginResource {

    private ArrayList<ClientBeans> clientList = new ArrayList<ClientBeans>();
    LoginBusiness loginBusiness = new LoginBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientBeans> authenticateUser(@HeaderParam("username") String username, @HeaderParam("password") String password) throws Exception {
            clientList.add(loginBusiness.authenticate(username, password));
            return clientList;
    }
}
