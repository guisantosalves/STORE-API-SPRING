package com.project.solinium.impl.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.solinium.model.Providers;
import com.project.solinium.repository.ProvidersRepo;
import com.project.solinium.services.ProvidersServ;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvidersServImpl implements ProvidersServ {
    
    private final ProvidersRepo providersRepo;

    @Override
    public List<Providers> findAllProviders(){
        return providersRepo.findAll();
    }
}
