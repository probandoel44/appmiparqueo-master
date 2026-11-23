# MiParqueo App: copia appmiparqueo-master

## Identificacion

- Repositorio: https://github.com/probandoel44/appmiparqueo-master
- Rama revisada: `main`
- Commit base revisado: `0aeb7c49bf393f94427cc24fcef82151facf9a65`
- El proyecto se encuentra dentro de `appmiparqueo-master/`; abre esa subcarpeta para ejecutar Maven.
- Es una copia parcial/alternativa, no el repositorio canónico integrado. La referencia de integración recomendada es https://github.com/probandoel44/Desarrollar-software-a-partir-de-la-integraci-n-de-sus-m-dulos-componentes.

## Propósito y componentes observados

El código revisado tiene una API REST para administrar usuarios, con `UsuariosController`, `UsuariosRepository` y la entidad JPA `Usuarios`. El `pom.xml` declara Java 17, Spring Boot 2.5.14, Spring Web, Spring Data JPA, Validation, Lombok y MySQL Connector. La configuración de datasource está en `appmiparqueo-master/src/main/resources/application.properties`.

### Entradas y salidas

| Ruta | Entrada | Salida/efecto observado |
| --- | --- | --- |
| `GET /api/usuarios` | Ninguna. | Devuelve la lista persistida de usuarios. |
| `GET /api/usuarios/{id}` | `id` en la ruta (`Long`). | Devuelve el usuario o `null` cuando no existe. |
| `POST /api/usuarios` | JSON de `Usuarios`: `documento` (entero), `nombre`, `apellido`, `correo`, `telefono` (entero), `rol` y `contrasena`. | Persiste y devuelve la entidad. La contraseña se incluye en el modelo de respuesta actual; no se debe usar esta API con datos reales hasta corregir y probar el manejo de credenciales. |
| `PUT /api/usuarios/{id}` | `id` en la ruta y el mismo objeto JSON. | Sobrescribe el ID del cuerpo y guarda la entidad. |
| `DELETE /api/usuarios/{id}` | `id` en la ruta. | La implementación revisada está vacía; no elimina el registro. |

La entidad declara restricciones Jakarta Validation, pero el controlador no anota sus parámetros con `@Valid`; la validación automática no está demostrada. No encontré aquí rutas para reservas, pagos, movimientos ni barrera.

## Evidencia SENA

| Elemento | Estado observado |
| --- | --- |
| Requerimientos oficiales e informe de evaluación | No localizados en esta copia. No atribuirle R01–R10 sin contrastar el informe oficial. |
| Acta de aprobación | No localizada; pendiente. |
| Git | Repositorio público y commit base indicados arriba. Después de agregar esta guía, registrar el nuevo commit que resulte. |
| Ejecutable | No hay JAR verificado. El JAR sería un artefacto Java, no un `.exe`; no afirmar que existe hasta compilarlo. |
| Despliegue | No hay URL pública verificada. |
| Pruebas | No se revisó un resultado de pruebas asociado al commit indicado. No afirmar pruebas aprobadas. |
| Servidor y base de datos | Java 17, Spring Boot 2.5.14 y MySQL según `pom.xml`/`application.properties`. La configuración usa `ddl-auto=update`; probar únicamente contra una base aislada. |
| Ambientes | No se identificó un perfil de pruebas separado. |
| Manual técnico | Esta guía documenta el controlador revisado; faltan pruebas, despliegue, aprobación y configuración segura antes de presentarlo como módulo entregable. |

## Ejecución local

Desde la subcarpeta `appmiparqueo-master/`, con Java 17 y una base MySQL aislada configurada:

```powershell
.\mvnw.cmd spring-boot:run
```

Para construir el JAR esperado (aún no generado/verificado):

```powershell
.\mvnw.cmd package
```

El nombre esperado por Maven es `target/appmiparqueo-0.0.1-SNAPSHOT.jar`; confirma el archivo después de compilar. No se verificó un puerto explícito ni una URL desplegada en esta copia.

## Pendientes

1. Comparar este snapshot con el commit oficial de MiParqueo y decidir si se conserva como antecedente.
2. Implementar o retirar operaciones incompletas como DELETE; asegurar que las respuestas nunca expongan contraseñas.
3. Aplicar `@Valid` y pruebas unitarias/de integración a las rutas de usuarios.
4. Adjuntar requerimientos aprobados, acta, resultados de pruebas y URL real si existe.