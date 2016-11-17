package com.yanolabs.dao.factory;

import javax.persistence.EntityManager;
import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by willames on 10/11/16.
 */
public class ConnectionFilter implements Filter {


    public void destroy(){

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            chain.doFilter(request, response);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.isOpen()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }

        }
    }


    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return false;
    }
}
