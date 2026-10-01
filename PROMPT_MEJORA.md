# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/financial/auth/domain/model/User.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/domain/ports/AuthServicePort.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/domain/ports/UserRepositoryPort.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/application/usecases/AuthUseCase.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/adapters/UserJpaRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/adapters/AuthServiceAdapter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/controllers/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/security/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/financial/auth/infrastructure/config/OpenApiConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/financial/auth/infrastructure/controllers/AuthControllerTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/financial/auth/application/usecases/AuthUseCaseTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/financial/auth/infrastructure/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — `User.getId`: Se invoca `getId` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — `User.getUsername`: Se invoca `getUsername` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — `User.getRole`: Se invoca `getRole` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — `JwtTokenUtil.extractUsername`: Se invoca `extractUsername` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — `JwtTokenUtil.extractUserId`: Se invoca `extractUserId` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java` — `JwtTokenUtil.extractRole`: Se invoca `extractRole` sobre `JwtTokenUtil`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/application/usecases/AuthUseCaseTest.java` — `User.getUsername`: Se invoca `getUsername` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/application/usecases/AuthUseCaseTest.java` — `User.isPresent`: Se invoca `isPresent` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/application/usecases/AuthUseCaseTest.java` — `User.get`: Se invoca `get` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/financial/auth/application/usecases/AuthUseCaseTest.java` — `User.isEmpty`: Se invoca `isEmpty` sobre `User`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior

### Brecha de conocimiento
Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT

### Misión / candidato
Candidato con experiencia senior en equipos de backend.

### Reto
- Tema: Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código
- Seniority: senior-l2
- Tipo: practical
- Título: Implementación de Autenticación Segura y Legible
- Tiempo estimado: 2 semanas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Diseño del Mecanismo de Autenticación — objetivo: Definir la estructura y los componentes necesarios para implementar la autenticación basada en JWT. — entregable (NO resolver): Diagrama de relaciones que muestra los componentes y sus interacciones en el proceso de autenticación.
- Fase 2: Implementación del Servicio de Autenticación — objetivo: Crear el servicio de autenticación que genere y valide tokens JWT. — entregable (NO resolver): Servicio de autenticación que genera y valida tokens JWT.
- Fase 3: Integración con el Sistema de Gestión de Usuarios — objetivo: Integrar el servicio de autenticación con el sistema de gestión de usuarios. — entregable (NO resolver): Sistema de gestión de usuarios que utiliza el servicio de autenticación para controlar el acceso.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.financial</groupId>
    <artifactId>auth-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>auth-service</name>
    <description>Servicio de autenticación para plataforma financiera</description>

    <properties>
        <java.version>21</java.version>
        <springdoc-openapi.version>2.6.0</springdoc-openapi.version>
        <jjwt.version>0.12.5</jjwt.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc-openapi.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/financial/auth/Application.java ===
package com.financial.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Clock;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedOrigins("*")
                        .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: auth-service
  
  datasource:
    url: jdbc:postgresql://localhost:5432/financial_auth
    username: financial_user
    password: secure_password_123
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 2
      idle-timeout: 30000
      connection-timeout: 30000
      max-lifetime: 600000

  jpa:
    hibernate:
      ddl-auto: validate
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    show-sql: true

  security:
    user:
      name: admin
      password: admin
      roles: ADMIN

jwt:
  secret: ${JWT_SECRET:bXktc2VjdXJlLXNlY3JldC1rZXktZm9yLWp3dC10b2tlbi1kZW1vLWZpbmFuY2lhbC1wbGF0Zm9ybQ==}
  expiration: 86400000 # 24 horas en milisegundos
  issuer: financial-auth-service

server:
  port: 8080
  servlet:
    context-path: /api/auth
  error:
    include-message: always
    include-binding-errors: always

logging:
  level:
    root: INFO
    com.financial.auth: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.security: DEBUG

