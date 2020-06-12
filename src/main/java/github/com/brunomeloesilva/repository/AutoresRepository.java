package github.com.brunomeloesilva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{
    
}