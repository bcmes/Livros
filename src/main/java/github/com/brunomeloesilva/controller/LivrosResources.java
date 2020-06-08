package github.com.brunomeloesilva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.brunomeloesilva.domain.Livro;
import github.com.brunomeloesilva.repository.LivrosRepository;

@RestController
public class LivrosResources {

    @Autowired
    private LivrosRepository livrosRepository;
    
    @GetMapping("/livros")
    public List<Livro> listar() {
        return livrosRepository.findAll();
    }
}