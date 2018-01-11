/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author anis
 */
public class Connecte {

    public DriverManagerDataSource connecte(){
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/framework");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
    
    
}
