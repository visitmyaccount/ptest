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
public class ExceptionInfo {
    private int componetId;
    private String component;
    private String ip;
    private String data;
    private String desc;
    private int state;
}
