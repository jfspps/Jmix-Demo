alter table PETCLINIC_PET add constraint FK_PETCLINIC_PET_PETSTORE foreign key (PETSTORE_ID) references PETCLINIC_PET_STORE(ID);
create index IDX_PETCLINIC_PET_PETSTORE on PETCLINIC_PET (PETSTORE_ID);