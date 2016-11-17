package com.yanolabs.business;

import com.yanolabs.dao.ResourcesDao;
import com.yanolabs.entity.ResourcesBeans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ResourcesBusiness {

    ResourcesDao resourcesDao = new ResourcesDao();

    public void addResource(ResourcesBeans resourcesBeans){
        resourcesDao.addResource(resourcesBeans);
    }

    public void updateResource(ResourcesBeans resourcesBeans){
        resourcesDao.updateResource(resourcesBeans);
    }

    public void deleteResource(int id){
        resourcesDao.deleteResource(id);
    }

    public List<ResourcesBeans> listarTodos()throws Exception{
        return resourcesDao.listarTodos();
    }

    public List<ResourcesBeans> listById(int id) throws Exception{
        return resourcesDao.listById(id);
    }

}
