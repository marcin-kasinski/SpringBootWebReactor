FROM openjdk:9
MAINTAINER Marcin Kasiński <marcin.kasinski@gmail.com> 



RUN mkdir /usr/src/myapp
RUN mkdir /usr/src/myapp/logs
RUN touch /usr/src/myapp/logs/application.log


ADD start.sh /usr/src/myapp/start.sh
RUN sed -i -e 's/\r//g' /usr/src/myapp/start.sh

COPY SpringBootWebReactor-0.0.1-SNAPSHOT.jar /usr/src/myapp/SpringBootWebReactor-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/myapp
#CMD /etc/init.d/filebeat start && java -jar SpringBootWeb-0.0.1-SNAPSHOT.jar
#CMD ls -l /
#CMD wget -O https://artifacts.elastic.co/downloads/beats/filebeat/${FILEBEAT_VERSION} 
#CMD cat /filebeat_5.5.2_amd64.deb
#CMD /etc/init.d/filebeat start 
EXPOSE 9191


RUN chmod +x /usr/src/myapp/start.sh
ENTRYPOINT [ "/usr/src/myapp/start.sh" ]