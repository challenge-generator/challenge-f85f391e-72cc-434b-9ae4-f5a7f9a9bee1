# Implementación de Autenticación Segura y Legible

Como especialista en backend con experiencia en Java, debes implementar un mecanismo de autenticación seguro y legible para un sistema de gestión de usuarios en una plataforma financiera. El sistema requiere autenticación basada en JWT para asegurar que solo usuarios autorizados puedan acceder a los servicios. Debes asegurar que el código sea legible, reutilizable y siga las mejores prácticas de seguridad.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 2 semanas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Diseño del Mecanismo de Autenticación

**Objetivo:** Definir la estructura y los componentes necesarios para implementar la autenticación basada en JWT.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Identificar los actores involucrados en el proceso de autenticación (usuario, servicio de autenticación, sistema de gestión de usuarios).
- Establecer los criterios de aceptación para la fase: definición clara de los componentes y sus responsabilidades.

**Entregable:** Diagrama de relaciones que muestra los componentes y sus interacciones en el proceso de autenticación.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las mejores prácticas para la legibilidad y reutilización del código.
- Piensa en los posibles puntos de falla y cómo mitigarlos.

</details>

### Fase 2: Implementación del Servicio de Autenticación

**Objetivo:** Crear el servicio de autenticación que genere y valide tokens JWT.

**Tiempo estimado:** 5 días

**Instrucciones:**

- Implementa el servicio de autenticación que genere tokens JWT al recibir credenciales válidas.
- Asegura que el servicio valide los tokens JWT recibidos en las solicitudes.
- Establece los criterios de aceptación para la fase: servicio funcional que genere y valide tokens JWT.

**Entregable:** Servicio de autenticación que genera y valida tokens JWT.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la seguridad de las credenciales y la validación de los tokens.
- Piensa en cómo manejar errores de autenticación.

</details>

### Fase 3: Integración con el Sistema de Gestión de Usuarios

**Objetivo:** Integrar el servicio de autenticación con el sistema de gestión de usuarios.

**Tiempo estimado:** 4 días

**Instrucciones:**

- Integra el servicio de autenticación con el sistema de gestión de usuarios para que solo usuarios autenticados puedan acceder a los servicios.
- Establece los criterios de aceptación para la fase: integración funcional y segura del servicio de autenticación con el sistema de gestión de usuarios.

**Entregable:** Sistema de gestión de usuarios que utiliza el servicio de autenticación para controlar el acceso.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la consistencia y la disponibilidad del sistema.
- Piensa en cómo manejar casos de edge y errores de integración.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un token JWT y para qué se utiliza en la autenticación?
- **paraQueSirve**: ¿Para qué sirve integrar el servicio de autenticación con el sistema de gestión de usuarios?
- **comoSeUsa**: ¿Cómo se utiliza un token JWT para autenticar a un usuario?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar un servicio de autenticación y cómo se pueden mitigar?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de un servicio de autenticación seguro y legible?

## Criterios de Evaluacion

- Definición clara de los componentes y sus responsabilidades en el proceso de autenticación.
- Implementación funcional y segura del servicio de autenticación que genera y valida tokens JWT.
- Integración exitosa del servicio de autenticación con el sistema de gestión de usuarios.
- Consideración de la legibilidad y reutilización del código en la implementación.
- Mitigación de errores comunes y manejo de casos de edge en la implementación.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
