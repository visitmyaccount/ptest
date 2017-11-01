/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rm.dto;

/**
 *
 * @author sivakrishna.k
 */

@lombok.Getter
@lombok.Setter
@lombok.EqualsAndHashCode
@lombok.ToString(exclude = "address")
public class User {
    private int id;
    private String name;
    private String userid;
    private String password;
    private String mobileNo;
    private Address address;
    private String createdDate;
    private String updatedDate;
    
}
