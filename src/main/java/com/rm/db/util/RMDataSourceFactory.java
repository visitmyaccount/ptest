/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.db.util;

import com.rm.db.RMDataSource;
import com.rm.db.impl.RMDataSourceImpl;

/**
 *
 * @author sivakrishna.k
 */
public class RMDataSourceFactory {
    private static RMDataSourceImpl dataSourceImpl = null;
    private static Object lockObj = new Object();
    public static RMDataSource getDataSource() {
        if (dataSourceImpl == null) {
            synchronized(lockObj){
                if (dataSourceImpl == null) {
                    dataSourceImpl  = new RMDataSourceImpl();
                }
            }
        }
        return dataSourceImpl;
    }
    
}
