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
public class QueryUtils {
 
    public enum Query{

        SELECT_ROOMS("SELECT * FROM `test_me`.`room`"),
        SELECT_ROOM_BY_ID(""),
        CREATE_ROOM("INSERT INTO `test_me`.`room` (`name`, `address`) VALUES (?, ?)"),
        CREATE_USER("INSERT INTO `test_me`.`user` (`name`, `userid`, `password`,`mobileno`, `address`, `created_date`, `updated_date`) VALUES( ?, ?, ?, ?, ?, now(), now())"),
        CREATE_USER_ROOM_MAPPING("INSERT INTO `test_me`.`user_room_mapping` (`roomid`, `userid`, `roleid`,`created_date`, `updated_date`, `status`) VALUES(?, ?, ?, NOW(), NOW(), ?)"),
        SELECT_USER_ROOM_MAPPINGS("SELECT * FROM `test_me`.`user_room_mapping`"),
        SELECT_USERS("SELECT * FROM `test_me`.`user`"),
        SELECT_ROOM_USERS("SELECT * from `test_me`.`user` us,  `test_me`.`user_room_mapping` urm where  us.id = urm.userid and roomid= !roomid!"),
        ;
        private String query;

        private Query(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
        
    }
}