// === ARCHIVO: src/main/java/com/financial/auth/domain/model/User.java ===
package com.financial.auth.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private String role;
    
    public User(UUID id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/domain/ports/AuthServicePort.java ===
package com.financial.auth.domain.ports;

import com.financial.auth.domain.model.User;
import java.util.Optional;

public interface AuthServicePort {
    String generateToken(User user);
    
    Optional<User> validateToken(String token);
}

// === ARCHIVO: src/main/java/com/financial/auth/domain/ports/UserRepositoryPort.java ===
package com.financial.auth.domain.ports;

import com.financial.auth.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    User save(User user);
    
    Optional<User> findById(UUID id);
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/adapters/UserJpaRepository.java ===
package com.financial.auth.infrastructure.adapters;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.UserRepositoryPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserJpaRepository implements UserRepositoryPort {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/application/usecases/AuthUseCase.java ===
package com.financial.auth.application.usecases;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.AuthServicePort;
import com.financial.auth.domain.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUseCase {

    private final AuthServicePort authServicePort;
    private final UserRepositoryPort userRepositoryPort;

    public Optional<String> authenticate(String username, String password) {
        return Optional.empty();
    }

    public Optional<User> validateToken(String token) {
        return Optional.empty();
    }

    public User register(String username, String email, String password, String role) {
        return null;
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/adapters/AuthServiceAdapter.java ===
package com.financial.auth.infrastructure.adapters;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.AuthServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceAdapter implements AuthServicePort {

    @Override
    public String generateToken(User user) {
        return null;
    }

    @Override
    public Optional<User> validateToken(String token) {
        return Optional.empty();
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/controllers/AuthController.java ===
package com.financial.auth.infrastructure.controllers;

import com.financial.auth.domain.ports.AuthServicePort;
import com.financial.auth.domain.ports.UserRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServicePort authServicePort;
    private final UserRepositoryPort userRepositoryPort;

    public AuthController(AuthServicePort authServicePort, UserRepositoryPort userRepositoryPort) {
        this.authServicePort = authServicePort;
        this.userRepositoryPort = userRepositoryPort;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> userData) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/security/JwtTokenUtil.java ===
package com.financial.auth.infrastructure.security;

import com.financial.auth.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration:3600000}")
    private Long expiration;

    public String generateToken(User user) {
        return null;
    }

    public Optional<Claims> validateToken(String token) {
        return Optional.empty();
    }

    public String getUsernameFromToken(String token) {
        return null;
    }

    public String getRoleFromToken(String token) {
        return null;
    }

    public boolean isTokenExpired(String token) {
        return true;
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    private Claims extractAllClaims(String token) {
        return null;
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/security/JwtAuthenticationFilter.java ===
package com.financial.auth.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/api/auth/login") || path.startsWith("/api/auth/register");
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/security/SecurityConfig.java ===
package com.financial.auth.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated());
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// === ARCHIVO: src/main/java/com/financial/auth/infrastructure/config/OpenApiConfig.java ===
package com.financial.auth.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Autenticación Financiera")
                .version("1.0")
                .description("Servicio de autenticación para la plataforma financiera"))
            .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
            .components(new Components()
                .addSecuritySchemes("Bearer Authentication",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("Token JWT de autenticación")));
    }
}

// === ARCHIVO: src/test/java/com/financial/auth/infrastructure/controllers/AuthControllerTest.java ===
package com.financial.auth.infrastructure.controllers;

import com.financial.auth.application.usecases.AuthUseCase;
import com.financial.auth.domain.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@Disabled("Superficie de práctica - implementar casos de prueba")
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthUseCase authUseCase;

    @Test
    void shouldReturnOkWhenCredentialsAreValid() throws Exception {
        User mockUser = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(authUseCase.authenticate(anyString(), anyString())).thenReturn(mockUser);

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "username": "testuser",
                        "password": "password123"
                    }
                    """))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void shouldReturnUnauthorizedWhenCredentialsAreInvalid() throws Exception {
        when(authUseCase.authenticate(anyString(), anyString()))
            .thenThrow(new RuntimeException("Invalid credentials"));

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "username": "wronguser",
                        "password": "wrongpassword"
                    }
                    """))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldReturnBadRequestWhenUsernameIsMissing() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "password": "password123"
                    }
                    """))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenPasswordIsMissing() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "username": "testuser"
                    }
                    """))
            .andExpect(status().isBadRequest());
    }
}

// === ARCHIVO: src/test/java/com/financial/auth/infrastructure/security/JwtTokenUtilTest.java ===
package com.financial.auth.infrastructure.security;

import com.financial.auth.domain.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Disabled("Superficie de práctica - implementar casos de prueba")
class JwtTokenUtilTest {

    @InjectMocks
    private JwtTokenUtil jwtTokenUtil;

