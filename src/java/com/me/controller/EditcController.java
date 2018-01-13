/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.model.C;
import com.me.model.Connecte;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
@RequestMapping("editc.htm")
public class EditcController 
{
    private JdbcTemplate jdbcTemplate;
     
    
    public EditcController() 
    {
        Connecte con=new Connecte();
        this.jdbcTemplate=new JdbcTemplate(con.connecte() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        C data=this.selectC(id);
        mav.setViewName("editc");
        mav.addObject("c",new C(id,data.getPoids(),data.getNom(),data.getDestination(),data.getMp()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("c") C c,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id=Integer.parseInt(request.getParameter("id"));
            C data=this.selectC(id);
            mav.setViewName("editc");
        mav.addObject("c",new C(id,data.getPoids(),data.getNom(),data.getDestination(),data.getMp()));
            return mav;
        }else
        {
            int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update c "
                + "set nom=?,"
                + " destination=?,"
                + "poids=?, "
                + "mp=? "
                + "where "
                + "id=? ",
        c.getNom(),c.getDestination(),c.getPoids(),c.getMp(),id);
         return new ModelAndView("redirect:/home.htm");
        }
       
    }
    public C selectC(int id) 
    {
        final C c = new C();
        String quer = "SELECT * FROM c WHERE id='" + id+"'";
        return (C) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<C>() 
            {
                public C extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        c.setNom(rs.getString("nom"));
                        c.setDestination(rs.getString("destination"));
                        c.setPoids(rs.getInt("poids"));
                        c.setMp(rs.getString("mp"));
                    }
                    return c;
                }


            }
        );
    }
}
