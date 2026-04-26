package com.example.logistica.service;

import com.example.logistica.model.Envio;
import com.example.logistica.repository.EnvioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //Hace inicialización del objeto "repository". Construcctor vacio

public class EnvioService {

    private final EnvioRepository repository;

    public List<Envio> findAll(){
        return repository.findAll(); //Hereda el metodo de jpa repository
    }

    public Optional<Envio> findById(Long id){
        return repository.findById(id);
    }

    public List<Envio> findByDestino(String destino){
        return repository.findByDestino(destino);
    }

    public List<Envio> findByPesoGreaterThan(Integer pesoMinimo){
        return repository.findByPesoGreaterThan(pesoMinimo);
    }

    public List<Envio> findByDestinoContaining(String destinoContiene){
        return repository.findByDestinoContaining(destinoContiene);
    }
    public List<Envio> findByEntregadoTrue(){
        return repository.findByEntregadoTrue();
    }

    public List<Envio> findByDestinoAndTipo(String destinoComb, String tipoComb){
        return repository.findByDestinoAndTipo(destinoComb,tipoComb);
    }
    public List<Envio> findByTipoContainingAndPesoGreaterThan(String tipoContiene, Integer pesoMayorQue){
        return repository.findByTipoContainingAndPesoGreaterThan(tipoContiene,pesoMayorQue);
    }
    public List<Envio> findByDestinoOrderByPesoDesc(String destinoOrdenPesoDesc){
        return repository.findByDestinoOrderByPesoDesc(destinoOrdenPesoDesc);
    }
    public Envio findFirstByOrderByPesoDesc(){
        return repository.findFirstByOrderByPesoDesc();
    }
    public List<Envio> findByDestinoIgnoreCase(String destinoIgCs){
        return repository.findByDestinoIgnoreCase(destinoIgCs);
    }
    public List<Envio> findByIdBetween(Long min, Long max){
        return repository.findByIdBetween(min,max);
    }


}
