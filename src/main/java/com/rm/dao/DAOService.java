/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.dao;

import com.rm.dto.Room;
import com.rm.dto.User;
import com.rm.dto.UserRoomMapping;
import java.util.List;

/**
 *
 * @author sivakrishna.k
 */
public interface DAOService {
    public boolean create(Room room);
    public List<Room> getRooms() ;
    
    public boolean create(User user);
    public List<User> getUsers();
    
    public List<User> getRoomUsers(int roomId);
    public boolean createMapping(UserRoomMapping userRoomMapping);
}
