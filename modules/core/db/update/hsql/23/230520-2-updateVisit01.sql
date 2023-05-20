alter table PETCLINIC_VISIT add constraint FK_PETCLINIC_VISIT_VET foreign key (VET_ID) references PETCLINIC_VET(ID);
create index IDX_PETCLINIC_VISIT_VET on PETCLINIC_VISIT (VET_ID);
