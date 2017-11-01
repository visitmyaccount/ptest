/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.service;

import com.rm.dto.Address;
import com.rm.dto.User;
import com.rm.util.AppEnums.ROLE;
import com.rm.util.AppEnums.UserRoomMappinStatus;
import com.rm.util.RMRandomString;
import java.util.stream.IntStream;

/**
 *
 * @author sivakrishna.k
 */
public class TstClass {

    static RoomService roomService = new RoomService();

    public static void main(String[] args) {
//           createRooms();
//           printRooms();
//        createUsers();
//        printUsers();
//        createMapping();
        getRoomUsers();
    }

    public static void getRoomUsers() {
        IntStream.range(1, 4).forEach(index -> roomService.getRoomMemebers(index));

    }

    public static void createMapping() {
        roomService.mappUserToRoom(1, 2, ROLE.ROOM_MEMBER, UserRoomMappinStatus.ACTIVE);
        roomService.mappUserToRoom(2, 1, ROLE.ROOM_MEMBER, UserRoomMappinStatus.ACTIVE);
        roomService.mappUserToRoom(3, 1, ROLE.ROOM_MEMBER, UserRoomMappinStatus.ACTIVE);
        roomService.mappUserToRoom(4, 1, ROLE.ROOM_MEMBER, UserRoomMappinStatus.ACTIVE);
        roomService.mappUserToRoom(1, 2, ROLE.ROOM_MEMBER, UserRoomMappinStatus.ACTIVE);
        roomService.mappUserToRoom(2, 2, ROLE.ROOM_MEMBER, UserRoomMappinStatus.ACTIVE);
    }

    public static void printUsers() {
        roomService.getAllUsers();
    }

    public static void createUsers() {
        Address address = getAddress();
        RMRandomString session = new RMRandomString();
        IntStream.range(0, 5).forEach(index -> {
            User user = new User();
            user.setAddress(address);
            user.setMobileNo("984837715" + index);
            user.setName("username" + index);
            user.setPassword(session.nextString());
            user.setUserid(user.getName());

            roomService.createUser(user);
        });

    }

    public static void printRooms() {

        roomService.getAllRooms();;
    }

    public static void createRooms() {
        Address address = getAddress();

        IntStream.range(0, 5).forEach(index -> {
            roomService.createRoom("room" + index, address);
        });
    }

    private static Address getAddress() {
        Address address = new Address();
        address.setArea("jayanagar");
        address.setCity("KPHB");
        address.setDoorNo("2-22-219/B");
        address.setPin(500072);
        address.setStreet("OOP HDFC road");
        return address;
    }
}
