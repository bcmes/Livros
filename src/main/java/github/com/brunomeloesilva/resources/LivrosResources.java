package github.com.brunomeloesilva.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosResources {
    
    @GetMapping("/livros")
    public String listar() {
        return "Olá mundo !";
    }
}