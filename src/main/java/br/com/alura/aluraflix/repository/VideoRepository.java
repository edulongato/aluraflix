package br.com.alura.aluraflix.repository;

import br.com.alura.aluraflix.orm.Videos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
//@NoRepositoryBean
public interface VideoRepository extends CrudRepository<Videos, Integer> {
}
