package com.example.logistica.repository;

import com.example.logistica.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio , Long> {

    //Obtener todos los envíos hacia un destino específico.
    List<Envio> findByDestino(String destino);

    //Obtener envíos cuyo peso sea mayor a un valor dado.
    List<Envio> findByPesoGreaterThan(Integer peso);

    //Obtener envíos cuyo destino contenga una cadena de texto.
    List<Envio> findByDestinoContaining(String destino);

    //Obtener todos los envíos que han sido entregados.
    List<Envio> findByEntregadoTrue(Boolean entregado);

    //Obtener envíos entregados de un tipo específico.
    List<Envio> findByEntregadoTrueAndTipo(String tipo);

    //Obtener envíos de un tipo determinado cuyo peso sea mayor a un valor dado.
    List<Envio> findByTipoAndPesoGreaterThan(String tipo,Integer peso);

    //Obtener envíos de un destino específico ordenados por peso de forma descendente.
    List<Envio> findByDestinoOrderByPesoDesc(String d);

    //Obtener el envío de mayor peso registrado.
    Envio findFirstByOrderByPesoDesc();

    //Buscar envíos por destino sin considerar diferencias entre mayúsculas y minúsculas.
    List<Envio> findByDestinoIgnoreCase(String des);
   //Obtener envíos cuyo identificador se encuentre dentro de una lista dada.
    List<Envio> findByIdIn(List<Long> ids);

//Desafio:Obtener los 3 envíos no entregados más livianos de un tipo específico.
    List<Envio> findTop3ByEntregadoFalseAndTipoOrderByPesoAsc(String t);

}
