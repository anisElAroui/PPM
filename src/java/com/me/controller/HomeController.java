/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.model.Connecte;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anis
 */
public class HomeController {
    
    private JdbcTemplate jdbcTempalte ;

    public HomeController() {
        Connecte con = new Connecte();
        this.jdbcTempalte = new JdbcTemplate(con.connecte());
    }
    
    
    
    @RequestMapping("home.htm")
    public ModelAndView home(){
        
        ModelAndView mav = new ModelAndView();
        
        String sql = "select * from colis";
        List data = this.jdbcTempalte.queryForList(sql);
        mav.addObject("data", data);
        
        String sql2 = "select * from c";
        List data2 = this.jdbcTempalte.queryForList(sql2);
        mav.addObject("data2", data2);
        
        mav.setViewName("home");
        
        return mav ;
        
    }
    
}
