package com.entrevista.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevista.model.Client;
import com.entrevista.model.Log;
import com.entrevista.model.Product;
import com.entrevista.repository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;
    private static String clientName = "";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

    private void saveLog(String texto) {
    	
        Log log =  new Log(texto);

        try {
              logRepository.save(log);
        } catch(Exception ex) {
            System.out.println("Erro ao salvar log: " + ex);
        }
    }
    
    public void logClient(Client client, Exception exception) {
    	clientName = client.getName();    	
    	String texto  = Objects.nonNull(exception.getMessage()) ? 
    			getDateTime()+" - Erro ao registrar cliente [" + client.getName() + "] " + exception.getCause().getMessage() + exception.getClass() :		
    				getDateTime()+" - Cliente [" + client.getName() + "] registrado. ";
		saveLog(texto);
	}
    
    public void logProduct(Product product, Exception exception) {
    	String texto = "";
    	if (Objects.nonNull(exception.getMessage())) {
    		texto = getDateTime()+" - Erro ao registrar produto [" + product.getDescription() + " - codigo "+ product.getCodigo()+ " ]" + 
					exception.getCause().getMessage() + exception.getClass();
    		saveLog(texto);
    	}else {
    		texto = getDateTime()+" - Produto [" + product.getDescription() + " - codigo "+ product.getCodigo()+ " ] registrado";
			saveLog(texto);
			fullLog(product);
    	}
	}
    
    private void fullLog(Product product) {
    	String texto = getDateTime()+" - Registrado Cliente "+clientName+ " com o produto "+product.getDescription()+ " de codigo "+product.getCodigo();
    	saveLog(texto);
    }

	private String getDateTime() {
		LocalDateTime date = LocalDateTime.now();
    	String formatDateTime = date.format(formatter);
		return formatDateTime;
	}
     
}
