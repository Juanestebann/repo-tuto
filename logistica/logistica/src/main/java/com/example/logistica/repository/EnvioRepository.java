package com.example.logistica.repository;

import com.example.logistica.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

    //Obtener todos los envíos hacia un destino específico.
    List<Envio> findByDestino(String destino);

    //Obtener envíos cuyo peso sea mayor a un valor dado.
    List<Envio> findByPesoGreaterThan(Integer pesoMinimo);

    //Obtener envíos cuyo destino contenga una cadena de texto.
    List<Envio> findByDestinoContaining(String destinoContiene);

    //Obtener todos los envíos que han sido entregados.
    List<Envio> findByEntregadoTrue();

    //Obtener envíos entregados de un tipo específico.
    List<Envio> findByDestinoAndTipo(String destinoComb, String TipoComb);

    //Obtener envíos de un tipo determinado cuyo peso sea mayor a un valor dado.
    List<Envio> findByTipoContainingAndPesoGreaterThan(String tipoContiene, Integer pesoMayorQue);

    //Obtener envíos de un destino específico ordenados por peso de forma descendente.
    List<Envio> findByDestinoOrderByPesoDesc(String destinoOrdenPesoDesc);

    /*
    Obtener el envío de mayor peso registrado.
    findFirstByOrderByPesoDesc() --> Debo combinar findFirstBy --> OrderByPesoDesc().
    No especifico el "Parametro" Si no que el orden en desc.
    */
    Envio findFirstByOrderByPesoDesc();

    //Búsqueda sin distinción de mayúsculas/minúsculas

    List<Envio> findByDestinoIgnoreCase(String destinoIgCs);

    //Obtener envíos cuyo identificador se encuentre dentro de una lista dada.

    List<Envio> findByIdBetween(Long min, Long max);



}
