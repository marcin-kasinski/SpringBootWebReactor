#!/bin/bash

#ls -l /
#cat /etc/init.d/filebeat
#/etc/init.d/filebeat start
java -jar -Dspring.profiles.active=$SPRING_PROFILE SpringBootWebReactor-0.0.1-SNAPSHOT.jar
