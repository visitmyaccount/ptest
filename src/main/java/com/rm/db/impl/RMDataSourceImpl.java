/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.db.impl;

import com.rm.db.RMDataSource;
import com.rm.db.util.PoolingDataSourceEx;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author sivakrishna.k
 */
public class RMDataSourceImpl implements RMDataSource{

    @Override
    public Connection getConnection(String dbName) {
        if (dbName != null && !dbName.isEmpty()) {
            String connectionURI = "jdbc:mysql://10.0.9.204:3306/" + dbName + "?";
            String userName = "AppUser";
            String password = "Im1C0ApP#1";
            DataSource setupDataSource = PoolingDataSourceEx.setupDataSource(connectionURI, userName, password);
            if (setupDataSource != null) {
                try {
                    return setupDataSource.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(RMDataSourceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
}
