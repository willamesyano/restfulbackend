package com.yanolabs.resources;

import com.yanolabs.business.LoginBusiness;
import com.yanolabs.core.utils.URL;
import com.yanolabs.entity.ClientBeans;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by willames on 03/11/16.
 */

@Path(URL.LOGIN_PATH)
public class LoginResource {

    private ArrayList<ClientBeans> clientList = new ArrayList<ClientBeans>();
    LoginBusiness loginBusiness = new LoginBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(@HeaderParam("username") String username, @HeaderParam("password") String password) throws Exception {

        if((!username.isEmpty() || username != null) || (!password.isEmpty() || password != null ) ){
            ClientBeans cb = loginBusiness.authenticate(username, password);
            if (cb!= null){
                return Response.ok(cb).build();
            }
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(ClientBeans clientBeans) throws Exception {

        if( clientBeans != null ){
            ClientBeans cb = loginBusiness.logout(clientBeans);
            return Response.ok(cb).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
