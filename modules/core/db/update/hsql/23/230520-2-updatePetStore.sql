alter table PETCLINIC_PET_STORE alter column PET_STORE_NAME rename to PET_STORE_NAME__U83718 ^
alter table PETCLINIC_PET_STORE alter column PET_STORE_NAME__U83718 set null ;
alter table PETCLINIC_PET_STORE add column NAME varchar(255) ^
update PETCLINIC_PET_STORE set NAME = '' where NAME is null ;
alter table PETCLINIC_PET_STORE alter column NAME set not null ;
