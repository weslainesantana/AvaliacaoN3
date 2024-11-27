## Equipe: João Fontanella, Weslaine Santana e Ana Beatriz Meller.

## Documentação de Medicamentos

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

## Documentação de Pacientes

### Base URL
```
http://localhost:8080
```

---

### Endpoints

#### 1. **POST /patients**
Cria um novo paciente.

**Request Body**:
```json
{
    "name": "Fulano",
    "age": 24,
    "medicalHistory": "Asma"
}
```

**Response**:
- **Status Code**: 201 Created  
- **Body**:
```json
{
    "id": 1,
    "name": "Fulano",
    "age": "24",
    "medicalHistory": "Asma"
}
```

---

#### 2. **GET /patients?page=pageNumber&size=pageSize**
Retorna uma lista paginada de pacientes.

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
            "name": "Fulano",
            "age": "24",
            "medicalHistory": "Asma"
        },
        {
            "id": 2,
            "name": "Ciclano",
            "age": "30",
            "medicalHistory": "Hipertensão"
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

#### 3. **GET /patients/{id}**
Retorna os detalhes de um paciente específico.

**Path Parameter**:
- `id`: ID do paciente.

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "name": "Fulano",
    "age": "24",
    "medicalHistory": "Asma"
}
```

---

#### 4. **PUT /patients/{id}**
Atualiza os dados de um paciente existente.

**Path Parameter**:
- `id`: ID do paciente.

**Request Body**:
```json
{
    "name": "Ciclano",
    "age": 24,
    "medicalHistory": "atualizado"
}
```

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "name": "Ciclano",
    "age": "24",
    "medicalHistory": "atualizado"
}
```

---

#### 5. **DELETE /patients/{id}**
Deleta um paciente existente.

**Path Parameter**:
- `id`: ID do paciente.

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "name": "Fulano",
    "age": "24",
    "medicalHistory": "Asma"
}
```
## Documentação de Prescrições

### Base URL
```
http://localhost:8080
```

---

### Endpoints

#### 1. **POST /prescription**
Cria uma nova prescrição.

**Request Body**:
```json
{
    "quantity": 1,
    "frequency": "todo dia",
    "startDate": "08/02/2020",
    "endDate": "01/02/2023",
    "patientId": 1,
    "medicineId": 1
}
```

**Response**:
- **Status Code**: 201 Created  
- **Body**:
```json
{
    "id": 1,
    "quantity": 1,
    "frequency": "todo dia",
    "startDate": "2020-02-07",
    "endDate": "2023-01-31",
    "patient": {
        "id": 1,
        "name": null,
        "age": null,
        "medicalHistory": null
    },
    "medicine": {
        "id": 1,
        "name": null,
        "description": null,
        "dose": null,
        "expirationDate": null
    }
}
```

---

#### 2. **GET /prescription?page=pageNumber&size=pageSize**
Retorna uma lista paginada de prescrições.

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
            "quantity": 1,
            "frequency": "todo dia",
            "startDate": "2020-02-07",
            "endDate": "2023-01-31",
            "patient": {
                "id": 1,
                "name": "Fulano",
                "age": "24",
                "medicalHistory": "Asma"
            },
            "medicine": {
                "id": 1,
                "name": "Dorflex",
                "description": "descrição",
                "dose": "500ml",
                "expirationDate": "06/07/2023"
            }
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
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
    },
    "numberOfElements": 1,
    "first": true,
    "empty": false
}
```

---

#### 3. **GET /prescription/{id}**
Retorna os detalhes de uma prescrição específica.

**Path Parameter**:
- `id`: ID da prescrição.

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "quantity": 1,
    "frequency": "todo dia",
    "startDate": "2020-02-07",
    "endDate": "2023-01-31",
    "patient": {
        "id": 1,
        "name": "Fulano",
        "age": "24",
        "medicalHistory": "Asma"
    },
    "medicine": {
        "id": 1,
        "name": "Dorflex",
        "description": "descrição",
        "dose": "500ml",
        "expirationDate": "06/07/2023"
    }
}
```

---

#### 4. **PUT /prescription/{id}**
Atualiza os dados de uma prescrição existente.

**Path Parameter**:
- `id`: ID da prescrição.

**Request Body**:
```json
{
    "quantity": 2,
    "frequency": "todo dia",
    "startDate": "08/02/2020",
    "endDate": "01/02/2023",
    "patientId": 1,
    "medicineId": 1
}
```

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "quantity": 2,
    "frequency": "todo dia",
    "startDate": "2020-02-07",
    "endDate": "2023-01-31",
    "patient": {
        "id": 1,
        "name": "Fulano",
        "age": "24",
        "medicalHistory": "Asma"
    },
    "medicine": {
        "id": 1,
        "name": "Dorflex",
        "description": "descrição",
        "dose": "500ml",
        "expirationDate": "06/07/2023"
    }
}
```

---

#### 5. **DELETE /prescription/{id}**
Deleta uma prescrição existente.

**Path Parameter**:
- `id`: ID da prescrição.

**Response**:
- **Status Code**: 200 OK  
- **Body**:
```json
{
    "id": 1,
    "quantity": 2,
    "frequency": "todo dia",
    "startDate": "2020-02-07",
    "endDate": "2023-01-31",
    "patient": {
        "id": 1,
        "name": "Fulano",
        "age": "24",
        "medicalHistory": "Asma"
    },
    "medicine": {
        "id": 1,
        "name": "Dorflex",
        "description": "descrição",
        "dose": "500ml",
        "expirationDate": "06/07/2023"
    }
}
```
