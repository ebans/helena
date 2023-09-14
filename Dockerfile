FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY . .
#RUN mvn install

# Utiliza la imagen base de Wildfly
FROM jboss/wildfly:25.0.0.Final

# Copia el archivo WAR de la aplicación en el directorio de despliegue de Wildfly
# COPY target/login-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

COPY /target/login-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
COPY standalone.conf /opt/jboss/wildfly/bin/
#COPY GestionOrdenes-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
#COPY Historicos-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
#COPY Maestros-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/
#COPY mgmt-users.properties /opt/jboss/wildfly/standalone/configuration/


# Ejecuta Wildfly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]

# Archivo para variables de entorno
#COPY env-vars.env /ruta
#ENV $(cat /ruta/env-vars.env | xargs)

#VAR1=valor1
#VAR2=vakor2





