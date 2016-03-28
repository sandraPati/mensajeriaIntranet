/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.service;

import com.intranet.beans.Roles;
import com.intranet.dao.RolesDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rolesService")
public class RolesService {
    @Autowired
    private RolesDAO rolesDAO;

    public List<Roles> getList(){
        List<Roles> list = rolesDAO.getList();
        
        return list;
    }
    
    public Roles getRolesporId(int id){
        Roles list = rolesDAO.getRolesporId(id);
        
        return list;
    }
    public Roles getRolesUser(String user_id){
        Roles list = rolesDAO.getRolesUser(user_id);
        
        return list;
    }
    
    public Roles getUserById(Integer id){
        return rolesDAO.getUserById(id);
    }
}
