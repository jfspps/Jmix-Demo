alter table PETCLINIC_VET add constraint FK_PETCLINIC_VET_PETSTORE foreign key (PETSTORE_ID) references PETCLINIC_PET_STORE(ID);
create index IDX_PETCLINIC_VET_PETSTORE on PETCLINIC_VET (PETSTORE_ID);
