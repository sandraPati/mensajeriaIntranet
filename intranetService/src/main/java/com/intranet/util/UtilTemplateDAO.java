/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.util;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class UtilTemplateDAO extends NamedParameterJdbcDaoSupport{
    @Autowired
    public void initConfiguracion(DataSource dataSource){
        this.setDataSource(dataSource);
    }
}
