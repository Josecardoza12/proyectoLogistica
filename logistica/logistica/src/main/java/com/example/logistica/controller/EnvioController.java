package com.example.logistica.controller;

import com.example.logistica.model.Envio;
import com.example.logistica.service.EnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/envios")
public class EnvioController {

    private final EnvioService service;

    @GetMapping
    public List<Envio> findAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Obtener todos los envíos hacia un destino específico.
    //http://localhost:8080/api/v1/envios?destino=Santiago
    @GetMapping(params = "destino")
    public List<Envio> findByDestino(@RequestParam String destino) {
        return service.findByDestino(destino);
    }

    //Obtener envíos cuyo peso sea mayor a un valor dado.
    // http://localhost:8080/api/v1/envios?peso=11
    @GetMapping(params = "peso")
    public List<Envio> findByPesoGreaterThan(Integer peso) {
        return service.findByPesoLessThan(peso);
    }

    //Obtener envíos cuyo destino contenga una cadena de texto.
    @GetMapping(params = "viajes")
    public List<Envio> findByDestinoContaining(@RequestParam String viajes) {
        return service.findByDestinoContaining(viajes);
    }

    //Obtener todos los envíos que han sido entregados.
    @GetMapping(params = "entregado")
    public List<Envio> findByEntregadoTrue(@RequestParam Boolean entregado) {
        return service.findByEntregadoTrue(entregado);
    }

    //Obtener envíos entregados de un tipo específico.
    @GetMapping(params = "tipo" )
    public List<Envio> findByEntregadoTrueAndfindbyTipo(@RequestParam String tipo){
        return service.findByEntregadoTrueAndfindbyTipo(tipo);
    }

    //Obtener envíos de un tipo determinado cuyo peso sea mayor a un valor dado.
    @GetMapping( params = {"tipos", "peso"}  )
    public List<Envio> findByTipoAndPesoGreaterThan(@RequestParam String tipos, @RequestParam Integer peso) {
        return service.findByTipoAndPesoGreaterThan(tipos, peso);
    }

    //Obtener envíos de un destino específico ordenados por peso de forma descendente.
    @GetMapping( params = "destinoDesc"  )
    public List<Envio> findByDestinoOrderByPesoDesc(@RequestParam String destinoDesc){
        return service.findByDestinoOrderByPesoDesc(destinoDesc);
    }


    //Obtener el envío de mayor peso registrado.
    @GetMapping("/mayorPeso")
    public Envio findFirstByOrderByPesoDesc(){
        return service.findFirstByOrderByPesoDesc();
    }

    //Buscar envíos por destino sin considerar diferencias entre mayúsculas y minúsculas.
    @GetMapping( params = "desIgnoreCase"  )
    public  List<Envio> findByDestinoIgnoreCase(@RequestParam String desIgnoreCase){
        return service.findByDestinoIgnoreCase(desIgnoreCase);
    }


    //Obtener envíos cuyo identificador se encuentre dentro de una lista dada.
    @GetMapping( params = "ids"  )
    public List<Envio> findByIdIn( @RequestParam List<Long> ids){
        return service.findByIdIn(ids);
    }




    //Desafio:Obtener los 3 envíos no entregados más livianos de un tipo específico.
    @GetMapping( params = "t"  )
    public List<Envio> findTop3ByEntregadoFalseAndTipoOrderByPesoAsc(@RequestParam String t){
        return service.findTop3ByEntregadoFalseAndTipoOrderByPesoAsc(t);
    }

}
