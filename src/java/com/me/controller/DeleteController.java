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
public class DeleteController {
    private JdbcTemplate jdbcTemplate;
    public DeleteController()
    {
        Connecte con=new Connecte();
        this.jdbcTemplate=new JdbcTemplate(con.connecte() );
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "delete from colis "
                + "where "
                + "id=? ",
        id);
        return new ModelAndView("redirect:/home.htm");
    }
}
