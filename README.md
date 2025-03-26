<h1>NutriMarketAPI</h1>
    <p>NutriMarketAPI es una API REST desarrollada en Java utilizando Spring Boot y JPA. Esta API sirve como conector entre la base de datos y una aplicación web de la empresa <b><i>NutriMarket</i></b>, permitiendo gestionar clientes, productos, carritos personales y el contenido de los carritos.</p>
    <h2>Uso de la API</h2>
    <p>Si estás interesado en ver cómo se utiliza esta API en un proyecto real, puedes consultar el repositorio <a href="https://github.com/lucas-the-wise-dreams/nutriMarket">NutriMarket</a> donde se implementa la API.</p>
    <h2>✔️Tecnologías Utilizadas</h2>
    <ul>
        <li>Java</li>
        <li>Spring Boot</li>
        <li>Spring Data JPA</li>
        <li>MySQL</li>
        <li>Maven</li>
    </ul>
    <h2>Funcionalidades</h2>
    <p>La API proporciona las siguientes funcionalidades:</p>
    <ul>
        <li><b>Usuarios:</b>
            <ul>
                <li>Administradores:
                    <ul>
                        <li>Crear, buscar, actualizar y eliminar todas las entidades.</li>
                    </ul>
                </li>
                <li>Clientes:
                    <ul>
                        <li>Crear cuenta, buscar productos, editar perfil y eliminar cuenta.</li>
                        <li>Autenticación de cliente.</li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><b>Productos:</b>
            <ul>
                <li>Consultar y gestionar productos disponibles.</li>
                <li>Crear, buscar, actualizar y eliminar productos.</li>
            </ul>
        </li>
        <li><b>Carritos Personales:</b>
            <ul>
                <li>Crear y gestionar carritos de compra para los clientes.</li>
                <li>Añadir y eliminar productos en el carrito.</li>
            </ul>
        </li>
        <li><b>Contenido de los Carritos:</b>
            <ul>
                <li>Consultar el contenido del carrito de un cliente.</li>
                <li>Actualizar la cantidad de productos en el carrito.</li>
            </ul>
        </li>
    </ul>
    <h2>Instalación</h2>
    <p>Sigue estos pasos para instalar y ejecutar la API en tu entorno local.</p>
    <h3>Prerrequisitos</h3>
    <ul>
        <li>JDK 17 o superior (JDK 21, recomendado)</li>
        <li>Maven</li>
        <li>MySQL</li>
    </ul>
    <h3>Clonar el repositorio</h3>
    <pre><code>git clone https://github.com/lucas-sanchez-cabrera/NutriMarketAPI.git</code></pre>
    <h3>Navegar al directorio del proyecto</h3>
    <pre><code>cd NutriMarketAPI</code></pre>
    <h3>Configurar la base de datos</h3>
    <ol>
        <li>Crea una base de datos en MySQL.</li>
        <li>Actualiza el archivo <code>src/main/resources/application.yml</code> con la configuración de tu base de datos:</li>
    </ol>
    <pre><code>spring:
  datasource:
    url: jdbc:mysql://localhost:3306/NutriMarket
    username: root
    password: 1234
  jpa:
    database-platform: com.mysql.cj.jdbc.Driver
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        globally_quoted_identifiers: true
        dialect: org.hibernate.dialect.MySQL8Dialect
        format_sql: true
  servlet:
    multipart:
      enabled: true
      max-file-size: 1000MB
      max-request-size: 1000MB
    mvc:
      throw-exception-if-no-handler-found: true
      async:
        request-timeout: 3600000
    thymeleaf:
      prefix: classpath:/templates/
      suffix: .html
      enabled: true
server:
  port: 8080
  error:
    path: /user/error
    whitelabel:
      enabled: false
springdoc:
  swagger-ui:
    operationsSorter: method
</code></pre>
    <h3>Compilar y ejecutar la aplicación</h3>
    <ol>
        <li>Compila la aplicación utilizando Maven:</li>
    </ol>
    <pre><code>mvn clean install
</code></pre>
    <ol start="2">
        <li>Ejecuta la aplicación:</li>
    </ol>
    <pre><code>mvn spring-boot:run
</code></pre>
    <h3>Acceder a la API</h3>
    <p>Una vez que la aplicación se esté ejecutando, puedes acceder a la API en la siguiente URL:</p>
    <p><a href="http://localhost:8080">http://localhost:8080</a></p>
    <h2>Endpoints</h2>
    <p>Para saber los <i>Endpoints</i> que se puede usar, puedes acceder a la documentacion de la API en la siguiente URL:</p>
    <p><a href="http://localhost:8080/swagger-ui/indext.html">http://localhost:8080/swagger-ui/indext.html</a></p>
    <h2>Contribuir</h2>
    <p>Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:</p>
    <ol>
        <li>Haz un fork del repositorio.</li>
        <li>Crea una rama para tu nueva funcionalidad (<code>git checkout -b nueva-funcionalidad</code>).</li>
        <li>Realiza tus cambios y haz commit de los mismos (<code>git commit -am 'Añadir nueva funcionalidad'</code>).</li>
        <li>Sube tus cambios a tu fork (<code>git push origin nueva-funcionalidad</code>).</li>
        <li>Crea un nuevo Pull Request.</li>
    </ol>
