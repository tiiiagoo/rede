package com.entrevista;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.entrevista.model.Client;
import com.entrevista.repository.ClientRepository;

@RunWith(SpringRunner.class)
@ComponentScan("com.entrevista")
@DataJpaTest
public class ClientRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;

	@Autowired
    private ClientRepository clientRepository;

    @Test
    public void insertTest() {
        String name = "Jose da Silva";

        Client client = clientRepository.findByName(name);
        Assert.assertNull(client);

        client = new Client(name);
        entityManager.persist(client);

        client = clientRepository.findByName(name);

        Assert.assertNotNull(client);
        Assert.assertNotNull(client.getId());
        Assert.assertEquals(client.getName(), name);
    }
}
