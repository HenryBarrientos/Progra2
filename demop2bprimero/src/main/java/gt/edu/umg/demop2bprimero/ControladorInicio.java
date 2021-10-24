/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demop2bprimero;

import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author henryflores
 */
@Controller
public class ControladorInicio {
    @GetMapping("/")
    public String inicio(Model model){
        var persona= new Personas();
        persona.setNobre("Henry");  
        persona.setEnero("8");
        persona.setFebrero("10");
        persona.setMarzo("9");
        persona.setTotales("27");
        persona.setPromedio("9");
        
        
        
        var persona2= new Personas();
        persona2.setNobre("Daiel");  
        persona2.setEnero("10");
        persona2.setFebrero("10");
        persona2.setMarzo("10");
        persona2.setTotales("30");
        persona2.setPromedio("10");
        
        
        
        var persona3= new Personas();
        persona3.setNobre("Leonel");  
        persona3.setEnero("8");
        persona3.setFebrero("8");
        persona3.setMarzo("8");
        persona3.setTotales("24");
        persona3.setPromedio("8");
        
        var personas=Arrays.asList(persona,persona2,persona3);
        
        
        model.addAttribute("persona", personas);
         
       
        return "index";
    }
}
        