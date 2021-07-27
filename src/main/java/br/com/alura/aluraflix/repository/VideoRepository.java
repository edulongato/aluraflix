package br.com.alura.aluraflix.repository;

import br.com.alura.aluraflix.entity.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Videos, Integer> {

    Optional<Videos> findById(Integer id);
}
