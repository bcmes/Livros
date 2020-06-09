package github.com.brunomeloesilva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.brunomeloesilva.repository.LivrosRepository;
import github.com.brunomeloesilva.services.exceptions.LivroNaoEncontradoException;
import github.com.brunomeloesilva.domain.Livro;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livro> listar() {
        return livrosRepository.findAll();
    }

    public Livro buscar(Long livroId) {
        Optional<Livro> livro = livrosRepository.findById(livroId);
        if(livro.isEmpty()){
            throw new LivroNaoEncontradoException("O livro não existe em nossa base de dados.");
        }
        return livro.get();
    }

    public Livro salvar(Livro livro) {
        livro.setId(null);
        return livrosRepository.save(livro);
        
    }

    public void deletar(Livro livro){
        try {
            livrosRepository.delete(livro);
        } catch (Exception e) {
            throw new LivroNaoEncontradoException("O livro não existe em nossa base de dados.");
        }
    }

    public Livro atualizar(Livro livro){
        verificarExistencia(livro);
        return livrosRepository.save(livro);
    }

    private void verificarExistencia(Livro livro){
        buscar(livro.getId());
    }
    
}