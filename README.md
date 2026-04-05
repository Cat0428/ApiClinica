# Servicio Clínico - Arquitectura Hexagonal

## Proyecto elegido
Sistema clínico simple para registrar resultados de exámenes médicos y generar alertas cuando los valores están fuera del rango permitido.

## Requerimiento implementado
Registrar un examen médico y evaluar si el valor está dentro del rango permitido.  
Si el valor es anormal, el sistema genera una alerta.

Ejemplo:
- Tipo de examen: glucosa
- Valor: 250
- Resultado: se genera alerta

## Arquitectura utilizada
El proyecto utiliza **Arquitectura Hexagonal (Ports and Adapters)**.

Esto permite separar la lógica de negocio del framework y de la infraestructura.

Capas implementadas:

- Dominio
- Casos de uso
- Puertos de entrada
- Puertos de salida
- Adaptadores de entrada
- Adaptadores de salida

## Estructura del Proyecto

```
com.clinica
│
├── domain
│   ├── model
│   │   ├── Examen.java
│   │   └── Alerta.java
│   │
│   └── service
│       └── EvaluadorRangoService.java
│
├── application
│   ├── ports
│   │   ├── input
│   │   │   └── RegistrarExamenUseCase.java
│   │   │
│   │   └── output
│   │       ├── ExamenRepositoryPort.java
│   │       └── AlertaRepositoryPort.java
│   │
│   └── usecase
│       └── RegistrarExamenUseCaseImpl.java
│
├── adapters
│   ├── input
│   │   └── rest
│   │       └── ExamenController.java
│   │
│   └── output
│       └── repository
│           └── ExamenRepositoryMemory.java
│
└── config
    └── BeanConfiguration.java
```
## Explicación de componentes

Dominio:
Contiene las entidades principales del sistema y la lógica de negocio.

Caso de uso:
Implementa la lógica para registrar un examen y evaluar su valor.

Puerto de entrada:
Define la interfaz que permite ejecutar el caso de uso.

Puerto de salida:
Define cómo se almacenan los datos sin depender de la implementación.

Adaptador de entrada:
Exposición de la funcionalidad mediante un endpoint REST.

Adaptador de salida:
Implementación de repositorio en memoria para almacenar los datos.

## Endpoint REST

POST
http://localhost:8080/examenes


Body:

{
"tipo": "glucosa",
"valor": 120
}


## Cómo ejecutar el proyecto

1. Clonar el repositorio
2. Abrir el proyecto en **:contentReference[oaicite:1]{index=1}**
3. Ejecutar la clase principal:


4. Probar el endpoint con **:contentReference[oaicite:2]{index=2}**.

## Pruebas unitarias

Se implementaron pruebas unitarias para validar:

Caso exitoso
Se registra un examen con valor normal.

![image alt](https://github.com/Cat0428/ApiClinica/blob/74ee32751f99270f039d7f19086d5e458e87b7d6/Caso%20exitoso%20en%20Postman.png)

![image alt](https://github.com/Cat0428/ApiClinica/blob/d91d28a41c5a9e97b587e27995cc6fe62d3976a0/Caso%20existoso%20Consola.png)

Caso inválido
Se registra un examen con valor fuera del rango permitido y se genera alerta.

Comportamiento esperado
Se verifica que el repositorio y la generación de alertas funcionen correctamente.


