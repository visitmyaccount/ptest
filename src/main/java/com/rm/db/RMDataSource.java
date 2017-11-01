/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.db;

import java.sql.Connection;

/**
 *
 * @author sivakrishna.k
 */
public interface RMDataSource {
    public Connection getConnection(String dbName);
}
