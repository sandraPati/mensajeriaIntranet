/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.dao;

import com.intranet.beans.Roles;
import java.util.List;


public interface RolesDAO {
    public List<Roles> getList();
    public Roles getRolesporId(int id);
    public Roles getRolesUser(String user_id);
    public Roles getUserById(int id);
}
