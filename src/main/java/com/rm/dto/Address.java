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

@lombok.Data
public class Address {
    private String doorNo;
    private String street;
    private String area;
    private String city;
    private int pin; 
}
