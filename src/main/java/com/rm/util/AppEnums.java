/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.util;

/**
 *
 * @author sivakrishna.k
 */
public class AppEnums {
    
    public enum DBNames{
        TEST_ME("test_me");
        private String name;
        private DBNames(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }   
        
    }
    
    public enum UserRoomMappinStatus{
        ACTIVE(0),
        INACTIVE(1);
        private int id;

        private UserRoomMappinStatus(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
        
    }
    
    public enum ROLE{
        PLATFORM_ADMIN(1), 
        ROOM_ADMIN(2), 
        ROOM_FINANCIAR(3), 
        ROOM_MEMBER(4);
        
        private int id;

        private ROLE(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
        
        
        
    }
}
