# Practicando API URL - Consumo de Servicios REST en Java

Este proyecto en Java implementa un cliente HTTP básico siguiendo la arquitectura MVC (Modelo-Vista) para realizar peticiones `GET` y `POST` a servicios web externos y procesar respuestas en formato JSON.

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje:** Java (JDK 11+)
* **IDE Recomendado:** Apache NetBeans / VS Code / IntelliJ IDEA
* **Librerías:**
  * `java.net.http.HttpClient` (Nativa de Java)
  * `org.json` (`JSONArray`, `JSONObject`) para el parseo de datos

---

## 🚀 Funcionalidades

- **Peticiones HTTP GET:** Consulta datos desde un endpoint REST (`https://jsonplaceholder.typicode.com/posts`) y deserializa el arreglo JSON.
- **Peticiones HTTP POST:** Envía cuerpos de mensaje estructurados en formato JSON configurando las cabeceras `Content-Type: application/json`.
- **Procesamiento de Respuestas:** Extrae e imprime atributos específicos como `id` y `title` de los objetos JSON devueltos.
- **Control de Excepciones:** Manejo preventivo contra referencias nulas y errores de red (`IOException`, `InterruptedException`, `JSONException`).

---

## 📋 Requisitos Previos

1. Tener instalado **Java Development Kit (JDK) 11** o superior.
2. Contar con la librería **`org.json` (`json.jar`)** agregada a las dependencias de tu proyecto.

---

## ⚙️ Instalación y Configuración

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/silvialorenaocampoq-cyber/practicando-apirul.git](https://github.com/silvialorenaocampoq-cyber/practicando-apirul.git)
