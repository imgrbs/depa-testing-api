package com.depa.form.model.form;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.field.Field;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Form {
    
    @Id
    private String id;
    private String uid;
    private String name;
    private String description;
    @OneToMany
    private List<Field> fields;

    public Form(FormDTO formDTO) {
        this.name = formDTO.getName();
        this.description = formDTO.getDescription();
        this.fields = new ArrayList<>();

        if (formDTO.getFields() != null) {
            formDTO.getFields().forEach(fieldDTO -> {
                this.fields.add(fieldDTO.toField());
            });
        }
    }

    public Form() {
    }

    public String getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Field> getFields() {
        return this.fields;
    }

}
