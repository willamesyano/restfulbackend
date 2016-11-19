package com.yanolabs.dao.factory;

import com.yanolabs.dao.ResourcesDao;
import com.yanolabs.entity.ResourcesBeans;

import java.util.ArrayList;

/**
 * Created by willames on 10/11/16.
 */
public class MainJpa {

    public static void main(String[] args) throws Exception{
        //Persistence.createEntityManagerFactory("backend_db");

        ResourcesDao resourcesDao = new ResourcesDao();
        ArrayList<ResourcesBeans> resourceBeans = new ArrayList<ResourcesBeans>();

        resourceBeans.addAll(resourcesDao.listAll());
        System.out.println(resourceBeans.toString());
    }
}
