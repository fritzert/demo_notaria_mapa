package com.frodas.notaria.mapa.persistence.repository;

import com.frodas.notaria.mapa.persistence.entity.NotariaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotariaRepository extends MongoRepository<NotariaEntity, String> {

    @Query(value = "{'habilitado' : ?0 , 'distritonotaid':  ?1}", count = true)
    Integer countByHabilitadoAndDistritoId(Boolean habilitado, String codigo);

    @Query("{'habilitado' : ?0 , 'distritonotaid':  ?1}")
    List<NotariaEntity> findAllByHabilitadoAndDistritoId(Boolean habilitado, String codigo);

}