package com.haulmont.sample.petclinic.entity.visit;

import javax.persistence.*;

import com.haulmont.sample.petclinic.entity.pet.Pet;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import java.util.Date;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.sample.petclinic.entity.vet.Vet;

@NamePattern("%s (%s)|pet,visitDate")
@Table(name = "PETCLINIC_VISIT")
@Entity(name = "petclinic_Visit")
public class Visit extends StandardEntity {
    private static final long serialVersionUID = 6351202390461847589L;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "VISIT_DATE", nullable = false)
    protected Date visitDate;

    @Column(name = "DESCRIPTION", length = 4000)
    protected String description;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_ID")
    protected Pet pet;

    // assume
    // (a) visit-to-vet is manyToOne (a vet can be involved with multiple visits)
    // (b) since for this demo no Vet FKs were inserted using 30.create-db.sql, these have to be nullable db relationships and
    // nullable Java entities (with INSERTs added, then optional = false and @NotNull annotation would apply)
    // (c) allow retrieval of Vet details on-demand
    // + override the defaults to label the vet foreign key column as "VET_ID" per 10.create-db.sql
    // + allow subclasses of Visit to access "vet" Java object field
    // (DB connection settings in modules/core/web/META-INF/context.xml)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VET_ID")
    protected Vet vet;

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}