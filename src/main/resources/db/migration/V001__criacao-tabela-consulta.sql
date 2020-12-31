drop table if exists CONSULTA;

/*==============================================================*/
/* Table: CONSULTA                                              */
/*==============================================================*/
create table CONSULTA
(
   ID_CONSULTA  bigint  not null,
   DATA_CONSULTA date,
   HORA_CONSULTA time,
   DESCRICAO_CONSULTA varchar(200),
   primary key (ID_CONSULTA)
)
 engine=InnoDB default charset=utf8