package com.haulmont.sample.petclinic.entity.petstore;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.sample.petclinic.entity.NamedEntity;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import com.haulmont.sample.petclinic.entity.vet.Vet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "PETCLINIC_PET_STORE")
@Entity(name = "petclinic_PetStore")
@NamePattern("%s|name")
public class PetStore extends NamedEntity {

    private static final long serialVersionUID = 6117702650337489682L;

    // assume we cannot have the same vet re-assigned to a given pet store;
    // mark Vet as the owner of the relationship
    @OneToMany(mappedBy = "petStore")
    protected Set<Vet> vets;

    // similar assumptions for pets as is for vets
    @OneToMany(mappedBy = "petStore")
    protected Set<Pet> pets;

    public Set<Vet> getVets() {
        return vets;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}