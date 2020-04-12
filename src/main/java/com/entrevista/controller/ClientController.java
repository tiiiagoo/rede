package com.entrevista.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrevista.model.Client;
import com.entrevista.model.ClientRequestBody;
import com.entrevista.service.ClientService;
import com.entrevista.service.ProductService;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(value = "/list")
    public List<Client> getClientList() {     
        return clientService.getAllClients();
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackForClassName = {"Exception"} )
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(value = "/save")    
    public void saveClient(@Valid @RequestBody ClientRequestBody clientRequestBody) throws Exception {    	
        clientService.saveClient(clientRequestBody.getClient());
        productService.saveProduct(clientRequestBody.getProduct());
    }
}
