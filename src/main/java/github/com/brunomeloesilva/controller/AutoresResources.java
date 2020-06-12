package github.com.brunomeloesilva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}