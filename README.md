# spring-data-jpa
En este proyecto vamos a agregar el uso de persistencia (SPRING-DATA-JPA) al proyecto de pedidos de pizza


**Vamos a trabajar con SPRING-DATA-JPA y a grandes rasgos vamos a realizar los siguientes pasos:**

<ol>
	<li>Agregar la dependencia de JPA al proyecto</li>
	<li>Remover la dependencia de DATA-JDBC, ya no la vamos a necesitar</li>
	<li>Revisar los objetos del dominio y cambiar las anotaciones para JPA</li>
	<li>Vamos a borrar el archivo schema.sql y dejaremos que JPA cree su propio schema</li>
	<li>Levantar el proyecto y fijarse en la estructura de tablas, que creo JPA</li>
</ol>


1 - Debemos agregar en el pom.xml las siguientes dependencias:

```xml
<dependency> 
	<groupId>org.springframework.boot</groupId> 
	<artifactId>spring-boot-starter-data-jpa</artifactId>
 </dependency>
```

Por defecto el provider es hibernate. Si quisieramos cambiar esto y pasar por ejemplo a eclipselink debemos hacer lo siguiente:

```xml
<dependency> 
	<groupId>org.springframework.boot</groupId> 
	<artifactId>spring-boot-starter-data-jpa</artifactId> 
	<exclusions>
	    <exclusion>
	        <groupId>org.hibernate</groupId>
	        <artifactId>hibernate-core</artifactId>
	    </exclusion>
  </exclusions>
</dependency>

<dependency>
	<groupId>org.eclipse.persistence</groupId> 
	<artifactId>org.eclipse.persistence.jpa</artifactId> 
	<version>2.7.6</version>
</dependency>
```

2 - Remover la dependencia de DATA-JDBC

Vamos a remover la siguiente dependencia:

```xml
<!-- Dependencia para usar DATA-JDBC -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>

```

Mantenderemos la dependencia de H2, ya que vamos a necesitar el motor de BD:

```xml
<!-- Dependecia para utilizar el DBMS H2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

**NOTAS**

- Artículo de stakoverflow con detalle de los diferentes tipos de Repository de spring-data

> [https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring](https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring)

> La respuesta la da Oliver Drotbohm (Project Lead de Srping-Data) [https://spring.io/team/odrotbohm](https://spring.io/team/odrotbohm)

- Este otro artículo muestra como configurar Spring con JPA (Con base de datos embebidas y con Mysql) utilizando Spring-Boot o solo Spring

> [https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa](https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa)

- Documentación oficial de spring-data

> [https://docs.spring.io/spring-data/jpa/docs/current/reference/html/](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
