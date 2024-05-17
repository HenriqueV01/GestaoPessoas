### Teste Técnico:
A API desenvolvida deve permitir:
- Criar, editar e consultar uma ou mais pessoas;
- Criar, editar e consultar um ou mais endereços de uma pessoa; e
- Poder indicar qual endereço será considerado o principal de uma pessoa.

**Documentação Swagger:**
- http://localhost:8080/swagger-ui/index.html

**Banco H2:**
- http://localhost:8080/h2-console
- username=sa
- password=

```sql
INSERT INTO
  pessoa
  (id, data_nascimento, nome_completo)
VALUES
  (1,01012000, 'joao'),
  (2,01012000, 'maria'),
  (3,01012000, 'daniel');


INSERT INTO
  endereco
  (id,cep,numero,cidade,estado,logradouro,pessoa_id)
VALUES
  (1,54000,123,'Recife','PE','Centro',1),
  (2,54000,123,'Recife','PE','Centro',2),
  (3,54000,123,'Recife','PE','Centro',3);
```

Exemplo Json:
```json
Pessoa:
{
    "id": 1,
    "nomeCompleto": "joao",
    "dataNascimento": 1012000,
    "enderecos": [
      {
        "id": 1,
        "logradouro": "Centro",
        "numero": 123,
        "cidade": "Recife",
        "estado": "PE",
        "cep": 54000
      }
    ]
}

Endereço:
{
    "id": 1,
    "logradouro": "Centro",
    "numero": 123,
    "cidade": "Recife",
    "estado": "PE",
    "cep": 54000
  }
```

##

- Contato: (81) 98578 5488.
- E-mail: henrique.unibratec01@gmail.com

##
