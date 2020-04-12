package com.entrevista;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.entrevista.model.Client;
import com.entrevista.service.ClientService;

@RunWith(SpringRunner.class)
@ComponentScan("com.entrevista")
@DataJpaTest
public class ClientServiceTest {
	
    @Autowired
    private ClientService clientService;
    
    @Test
    public void testSaveClient() throws Exception {
        Client client = new Client();
        client.setName("Jose");
        
        clientService.saveClient(client);

        List<Client> clients = clientService.getAllClients();
        Assert.assertNotNull(client);

        boolean joseExists = Boolean.FALSE;

        for(Client c : clients) {
            if("Jose".equals(c.getName())) {
                joseExists = Boolean.TRUE;
            }
        }

        Assert.assertTrue(joseExists);
    }
}
