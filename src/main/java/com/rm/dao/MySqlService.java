/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.dao;

import com.google.gson.JsonSyntaxException;
import com.rm.db.RMDataSource;
import com.rm.db.util.RMDBUtil;
import com.rm.db.util.RMDataSourceFactory;
import com.rm.dto.Address;
import com.rm.dto.Room;
import com.rm.dto.User;
import com.rm.dto.UserRoomMapping;
import com.rm.util.AppEnums;
import com.rm.util.AppUtils;
import com.rm.util.QueryUtils;
import com.rm.util.RMGsonUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sivakrishna.k
 */
public class MySqlService implements DAOService {

    RMDataSource dataSource;

    public MySqlService() {
        this.dataSource = RMDataSourceFactory.getDataSource();
    }

    @Override
    public boolean create(Room room) {

        boolean created = false;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection(AppEnums.DBNames.TEST_ME.name());
            if (connection != null) {
                String query = QueryUtils.Query.CREATE_ROOM.getQuery();
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, room.getName());
                pstmt.setString(2, toAddres(room.getAddress()));

                int executeUpdate = pstmt.executeUpdate();
                created = executeUpdate == 1 ? true : false;

            } else {
                AppUtils.raiseTrap(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppUtils.raiseException(null);
        } finally {
            RMDBUtil.releaseResources(connection, pstmt, null, rs);
        }

        return created;
    }

    @Override
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection con = null;

        try {
            con = dataSource.getConnection(AppEnums.DBNames.TEST_ME.name());
            if (con != null) {
                String query = QueryUtils.Query.SELECT_ROOMS.getQuery();
                pstmt = con.prepareStatement(query);

                rs = pstmt.executeQuery();
                Room room = null;
                Address ads = null;
                while (rs.next()) {
                    room = new Room();
                    room.setId(rs.getInt("id"));
                    room.setName(rs.getString("name"));
                    ads = getAddress(rs.getString("address"));
                    room.setAddress(ads);
                    rooms.add(room);
                }

            } else {
                AppUtils.raiseTrap(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppUtils.raiseException(null);
        } finally {
            RMDBUtil.releaseResources(con, pstmt, null, rs);
        }

        return rooms;
    }

    @Override
    public boolean create(User user) {
        boolean created = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            con = dataSource.getConnection(AppEnums.DBNames.TEST_ME.getName());

            if (con != null) {
                String query = QueryUtils.Query.CREATE_USER.getQuery();
                pstmt = con.prepareStatement(query);

                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getUserid());
                pstmt.setString(3, user.getPassword());
                pstmt.setString(4, user.getMobileNo());
                String address = null;
                address = toAddres(user.getAddress());
                pstmt.setString(5, address);

                int executeUpdate = pstmt.executeUpdate();
                created = executeUpdate == 1 ? true : false;
            } else {
                AppUtils.raiseTrap(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            AppUtils.raiseException(null);
        } finally {
            RMDBUtil.releaseResources(con, pstmt, null, null);
        }
        return created;
    }

    
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users = getUsersQuery(QueryUtils.Query.SELECT_USERS.getQuery());
        return users;
    }
    
    @Override
    public List<User> getRoomUsers(int roomId) {
        List<User> users = new ArrayList<>();
        String query = QueryUtils.Query.SELECT_ROOM_USERS.getQuery();
        query = query.replaceAll("!roomid!", roomId+"");
        users = getUsersQuery(query);
        return users;
    }
    
    
    

    @Override
    public boolean createMapping(UserRoomMapping userRoomMapping) {
        boolean mappingCreated = false;

        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = dataSource.getConnection(AppEnums.DBNames.TEST_ME.getName());
            
            if (conn != null) {
                String query = QueryUtils.Query.CREATE_USER_ROOM_MAPPING.getQuery();
                
                pstmt = conn.prepareCall(query);
                pstmt.setInt(1, userRoomMapping.getUserId());
                pstmt.setInt(2, userRoomMapping.getRoomId());
                pstmt.setInt(2, userRoomMapping.getRoleid());
                pstmt.setInt(3, userRoomMapping.getState().getId());
                
                int executeUpdate = pstmt.executeUpdate();
                mappingCreated = executeUpdate == 1 ? true : false;
            } else {
                AppUtils.raiseException(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppUtils.raiseException(null);
        } finally {
            RMDBUtil.releaseResources(conn, pstmt, null, null);
        }
        return mappingCreated;
    }

    
    
    
    public List<User> getUsersQuery(String query) {
        List<User> users = new ArrayList<>();

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {

            con = dataSource.getConnection(AppEnums.DBNames.TEST_ME.getName());

            if (con != null) {                
                pstmt = con.prepareStatement(query);

                rs = pstmt.executeQuery();
                User user = null;
                Address address = null;
                while (rs.next()) {
                    user = new User();
                    address = getAddress(rs.getString("address"));
                    user.setAddress(address);
                    user.setCreatedDate(rs.getString("created_date"));
                    user.setUpdatedDate(rs.getString("updated_date"));

                    user.setId(rs.getInt("id"));
                    user.setMobileNo(rs.getString("mobileno"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setUserid(rs.getString("userid"));
                    users.add(user);
                }
            } else {
                AppUtils.raiseException(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppUtils.raiseException(null);
        } finally {
            RMDBUtil.releaseResources(con, pstmt, null, rs);
        }

        return users;
    }
    private Address getAddress(String address) {
        Address ads = null;
        try {
            ads = RMGsonUtils.fromJson(address, Address.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return ads;
    }

    private String toAddres(Address address) {
        return RMGsonUtils.toJson(address, Address.class);
    }
}
