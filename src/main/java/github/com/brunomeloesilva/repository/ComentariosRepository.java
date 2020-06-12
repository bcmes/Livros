package github.com.brunomeloesilva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{
    
}