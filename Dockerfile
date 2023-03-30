FROM amd64/openjdk:19
ARG JAR_FILE=app/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "net.artux.template.TemplateApplication"]