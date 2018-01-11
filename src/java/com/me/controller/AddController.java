/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.model.Colis;
import com.me.model.Connecte;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anis
 */

@Controller
@RequestMapping("add.htm")
public class AddController {
    private JdbcTemplate jdbcTemplate;
    
    public AddController() 
    {
        Connecte con=new Connecte();
        this.jdbcTemplate=new JdbcTemplate(con.connecte() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("colis",new Colis());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("colis") Colis c,
                BindingResult result,
                SessionStatus status
        )
    {
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("c",new Colis());
            return mav;
        }else
        {
        this.jdbcTemplate.update
        (
        "insert into colis (nom,quantite,lien ) values (?,?,?)",
         c.getNom(),c.getQuantite(),c.getLien()
        );
         return new ModelAndView("redirect:/home.htm");
        }
       
    }
}
