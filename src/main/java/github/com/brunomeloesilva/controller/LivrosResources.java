package github.com.brunomeloesilva.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import github.com.brunomeloesilva.services.LivrosService;
import github.com.brunomeloesilva.services.exceptions.LivroNaoEncontradoException;

@RestController
@RequestMapping("/livros")
public class LivrosResources {

    @Autowired
    private LivrosService livrosService;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
        livro = livrosService.salvar(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{livroId}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{livroId}")
    public ResponseEntity<Livro> buscar(@PathVariable Long livroId) {
        Livro livro = null;
        try {
            livro = livrosService.buscar(livroId);
        } catch (LivroNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @DeleteMapping("/{livroId}")
    public ResponseEntity<Void> deletar(@PathVariable("livroId") Livro livro){
        try {
            livrosService.deletar(livro);
        } catch (LivroNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<Void> atualizar(@PathVariable Long livroId, @RequestBody Livro livro){
        livro.setId(livroId);
        try {
            livrosService.atualizar(livro);
        } catch (LivroNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.noContent().build();
    }
}
