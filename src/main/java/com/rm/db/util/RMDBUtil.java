/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sivakrishna.k
 */
public class RMDBUtil {
    
    public static void releaseResources(Connection con, PreparedStatement pstmt, Statement stmt, ResultSet rs){
        
        if (con != null) {
            try {
                con.close();
                con  = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (pstmt != null) {
            try {
                pstmt.close();
                pstmt = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
