package com.entrevista.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;

import com.entrevista.utils.StringCapitalize;

@Entity(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Nome do cliente não pode ser nulo")
    @NotEmpty(message = "Nome do cliente não de ser vazio")
    private String name;

    public Client() {

    }

    public Client(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
    	if (Objects.nonNull(name) && ! StringUtils.isEmpty(name)) {
    		this.name = StringCapitalize.capitalize(name);
    	} else {
    		this.name = name;
    	}    		
    }
    	
}
