package com.yanolabs.resources;

import com.yanolabs.business.ResourcesBusiness;
import com.yanolabs.entity.ResourcesBeans;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by willames on 03/11/16.
 */

@Path("/resources")
public class ResourcesResource {

    private ArrayList<ResourcesBeans> resourcesMap = new ArrayList<ResourcesBeans>();
    ResourcesBusiness resourcesBusiness = new ResourcesBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResourcesBeans> getResources() throws Exception {
        resourcesMap.addAll(resourcesBusiness.listarTodos());
        return resourcesMap;
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResourcesBeans getResources(@PathParam("id") int id) throws Exception {
        resourcesMap.addAll(resourcesBusiness.listById(id));
        return resourcesMap.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adicionaResource(ResourcesBeans resourcesBeans) {
        resourcesBusiness.addResource(resourcesBeans);
        return resourcesBeans.getDescricao() + " adicionado.";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateResource(ResourcesBeans resourcesBeans) {
        resourcesBusiness.updateResource(resourcesBeans);
        return resourcesBeans.getDescricao() + " atualizada.";
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteResource(@PathParam("id") int id) {
        resourcesBusiness.deleteResource(id);
        return " Removido!";
    }

}
