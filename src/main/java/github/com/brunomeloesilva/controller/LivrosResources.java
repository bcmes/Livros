package github.com.brunomeloesilva.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import github.com.brunomeloesilva.domain.Livro;
import github.com.brunomeloesilva.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResources {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
        livro = livrosRepository.save(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{livroId}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{livroId}")
    public ResponseEntity<?> buscar(@PathVariable Long livroId) {
        Optional<Livro> livro = livrosRepository.findById(livroId);
        if(livro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @DeleteMapping("/{livroId}")
    public ResponseEntity<Void> deletar(@PathVariable("livroId") Livro livro){
        try {
            livrosRepository.delete(livro);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<Void> atualizar(@PathVariable("livroId") Long livroId, @RequestBody Livro livro){
        livro.setId(livroId);
        livrosRepository.save(livro);
        return ResponseEntity.noContent().build();
    }
}
