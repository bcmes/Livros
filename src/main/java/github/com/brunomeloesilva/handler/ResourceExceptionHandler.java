package github.com.brunomeloesilva.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import github.com.brunomeloesilva.domain.DetalhesErro;
import github.com.brunomeloesilva.services.exceptions.AutorExistenteException;
import github.com.brunomeloesilva.services.exceptions.AutorNaoEncontradoException;
import github.com.brunomeloesilva.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> hanbleLivroNaoEncontradoExcention (LivroNaoEncontradoException e, HttpServletRequest r){

        DetalhesErro detalhesErro = new DetalhesErro(404l, "O Livro não existe no banco de dados.", "http://erros.livrosAPI.com/livro/404", System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
    }
    
    @ExceptionHandler(AutorExistenteException.class)
    public ResponseEntity<DetalhesErro> hanbleAutorExistenteException(AutorExistenteException e, HttpServletRequest r){

        DetalhesErro detalhesErro = new DetalhesErro(409l, "O Autor já existe no banco de dados.", "http://erros.livrosAPI.com/autor/409", System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(detalhesErro);
    }

    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> hanbleAutorNaoEncontradoException(AutorNaoEncontradoException e, HttpServletRequest r){

        DetalhesErro detalhesErro = new DetalhesErro(404l, "O Autor não existe no banco de dados.", "http://erros.livrosAPI.com/autor/404", System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
    }
}
