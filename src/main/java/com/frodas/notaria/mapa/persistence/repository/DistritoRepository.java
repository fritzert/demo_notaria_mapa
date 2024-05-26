package com.frodas.notaria.mapa.persistence.repository;

import com.frodas.notaria.mapa.persistence.entity.DistritoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DistritoRepository extends MongoRepository<DistritoEntity, String> {

    @Query("{'habilitado' : ?0 }")
    List<DistritoEntity> findAllByHabilitado(Boolean habilitado);

    @Query("{'habilitado' : ?0 , 'codigo':  ?1}")
    Optional<DistritoEntity> findByHabilitadoAndCodigo(Boolean habilitado, String codigo);

}


