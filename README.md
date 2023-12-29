# Quarkus, Camel, kogito BPMN Running Example for Account Opening BPMN
Kogito BPMN Development Example


# client-enquiry-proxy

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8085/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/client-enquiry-proxy-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Camel CXF ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/cxf-soap.html)): Expose SOAP WebServices using Apache CXF or connect to external WebServices using CXF WS client
- Camel Core ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/core.html)): Camel core functionality and basic Camel languages: Constant, ExchangeProperty, Header, Ref, Simple and Tokenize
- Camel JAXB ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/jaxb.html)): Unmarshal XML payloads to POJOs and back using JAXB2 XML marshalling standard
- Camel Direct ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/direct.html)): Call another endpoint from the same Camel Context synchronously
- Camel SOAP dataformat ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/soap.html)): Marshal Java objects to SOAP messages and back
- Camel Jackson ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/jackson.html)): Marshal POJOs to JSON and back using Jackson
- Camel Servlet ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/servlet.html)): Serve HTTP requests by a Servlet
- Camel Bean ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/bean.html)): Invoke methods of Java beans
- Camel REST OpenApi ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/rest-openapi.html)): Configure REST producers based on an OpenAPI specification document delegating to a component implementing the RestProducerFactory interface
- Camel OpenTelemetry ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/opentelemetry.html)): Distributed tracing using OpenTelemetry
- Camel Log ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/log.html)): Log messages to the underlying logging mechanism
- Camel OpenAPI Java ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/openapi-java.html)): Expose OpenAPI resources defined in Camel REST DSL
- Camel JacksonXML ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/jacksonxml.html)): Unmarshal an XML payloads to POJOs and back using XMLMapper extension of Jackson
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- Camel Rest ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/rest.html)): Expose REST services and their OpenAPI Specification or call external REST services
