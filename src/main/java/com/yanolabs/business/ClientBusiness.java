package com.yanolabs.business;

import com.yanolabs.dao.ClientDao;
import com.yanolabs.entity.ClientBeans;

import java.util.List;

public class ClientBusiness {

    ClientDao clientDao = new ClientDao();

    public void addClient(ClientBeans clientBeans){
        clientDao.addClient(clientBeans);
    }

    public void updateClient(ClientBeans clientBeans){
        clientDao.updateClient(clientBeans);
    }

    public void deleteClient(int id){
        clientDao.deleteClient(id);
    }

    public List<ClientBeans> listAll()throws Exception{
        return clientDao.listAll();
    }

    public List<ClientBeans> listById(int id) throws Exception{
        return clientDao.findById(id);
    }

}
