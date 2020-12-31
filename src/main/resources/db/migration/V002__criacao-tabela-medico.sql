drop table if exists MEDICO;

/*==============================================================*/
/* Table: MEDICO                                              */
/*==============================================================*/

create table MEDICO
(
   ID_MEDICO    bigint  not null,
   ID_CONSULTA  bigint,
   NOME        varchar(50)  not null,
   SOBRE_NOME  varchar(50)  not null,
   RG_MEDICO   varchar(10),
   CPF_MEDICO  varchar(11),
   CRM_MEDICO  varchar(7),
   ESPECIALIDADE_MEDICA  varchar(100) not null,
   primary key (ID_MEDICO)
)
 engine=InnoDB default charset=utf8