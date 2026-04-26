package com.example.logistica.service;

import com.example.logistica.model.Envio;
import com.example.logistica.repository.EnvioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository repository;

    public List<Envio> findAll(){
        return repository.findAll();
    }

    public Optional<Envio> findById(Long id){
        return repository.findById(id);
    }

    //Obtener todos los envíos hacia un destino específico.
    public List<Envio> findByDestino(String destino){
        return repository.findByDestino(destino);
    }

    //Obtener envíos cuyo peso sea mayor a un valor dado.
    public List<Envio> findByPesoLessThan(Integer peso){
        return repository.findByPesoGreaterThan(peso);
    }

    //Obtener envíos cuyo destino contenga una cadena de texto.
    public List<Envio> findByDestinoContaining(String destino){
        return repository.findByDestinoContaining(destino);
    }
    //Obtener todos los envíos que han sido entregados.
    public List<Envio> findByEntregadoTrue(Boolean entregado){
        return repository.findByEntregadoTrue(entregado);
    }

    //Obtener envíos entregados de un tipo específico.
    public List<Envio> findByEntregadoTrueAndfindbyTipo(String tipo){
        return repository.findByEntregadoTrueAndTipo(tipo);
    }

    //Obtener envíos de un tipo determinado cuyo peso sea mayor a un valor dado.
    public List<Envio> findByTipoAndPesoGreaterThan(String tipo,Integer peso){
        return repository.findByTipoAndPesoGreaterThan(tipo,peso);
    }


    //Obtener envíos de un destino específico ordenados por peso de forma descendente.
    public List<Envio> findByDestinoOrderByPesoDesc(String d){
        return repository.findByDestinoOrderByPesoDesc(d);
    }

    //Obtener el envío de mayor peso registrado.
    public Envio findFirstByOrderByPesoDesc( ){
        return repository.findFirstByOrderByPesoDesc();
    }


    //Buscar envíos por destino sin considerar diferencias entre mayúsculas y minúsculas.
    public  List<Envio> findByDestinoIgnoreCase(String des){
        return repository.findByDestinoIgnoreCase(des);
    }

    //Obtener envíos cuyo identificador se encuentre dentro de una lista dada.
    public List<Envio> findByIdIn(List<Long> ids){
        return repository.findByIdIn(ids);
    }

    //Desafio:Obtener los 3 envíos no entregados más livianos de un tipo específico.
    public List<Envio> findTop3ByEntregadoFalseAndTipoOrderByPesoAsc(String t){
        return repository.findTop3ByEntregadoFalseAndTipoOrderByPesoAsc(t);
    }


}
