select  * from medico m ;


INSERT INTO public.medico
(cpf_documento, 
crm_medico, 
email, 
especialidade_medica, 
nome, 
rg_documento, 
sobre_nome)
VALUES('95094752030', '1111111', 'medico@teste.com.br', 'Clinico geral', 'Lucas', '', 'Ferreira');


select * from laudo_medico lm ;

INSERT INTO public.laudo_medico
( descricao_laudo)
VALUES('teste');

INSERT INTO public.laudo_medico
(data_laudo_medico, descricao_laudo, hora_laudo_medico)
VALUES('2021-01-25T00:00:00', 'teste', '21:27');

select * from medico_laudo_medicos mlm ;

INSERT INTO public.medico_laudo_medicos
(medico_id, laudo_medicos_id)
VALUES(1, 1);

select  * from medico m ;

select * from laudo_medico lm ;

select * from medico_laudo_medicos mlm ;
