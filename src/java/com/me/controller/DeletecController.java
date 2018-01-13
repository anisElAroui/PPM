/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.model.Connecte;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anis
 */
public class DeletecController {
     private JdbcTemplate jdbcTemplate;
    public DeletecController()
    {
        Connecte con=new Connecte();
        this.jdbcTemplate=new JdbcTemplate(con.connecte() );
    }
    
    @RequestMapping("deletec.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "delete from c "
                + "where "
                + "id=? ",
        id);
        return new ModelAndView("redirect:/home.htm");
    }  
}
