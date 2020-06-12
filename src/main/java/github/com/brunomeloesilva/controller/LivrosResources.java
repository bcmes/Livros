package github.com.brunomeloesilva.controller;

import java.net.URI;
import java.util.List;

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

import github.com.brunomeloesilva.domain.Comentario;
import github.com.brunomeloesilva.domain.Livro;
import github.com.brunomeloesilva.services.LivrosService;

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
        Livro livro = livrosService.buscar(livroId);;
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @DeleteMapping("/{livroId}")
    public ResponseEntity<Void> deletar(@PathVariable("livroId") Livro livro){
        livrosService.deletar(livro);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<Void> atualizar(@PathVariable Long livroId, @RequestBody Livro livro){
        livro.setId(livroId);
        livrosService.atualizar(livro);
        return ResponseEntity.noContent().build();
    }

    /** AREA PARA COMENTARIOS **/
    @PostMapping("/{livroId}/comentarios")
    public ResponseEntity<Void> addComentario(@PathVariable Long livroId, @RequestBody Comentario comentario){
        livrosService.salvarComentario(livroId, comentario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{livroId}/comentarios")
    public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable Long livroId){
        List<Comentario> comentarios = livrosService.listarComentarios(livroId);
        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }
}
