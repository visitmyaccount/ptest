/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.util;

import com.rm.dto.ExceptionInfo;
import com.rm.dto.TrapInfo;

/**
 *
 * @author sivakrishna.k
 */
public class AppUtils {
    
    public static void raiseTrap(String alertId, int alertType, int sevirity, 
            int componetId, String component, String ip, String data, 
            String desc, int state){
        
        //date
    }
    
    public static void raiseTrap(TrapInfo trapInfo){
        System.out.println("Trap Raised");
    }
    
    public static void raiseException(ExceptionInfo exceptionInfo){
        System.out.println("Exception Raised");
    }
}
