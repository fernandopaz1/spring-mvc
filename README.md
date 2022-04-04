# Spring MVC

Srping MVC es un framework para construir web aplications en java basado en el patron modelo-vista-controlador y aprovecha features del framework spring core (IoC, DI)

Los componentes de spring MVC son: Un conjunto de templates de paginas webs, un conjunto de beans de spring (controllers, services, etc...) y la configuración de spring (XML, Annotations o Java)

<p align="center">
  <img src="https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/images/mvc.png" />
</p>

Dentro del flujo de spring MVC hay tres etapas: El front controller, el controller y el view template.

- Front Controller (también conocido como **DispatcherServlet**): Es parte del spring framework, es decir desarrollado por el equipo de spring, no es necesario que lo creemos. Lo que hace es delegar la request hacia otros controles.

* Lo que desarrollamos en realidad es
  - Model Objects: Contienen los datos modelados como objetos.
  - View Templates: son las paginas de JSP que usamos para renderizar los datos en una vista.
  - Controller Classes: Lógica de negocio.

### Controller

Cuando llega una request el Front controller delega la request al controller.
Este contiene la lógica de negocio: maneja las request, guarda y obtiene datos (db, servicios web) y ubica los datos en los modelos.

### Model

Los modelos contienen los datos en forma de objetos. Se encargan de almacenar y obtener datos mediante el backend

### View Template

Los view templates mas comunes son **JSP** (Java Server Pages) y **JSTL** (JSP Standard Tag Library), se encarga de leer los datos de los modelos y mostrarlos en una vista.

# Configuración

Una vez creado un proyecto de spring MVC (desde elipse es Dynamic Web Project) debemos configurar el contenido del archivo `WEB-INF/web.xmml`. Aca va la configuración del MVC dispatcher servlet y los mappings entre URLS y el MVC dispatcher servlet.

<details>
 <summary>WEB-INF/web.xmml</summary>
```
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	id="WebApp_ID" version="3.1">

    <display-name>spring-mvc-demo</display-name>

    <absolute-ordering />

    <!-- Spring MVC Configs -->

    <!-- Step 1: Configure Spring MVC Dispatcher Servlet -->
    <servlet>
    	<servlet-name>dispatcher</servlet-name>
    	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    	<init-param>
    		<param-name>contextConfigLocation</param-name>
    		<param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
    	</init-param>
    	<load-on-startup>1</load-on-startup>
    </servlet>

    <!-- Step 2: Set up URL mapping for Spring MVC Dispatcher Servlet -->
    <servlet-mapping>
    	<servlet-name>dispatcher</servlet-name>
    	<url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>
```
 </details>

También es necesario modificar `WEB-INF/spring-mvc-demo-servlet.xml` (notar que este archivo se llama como el proyecto y finaliza con `-servlet.xml`). Aca agregamos soporte para el component scanning, soporte para conversiones, formateos y validaciones y configuramos el soporte para spring MVC View Resolver

<details>
 <summary>WEB-INF/spring-mvc-demo-servlet.xml</summary>
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
    	http://www.springframework.org/schema/beans/spring-beans.xsd
    	http://www.springframework.org/schema/context
    	http://www.springframework.org/schema/context/spring-context.xsd
    	http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- Step 3: Add support for component scanning -->
    <context:component-scan base-package="com.luv2code.springdemo" />

    <!-- Step 4: Add support for conversion, formatting and validation support -->
    <mvc:annotation-driven/>

    <!-- Step 5: Define Spring MVC view resolver -->
    <bean
    	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<property name="prefix" value="/WEB-INF/view/" />
    	<property name="suffix" value=".jsp" />
    </bean>

</beans>
```
 </details>

# Spring Controles y Vistas

La idea aca es definir una clase controller con sus métodos, agregarle un mapping entre los request al método del controller y finalmente devolver la vista.

## Controller

Para crear la clase controller creamos una clase y le añadimos la annotation `@Controller`. Esta annotation hereda de `@Component` por lo que soporta scanning.

```
@Controller
public class HomeController{

}
```

El método que retorne en un principio puede ser un método que devuelva un string que podría representar el nombre de la view.
Para hacer el mapping tenemos que agregar la annotation `@RequestMapping` pasando como parámetro la url a la cual queremos mapear.

```
@RequestMapping("/")
public String ShowMyPage(){
    return "main-menu";
}
```

En el archivo `WEB-INF/spring-mvc-demo-servlet.xml` definimos un resolvedor de nombres que dado un string agrega lo necesario para encontrar el path de una view

```
 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    	<property name="prefix" value="/WEB-INF/view/" />
    	<property name="suffix" value=".jsp" />
    </bean>
```

Esto toma el nombre de una view y agrega el prefix de `/WEB-INF/view/` y el suffix de `.jsp`, por lo que en la url `/` mediante la función ShowMyPage del controller se devolverá la vista `/WEB-INF/view/main-menu.jsp`
