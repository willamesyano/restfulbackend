package com.yanolabs.business;

import com.yanolabs.dao.ResourcesDao;
import com.yanolabs.entity.ResourcesBeans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ResourcesBusiness {

    ResourcesDao resourcesDao = new ResourcesDao();

    public void addResource(ResourcesBeans resourcesBeans) throws Exception{
        resourcesDao.addResource(resourcesBeans);
    }

    public void updateResource(ResourcesBeans resourcesBeans){
        resourcesDao.updateResource(resourcesBeans);
    }

    public void deleteResource(ResourcesBeans rb){
        resourcesDao.deleteResource(rb);
    }

    public List<ResourcesBeans> listAll()throws Exception{
        return resourcesDao.listAll();
    }

    public ResourcesBeans findById(int id) throws Exception{
        return resourcesDao.findById(id);
    }

}
