/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.dto;

import com.rm.util.AppEnums.UserRoomMappinStatus;

/**
 *
 * @author sivakrishna.k
 */
@lombok.Data
public class UserRoomMapping {
    private int roomId;
    private int userId;
    private String createdDaate;
    private String upatedDate;
    private UserRoomMappinStatus state;
    private int roleid;
}
