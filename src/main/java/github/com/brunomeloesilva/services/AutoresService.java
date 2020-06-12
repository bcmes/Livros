package github.com.brunomeloesilva.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.brunomeloesilva.domain.Autor;
import github.com.brunomeloesilva.repository.AutoresRepository;

@Service
public class AutoresService {
    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }
}