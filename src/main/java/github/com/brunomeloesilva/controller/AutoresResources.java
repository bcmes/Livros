package github.com.brunomeloesilva.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import github.com.brunomeloesilva.domain.Autor;
import github.com.brunomeloesilva.services.AutoresService;

@RestController
@RequestMapping("/autores")
public class AutoresResources {
    @Autowired
    private AutoresService autoresService;

    @GetMapping
    public ResponseEntity<List<Autor>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(autoresService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Autor autor){
        autor = autoresService.salvar(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{livroId}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{idAutor}")
    public ResponseEntity<Autor> buscar(@PathVariable Long idAutor){
        return ResponseEntity.status(HttpStatus.OK).body(autoresService.buscar(idAutor));
    } 
}