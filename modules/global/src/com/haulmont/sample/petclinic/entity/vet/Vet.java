package com.haulmont.sample.petclinic.entity.vet;

import javax.persistence.*;

import com.haulmont.sample.petclinic.entity.Person;
import com.haulmont.sample.petclinic.entity.petstore.PetStore;

import java.util.Set;

@Table(name = "PETCLINIC_VET")
@Entity(name = "petclinic_Vet")
public class Vet extends Person {
    private static final long serialVersionUID = 8571203926820669424L;

    @JoinTable(name = "PETCLINIC_VET_SPECIALTY_LINK",
        joinColumns = @JoinColumn(name = "VET_ID"),
        inverseJoinColumns = @JoinColumn(name = "SPECIALTY_ID"))
    @ManyToMany
    protected Set<Specialty> specialties;

    // assume each Vet can only be assigned to one Pet Store
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PETSTORE_ID")
    protected PetStore petStore;

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}