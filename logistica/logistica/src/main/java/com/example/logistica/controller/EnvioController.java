package com.example.logistica.controller;

import com.example.logistica.model.Envio;
import com.example.logistica.service.EnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/envios")
public class EnvioController {
    private final EnvioService service;
    @GetMapping
    public List<Envio> findAll(){
        return service.findAll();
    }

    //http://localhost:9090/api/v1/envios?id=2
    @GetMapping(params="id")
    public ResponseEntity<Envio> findById(@RequestParam Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //http://localhost:9090/api/v1/envios?destino=Valparaiso
    @GetMapping(params ="destino")
    public List<Envio> findByDestino(@RequestParam String destino){
        return service.findByDestino(destino);
    }
    //http://localhost:9090/api/v1/envios?pesoMinimo=24
    @GetMapping(params="pesoMinimo")
    public List<Envio> findByPesoGreaterThan(@RequestParam Integer pesoMinimo){
        return service.findByPesoGreaterThan(pesoMinimo);
    }

    //http://localhost:9090/api/v1/envios?destinoContiene=San
    @GetMapping(params="destinoContiene")
    public List<Envio> findByDestinoContaining(@RequestParam String destinoContiene){
        return service.findByDestinoContaining(destinoContiene);
    }

    //http://localhost:9090/api/v1/envios/entregados
    @GetMapping("/entregados")
    public List<Envio> findByEntregadoTrue(){
        return service.findByEntregadoTrue();
    }

    //http://localhost:9090/api/v1/envios?destinoComb=Santiago&tipoComb=Express
    @GetMapping(params={"destinoComb","tipoComb"})
    public List<Envio> findByDestinoAndTipo(@RequestParam String destinoComb, @RequestParam String tipoComb){
        return service.findByDestinoAndTipo(destinoComb,tipoComb);
    }

    //http://localhost:9090/api/v1/envios?tipoContiene=Express&pesoMayorQue=14
    @GetMapping(params={"tipoContiene","pesoMayorQue"})
    public List<Envio> findByTipoContainingAndPesoGreaterThan(@RequestParam String tipoContiene, @RequestParam Integer pesoMayorQue){
        return service.findByTipoContainingAndPesoGreaterThan(tipoContiene,pesoMayorQue);
    }

    //http://localhost:9090/api/v1/envios?destinoOrdenPesoDesc=Santiago
    @GetMapping(params="destinoOrdenPesoDesc")
    public List<Envio> findByDestinoOrderByPesoDesc(@RequestParam String destinoOrdenPesoDesc){
        return service.findByDestinoOrderByPesoDesc(destinoOrdenPesoDesc);
    }

    //http://localhost:9090/api/v1/envios/masPesado
    @GetMapping("/masPesado")
    public Envio findFirstByOrderByPesoDesc(){
        return service.findFirstByOrderByPesoDesc();
    }

    //http://localhost:9090/api/v1/envios?destinoIgCs=santiago
    @GetMapping(params="destinoIgCs")
    public List<Envio> findByDestinoIgnoreCase(@RequestParam String destinoIgCs){
        return service.findByDestinoIgnoreCase(destinoIgCs);
    }

    //http://localhost:9090/api/v1/envios?min=3&max=8
    @GetMapping(params={"min" , "max"})
    public List<Envio> findByIdBetween(@RequestParam Long min, @RequestParam Long max){
        return service.findByIdBetween(min,max);
    }







}
