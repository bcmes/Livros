package github.com.brunomeloesilva.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.brunomeloesilva.domain.Livro;

@RestController
public class LivrosResources {
    
    @GetMapping("/livros")
    public List<Livro> listar() {

        Livro l1 = new Livro("Rest aplicado");
        Livro l2 = new Livro("Git-passo-a-passo");
        Livro[] livros = {l1, l2};
        
        return Arrays.asList(livros);
    }
}