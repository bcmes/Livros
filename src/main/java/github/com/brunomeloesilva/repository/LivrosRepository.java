package github.com.brunomeloesilva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{
    
}