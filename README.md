## Documentação da API REST

### Base URL
```
http://localhost:8080
```

---

### Endpoints

#### 1. **POST /medicine**
Cria um novo medicamento.

**Request Body**:
```json
{
    "name": "Dorflex",
    "description": "descrição",
    "dose": "500ml",
    "expirationDate": "06/07/2023"
}
```

**Response**:
- **Status Code**: 201 Created  
- **Body**:
```json
{
    "id": 1,
    "name": "Dorflex",
    "description": "descrição",
    "dose": "500ml",
    "expirationDate": "06/07/2023"
}
```

---

#### 2. **GET /medicine?page=pageNumber&size=pageSize**
Retorna uma lista paginada de medicamentos.

**Parâmetros de Query**:
- `page` (opcional): Número da página (padrão: `0`).
- `size` (opcional): Número de itens por página (padrão: `10`).

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "content": [
        {
            "id": 1,
            "name": "Dorflex",
            "description": "descrição",
            "dose": "500ml",
            "expirationDate": "06/07/2023"
        },
        {
            "id": 2,
            "name": "Dorflex",
            "description": "descrição",
            "dose": "500ml",
            "expirationDate": "06/07/2023"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "sorted": false,
            "empty": true,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
    },
    "numberOfElements": 2,
    "first": true,
    "empty": false
}
```

---

#### 3. **GET /medicine/{id}**
Retorna os detalhes de um medicamento específico.

**Path Parameter**:
- `id`: ID do medicamento.

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "name": "Dorflex",
    "description": "descrição",
    "dose": "500ml",
    "expirationDate": "06/07/2023"
}
```

---

#### 4. **PUT /medicine/{id}**
Atualiza os dados de um medicamento existente.

**Path Parameter**:
- `id`: ID do medicamento.

**Request Body**:
```json
{
    "name": "Buscopan",
    "description": "descrição",
    "dose": "500ml",
    "expirationDate": "06/07/2023"
}
```

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 2,
    "name": "Buscopan",
    "description": "descrição",
    "dose": "500ml",
    "expirationDate": "06/07/2023"
}
```

---

#### 5. **DELETE /medicine/{id}**
Deleta um medicamento existente.

**Path Parameter**:
- `id`: ID do medicamento.

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 2,
    "name": "Buscopan",
    "description": "descrição",
    "dose": "500ml",
    "expirationDate": "06/07/2023"
}
```
