package com.yanolabs.resources;

import com.yanolabs.business.ResourcesBusiness;
import com.yanolabs.core.utils.URL;
import com.yanolabs.entity.ResourcesBeans;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by willames on 03/11/16.
 */

@Path(URL.RESOURCE_PATH)
public class ResourcesResource {

    private ArrayList<ResourcesBeans> resourcesList = new ArrayList<ResourcesBeans>();
    GenericEntity< ArrayList<ResourcesBeans>> entity;
    ResourcesBusiness resourcesBusiness = new ResourcesBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResources() throws Exception {
        resourcesList.addAll(resourcesBusiness.listAll());
        entity  = new GenericEntity< ArrayList<ResourcesBeans> >( resourcesList ){ };
        return Response.ok(entity).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResource(@PathParam("id") int id) throws Exception {

        ResourcesBeans rb = resourcesBusiness.findById(id);
        if(rb != null){
            return Response.ok(rb).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addResource(ResourcesBeans resourcesBeans) throws Exception{
        if(resourcesBeans != null){
            resourcesBusiness.addResource(resourcesBeans);
            URI uriCreated = URI.create(URL.RESOURCE_PATH);
            return Response.created(uriCreated).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("entity cannot be blank").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateResource(ResourcesBeans resourcesBeans) {

        if(resourcesBeans != null) {
            resourcesBusiness.updateResource(resourcesBeans);
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("entity cannot be blank").build();
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteResource(@PathParam("id") int id) throws Exception {

        ResourcesBeans rb = resourcesBusiness.findById(id);
        if(rb != null){
            resourcesBusiness.deleteResource(rb);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
