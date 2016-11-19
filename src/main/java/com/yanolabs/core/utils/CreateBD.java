package com.yanolabs.core.utils;

import javax.persistence.Persistence;

/**
 * Created by willamesyano on 18/11/16.
 */
public class CreateBD {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("backend_db");
    }
}
