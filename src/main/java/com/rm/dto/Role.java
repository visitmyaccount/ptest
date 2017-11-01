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
public class Role {
    private int id;
    private String name;
    private String desc;
    private int type;
    private String createdDate;
    private String updatedDate;
    private int createdBy;
}
