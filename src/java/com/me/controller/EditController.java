/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.model.Colis;
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
@RequestMapping("edit.htm")
public class EditController 
{
    private JdbcTemplate jdbcTemplate;
     
    
    public EditController() 
    {
        Connecte con=new Connecte();
        this.jdbcTemplate=new JdbcTemplate(con.connecte() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        Colis data=this.selectColis(id);
        mav.setViewName("edit");
        mav.addObject("colis",new Colis(id,data.getNom(),data.getLien(),data.getQuantite()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("colis") Colis c,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        if(result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            int id=Integer.parseInt(request.getParameter("id"));
            Colis data=this.selectColis(id);
            mav.setViewName("edit");
            mav.addObject("Colis",new Colis(id,data.getNom(),data.getLien(),data.getQuantite()));
            return mav;
        }else
        {
            int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "update colis "
                + "set nom=?,"
                + " quantite=?,"
                + "lien=? "
                + "where "
                + "id=? ",
        c.getNom(),c.getQuantite(),c.getLien(),id);
         return new ModelAndView("redirect:/home.htm");
        }
       
    }
    public Colis selectColis(int id) 
    {
        final Colis colis = new Colis();
        String quer = "SELECT * FROM colis WHERE id='" + id+"'";
        return (Colis) jdbcTemplate.query
        (
                quer, new ResultSetExtractor<Colis>() 
            {
                public Colis extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        colis.setNom(rs.getString("nom"));
                        colis.setQuantite(rs.getInt("quantite"));
                        colis.setLien(rs.getString("lien"));
                    }
                    return colis;
                }


            }
        );
    }
}
