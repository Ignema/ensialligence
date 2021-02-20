FROM tomcat:latest

# RUN adduser tomcat; chown -R tomcat:tomcat /usr/local/tomcat

# USER tomcat
COPY target/Ensialligence-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]

