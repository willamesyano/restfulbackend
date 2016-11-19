package com.yanolabs.core.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by willamesyano on 18/11/16.
 */
public class CreateBD {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("backend_db");
        factory.close();
    }
}
