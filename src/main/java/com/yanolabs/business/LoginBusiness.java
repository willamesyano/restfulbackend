package com.yanolabs.business;

import com.yanolabs.dao.ClientDao;
import com.yanolabs.entity.ClientBeans;

import java.util.ArrayList;
import java.util.List;

public class LoginBusiness {

    ClientDao clientDao = new ClientDao();
    ClientBeans clientBeans = new ClientBeans();
    ArrayList<ClientBeans> clientList = new ArrayList<ClientBeans>();

    public ClientBeans findByUsername(String username) throws Exception{
        return clientDao.findByUsername(username);
    }

    public ClientBeans authenticate(String username, String password) throws Exception {

        try {
            clientBeans = findByUsername(username);
            if (clientBeans.getUsername().equals(username) && clientBeans.getPassword().equals(password)) {

                clientBeans.setLogged(true);

                return clientBeans;
            } else {
                return clientBeans;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientBeans;
    }
}

