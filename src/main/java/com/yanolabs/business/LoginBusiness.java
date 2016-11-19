package com.yanolabs.business;

import com.yanolabs.dao.ClientDao;
import com.yanolabs.entity.ClientBeans;

public class LoginBusiness {

    ClientDao clientDao = new ClientDao();
    ClientBeans clientBeans = new ClientBeans();

    public ClientBeans authenticate(String username, String password) throws Exception {

        try {
            clientBeans = clientDao.findByUsername(username);
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


    public ClientBeans logout(ClientBeans cb) throws Exception{
        cb.setLogged(false);
        return clientDao.logout(cb);
    }
}

