package com.yanolabs.business;

import com.yanolabs.dao.ClientDao;
import com.yanolabs.entity.ClientBeans;
import com.yanolabs.entity.ResourcesBeans;

import java.util.List;

public class ClientBusiness {

    ClientDao clientDao = new ClientDao();

    public void addClient(ClientBeans cb){
        clientDao.addClient(cb);
    }

    public void updateClient(ClientBeans clientBeans){
        clientDao.updateClient(clientBeans);
    }

    public void deleteClient(ClientBeans cb){
        clientDao.deleteClient(cb);
    }

    public List<ClientBeans> listAll()throws Exception{
        return clientDao.listAll();
    }

    public ClientBeans findById(int id) throws Exception{
        return clientDao.findById(id);
    }
}
