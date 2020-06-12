package github.com.brunomeloesilva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.brunomeloesilva.domain.Autor;
import github.com.brunomeloesilva.repository.AutoresRepository;
import github.com.brunomeloesilva.services.exceptions.AutorExistenteException;
import github.com.brunomeloesilva.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

    public Autor salvar(Autor autor){
        if(autor.getId() != null){
            Optional<Autor> autorAux = autoresRepository.findById(autor.getId());
            if(autorAux.get() != null){
                throw new AutorExistenteException("Autor já existe no banco de dados");
            }
        }
        return autoresRepository.save(autor);
    }

    public Autor buscar(Long idAutor){
        Optional<Autor> autor = autoresRepository.findById(idAutor);
        if(autor.get() == null){
            throw new AutorNaoEncontradoException("Autor não encontado na base de dados");
        }
        return autor.get();
    }
}