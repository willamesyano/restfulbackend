package com.yanolabs.resources;

import com.yanolabs.business.ClientBusiness;
import com.yanolabs.entity.ClientBeans;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by willames on 03/11/16.
 */

@Path("/clients")
public class ClientResource {

    private ArrayList<ClientBeans> clientsMap = new ArrayList<ClientBeans>();
    ClientBusiness clientBusiness = new ClientBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientBeans> getClients() throws Exception {
        clientsMap.addAll(clientBusiness.listAll());
        return clientsMap;
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientBeans getClients(@PathParam("id") int id) throws Exception {
        clientsMap.addAll(clientBusiness.listById(id));
        return clientsMap.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adicionaClient(ClientBeans clientBeans) {
        clientBusiness.addClient(clientBeans);
        return clientBeans.getUsername() + " adicionado.";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateClient(ClientBeans clientBeans) {
        clientBusiness.updateClient(clientBeans);
        return clientBeans.getUsername() + " atualizada.";
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteClient(@PathParam("id") int id) {
        clientBusiness.deleteClient(id);
        return " Removido!";
    }

}
