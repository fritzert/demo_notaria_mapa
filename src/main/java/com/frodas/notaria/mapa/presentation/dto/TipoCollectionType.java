package com.frodas.notaria.mapa.presentation.dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum TipoCollectionType {

    FEATURE_COLLECTION("FeatureCollection"),
    FEATURE("Feature"),
    POINT("Point");

    private final Object objeto;

    TipoCollectionType(Object objeto) {
        this.objeto = objeto;
    }

    public String getString() {
        try {
            if (this.objeto instanceof Integer) {
                return String.valueOf(this.objeto);
            } else if (this.objeto instanceof Long) {
                return ((Long) this.objeto).toString();
            } else {
                return (String) this.objeto;
            }
        } catch (Exception e) {
            log.error("No se podido convertir el objeto en alguna variable primitiva. : {}", e.getMessage());
            return "";
        }
    }

}
