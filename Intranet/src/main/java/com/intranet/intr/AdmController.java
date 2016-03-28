/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intranet.intr;

import com.intranet.beans.empleados;
import com.intranet.beans.tipo_contrato;
import com.intranet.service.EmpleadoService;
import com.intranet.service.TipoContratoService;
import com.intranet.service.ValidaInterfacesRoles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adm/*")
public class AdmController {
    @Autowired
    private ValidaInterfacesRoles validaInterfacesRoles;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private TipoContratoService tipoContratoService;
            
    
}
