/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.service;

import com.rm.dao.DAOService;
import com.rm.dao.MySqlService;
import com.rm.dto.Address;
import com.rm.dto.Room;
import com.rm.dto.User;
import com.rm.dto.UserRoomMapping;
import com.rm.util.AppEnums.ROLE;
import com.rm.util.AppEnums.UserRoomMappinStatus;
import java.util.List;

/**
 *
 * @author sivakrishna.k
 */
public class RoomService {
    
    DAOService dAOService;

    public RoomService() {
        dAOService = new MySqlService();
    }
    
    
    public void createRoom(String name, Address address ){
        
        Room room = new Room();
        room.setAddress(address);
        room.setName(name);
        boolean created = dAOService.create(room);
        
        if (created) {
            System.out.println("Room Created");
        }else{
            System.out.println("Room not created");
        }
        
    }
    
    public void getAllRooms(){
        
        List<Room> rooms = dAOService.getRooms();
        
        rooms.forEach(System.out::println);
    }
    
    
    public void createUser(User user){
        boolean create = dAOService.create(user);
        if (create) {
            System.out.println("User created");
        } else {
            System.out.println("User not created");
        }
    }
    
    public void getAllUsers(){
        
        List<User> users = dAOService.getUsers();
        users.forEach(System.out::println);
    
    }
    
    public void mappUserToRoom(int userId, int roomId, ROLE role, UserRoomMappinStatus mappinStatus){
        
        UserRoomMapping roomMapping = new UserRoomMapping();
        
        roomMapping.setUserId(userId);
        roomMapping.setRoomId(roomId);
        roomMapping.setRoleid(role.getId());
        boolean createMapping = dAOService.createMapping(roomMapping);
        if (createMapping) {
            System.out.println("mapping created");
        } else {
            System.out.println("mapping not created");
        }
    }
    
    public void getRoomMemebers(int roomId){
        List<User> roomUsers = dAOService.getRoomUsers(roomId);
        
        roomUsers.forEach(System.out::println);
        
    }
    
    
    
}
