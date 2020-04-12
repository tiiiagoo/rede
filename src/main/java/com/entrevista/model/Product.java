package com.entrevista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.entrevista.utils.StringCapitalize;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    @NotNull(message = "codigo do produdo não pode ser nulo")
    private Long codigo;
    
    @NotNull(message = "Nome do produdo não pode ser nulo")
    @NotEmpty(message = "Nome do produto não pode ser vazio")
    private String description;

    public Product() {
    }

    public Product(Long id, Long codigo, String description) {
        this.id = id;
        this.codigo = codigo;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = StringCapitalize.capitalize(description);
    }
}