    @Mock
    private User mockUser;

    @Test
    void shouldGenerateTokenWithCorrectClaims() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void shouldExtractUsernameFromToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);
        String extractedUsername = jwtTokenUtil.extractUsername(token);

        assertEquals("testuser", extractedUsername);
    }

    @Test
    void shouldExtractUserIdFromToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);
        UUID extractedUserId = jwtTokenUtil.extractUserId(token);

        assertEquals(userId, extractedUserId);
    }

    @Test
    void shouldReturnTrueForValidToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        String token = jwtTokenUtil.generateToken(mockUser);
        boolean isValid = jwtTokenUtil.validateToken(token, mockUser);

        assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseForInvalidToken() {
        when(mockUser.getId()).thenReturn(UUID.randomUUID());
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("USER");

        boolean isValid = jwtTokenUtil.validateToken("invalid.token.here", mockUser);

        assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseForExpiredToken() {
        // TODO: Implementar test de token expirado
        // Pista: configurar JwtTokenUtil con clock skew o manipular el tiempo
    }

    @Test
    void shouldExtractRoleFromToken() {
        UUID userId = UUID.randomUUID();
        when(mockUser.getId()).thenReturn(userId);
        when(mockUser.getUsername()).thenReturn("testuser");
        when(mockUser.getRole()).thenReturn("ADMIN");

        String token = jwtTokenUtil.generateToken(mockUser);
        String role = jwtTokenUtil.extractRole(token);

        assertEquals("ADMIN", role);
    }
}

// === ARCHIVO: src/test/java/com/financial/auth/application/usecases/AuthUseCaseTest.java ===
package com.financial.auth.application.usecases;

import com.financial.auth.domain.model.User;
import com.financial.auth.domain.ports.AuthServicePort;
import com.financial.auth.domain.ports.UserRepositoryPort;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Disabled("Superficie de práctica - implementar casos de prueba")
class AuthUseCaseTest {

    @InjectMocks
    private AuthUseCase authUseCase;

    @Mock
    private UserRepositoryPort userRepository;

    @Mock
    private AuthServicePort authService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldAuthenticateSuccessfullyWithValidCredentials() {
        User user = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password123", "encodedPassword")).thenReturn(true);
        when(authService.generateToken(user)).thenReturn("jwt-token");

        User result = authUseCase.authenticate("testuser", "password123");

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(authService).generateToken(user);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findByUsername("nonexistent")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
            authUseCase.authenticate("nonexistent", "password123")
        );
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsIncorrect() {
        User user = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpassword", "encodedPassword")).thenReturn(false);

        assertThrows(RuntimeException.class, () ->
            authUseCase.authenticate("testuser", "wrongpassword")
        );
    }

    @Test
    void shouldRegisterNewUserSuccessfully() {
        when(userRepository.findByUsername("newuser")).thenReturn(Optional.empty());
        when(userRepository.findByEmail("new@example.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(authService.generateToken(any(User.class))).thenReturn("jwt-token");

        User result = authUseCase.register("newuser", "new@example.com", "password123");

        assertNotNull(result);
        assertEquals("newuser", result.getUsername());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void shouldThrowExceptionWhenUsernameAlreadyExists() {
        User existingUser = new User(
            UUID.randomUUID(),
            "existinguser",
            "existing@example.com",
            "encodedPassword",
            "USER"
        );
        when(userRepository.findByUsername("existinguser")).thenReturn(Optional.of(existingUser));

        assertThrows(RuntimeException.class, () ->
            authUseCase.register("existinguser", "new@example.com", "password123")
        );
    }

    @Test
    void shouldValidateTokenSuccessfully() {
        User user = new User(
            UUID.randomUUID(),
            "testuser",
            "test@example.com",
            "encodedPassword",
            "USER"
        );
        when(authService.validateToken("valid-token")).thenReturn(Optional.of(user));

        Optional<User> result = authUseCase.validateToken("valid-token");

        assertTrue(result.isPresent());
        assertEquals("testuser", result.get().getUsername());
    }

    @Test
    void shouldReturnEmptyWhenTokenIsInvalid() {
        when(authService.validateToken("invalid-token")).thenReturn(Optional.empty());

        Optional<User> result = authUseCase.validateToken("invalid-token");

        assertTrue(result.isEmpty());
    }
}
```
