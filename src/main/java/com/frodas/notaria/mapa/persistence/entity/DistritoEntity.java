package com.frodas.notaria.mapa.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "distritos")
public class DistritoEntity {

    @Id
    private String id;

    @Field(name = "codigo")
    private String codigo;

    @Field(name = "nombre")
    private String nombre;

    @Field(name = "coordlatitud")
    private Float coordLatitud;

    @Field(name = "coordlongitud")
    private Float coordLongitud;

    @Field(name = "cantidad")
    private Integer cantidad;

    @Field(name = "habilitado")
    private Boolean habilitado;

    @Field(name = "urlImg")
    private String urlImg;

}
