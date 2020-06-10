package github.com.brunomeloesilva.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import github.com.brunomeloesilva.domain.DetalhesErro;
import github.com.brunomeloesilva.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> hanbleLivroNaoEncontradoExcention (LivroNaoEncontradoException e, HttpServletRequest r){

        DetalhesErro detalhesErro = new DetalhesErro(404l, "O Livro não existe no banco de dados.", "http://erros.socialbooks.com/404", System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
    }    
}
