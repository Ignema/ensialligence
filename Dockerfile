FROM tomcat:latest

RUN apt update
RUN apt install -y sudo
RUN sudo apt install -y nodejs

WORKDIR /app
COPY package*.json ./

RUN npm install

COPY . .

RUN npm install -g serve
RUN npm build
RUN serve -s build

COPY target/Ensialligence-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

ENV PORT=8080

EXPOSE 8080

CMD ["catalina.sh", "run"]
