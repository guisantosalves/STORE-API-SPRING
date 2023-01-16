package com.project.solinium.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.solinium.impl.services.ProvidersServImpl;
import com.project.solinium.model.Providers;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/providers")
public class ProviderController {
    
    private final ProvidersServImpl providersServImpl;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Providers>> getAllProviders(){
        return new ResponseEntity<List<Providers>>(providersServImpl.findAllProviders(), HttpStatus.OK);
    }

}
