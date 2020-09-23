package Controllers;

import models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexControllers {

    @Value("{texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("{texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("{texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework con Model");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Rusbel");
        usuario.setApellido("leon");
        usuario.setEmail("leon12456@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "perfil del,usuario".concat(usuario.getNombre()));
        return "pertfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("titulo", "listado de usuario");g


        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList((new Usuario("Rusbel", "Leon", "leon12456@gmail.com")),
                new Usuario("Luis", "Galvez", "galvez@gmail.com"),
                new Usuario("Alberto", "Gutierrez", "alberto12456@gmail.com"),
                new Usuario("Tornado", "Roe", "Tornado@gmail.com"));
        return usuarios;

    }
}
