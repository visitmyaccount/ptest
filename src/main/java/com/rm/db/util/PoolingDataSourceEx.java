/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.db.util;

/**
 *
 * @author sivakrishna.k
 */
import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;

public class PoolingDataSourceEx {

    
    
    
    
    public static DataSource setupDataSource(String connectURI) {
        ConnectionFactory connectionFactory
                = new DriverManagerConnectionFactory(connectURI, null);
        PoolableConnectionFactory poolableConnectionFactory
                = new PoolableConnectionFactory(connectionFactory, null);
        ObjectPool<PoolableConnection> connectionPool
                = new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(connectionPool);
        PoolingDataSource<PoolableConnection> dataSource
                = new PoolingDataSource<>(connectionPool);
        return dataSource;
    }
    public static DataSource setupDataSource(String connectURI, String username, String passwd) {
        ConnectionFactory connectionFactory
                = new DriverManagerConnectionFactory(connectURI, username, passwd);
        PoolableConnectionFactory poolableConnectionFactory
                = new PoolableConnectionFactory(connectionFactory, null);
        ObjectPool<PoolableConnection> connectionPool
                = new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(connectionPool);
        PoolingDataSource<PoolableConnection> dataSource
                = new PoolingDataSource<>(connectionPool);
        return dataSource;
    }
}
