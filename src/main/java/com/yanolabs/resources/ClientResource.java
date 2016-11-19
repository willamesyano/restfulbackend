package com.yanolabs.resources;

import com.yanolabs.business.ClientBusiness;
import com.yanolabs.business.ResourcesBusiness;
import com.yanolabs.core.utils.URL;
import com.yanolabs.entity.ClientBeans;
import com.yanolabs.entity.ResourcesBeans;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by willames on 03/11/16.
 */

@Path(URL.CLIENT_PATH)
public class ClientResource {

    private ArrayList<ClientBeans> clientList = new ArrayList<ClientBeans>();
    GenericEntity< ArrayList<ClientBeans>> entity;
    ClientBusiness clientBusiness = new ClientBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClients() throws Exception {
        clientList.addAll(clientBusiness.listAll());
        entity  = new GenericEntity< ArrayList<ClientBeans> >( clientList ){ };
        return Response.ok(entity).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient(@PathParam("id") int id) throws Exception {

        ClientBeans cb = clientBusiness.findById(id);
        if(cb != null){
            return Response.ok(cb).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addClient(ClientBeans cb) throws Exception{
        if(cb != null){
            clientBusiness.addClient(cb);
            URI uriCreated = URI.create(URL.RESOURCE_PATH);
            return Response.created(uriCreated).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("entity cannot be blank").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateClient(ClientBeans cb) {

        if(cb != null) {
            clientBusiness.updateClient(cb);
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("entity cannot be blank").build();
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteClient(@PathParam("id") int id) throws Exception {

        ClientBeans cb = clientBusiness.findById(id);
        if(cb != null){
            clientBusiness.deleteClient(cb);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
