package github.com.brunomeloesilva.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    //Via Accept posso solicitar dois formatos diferentes { application/json, application/xml }. 
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
    public ResponseEntity<List<Autor>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(autoresService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor){
        autor = autoresService.salvar(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{livroId}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{idAutor}")
    public ResponseEntity<Autor> buscar(@PathVariable Long idAutor){
        return ResponseEntity.status(HttpStatus.OK).body(autoresService.buscar(idAutor));
    } 
}