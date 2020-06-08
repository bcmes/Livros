package github.com.brunomeloesilva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.brunomeloesilva.domain.Livro;
import github.com.brunomeloesilva.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResources {

    @Autowired
    private LivrosRepository livrosRepository;
    
    @GetMapping
    public List<Livro> listar() {
        return livrosRepository.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Livro livro){
        livrosRepository.save(livro);
    }
}