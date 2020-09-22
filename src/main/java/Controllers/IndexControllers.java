package Controllers;

import models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexControllers {

    @GetMapping({"/index","/","/home"})
    public String index(Model model){
        model.addAttribute("titulo","Hola Spring ");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario= new Usuario();
         usuario.setNombre("Rusbel");
         usuario.setApellido("leon");
         model.addAttribute("usuario",usuario);
         model.addAttribute("titulo","perfil del,usuario".concat(usuario.getNombre()));
         return "pertfil";
    }
}
