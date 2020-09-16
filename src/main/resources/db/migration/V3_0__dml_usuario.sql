INSERT INTO avexado.t_usuario (id, email, login, senha)
VALUES (1, 'erivann47@gmail.com', 'erivan.junior', '$2y$12$amuWqoRckKwfpXtUZPB0u..TJBX3yc9BANUoFcAk4wXfPrDOtKaO2');

INSERT INTO avexado.t_perfil_usuario (id_usuario, perfil)
select
    id, 'ROLE_ADMIN'
from t_usuario
where login = 'erivan.junior'
and email = 'erivann47@gmail.com';