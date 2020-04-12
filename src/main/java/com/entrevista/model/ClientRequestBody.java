package com.entrevista.model;

import javax.validation.Valid;

public class ClientRequestBody {
	
	@Valid
    private Client client;
	
	@Valid
    private Product product;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
