package com.entrevista.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevista.exception.ClientDuplicatedException;
import com.entrevista.model.Client;
import com.entrevista.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private LogService logService;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    public void saveClient(Client client) throws Exception {
    	Exception exception = new Exception();
        try {
            client = clientRepository.save(client);
        } catch(Exception ex) {
        	exception = ex;
        	if(ex.getCause().getClass().equals(ConstraintViolationException.class)) {
        		throw new ClientDuplicatedException();
        	}            
        }finally {
        	logService.logClient(client, exception);
        }
    }
}
