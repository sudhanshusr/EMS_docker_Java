FROM ubuntu:14.04
MAINTAINER sudhanshusr@cybage.com
RUN apt-get update
RUN apt-get install -y --force-yes openjdk-7-jdk openjdk-7-doc openjdk-7-jre-lib
RUN apt-get install -y --force-yes maven
RUN apt-get install -y tomcat7
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
ENV CATALINA_BASE /var/lib/tomcat7
RUN mkdir /home/sudy
RUN mkdir /root/.m2
ADD . /home/sudy
EXPOSE 8080
RUN chmod +x /home/sudy/run.sh
#CMD ["/home/sudhanshusr/EMS_PUPPET/ems_db/run.sh"]
CMD ["/bin/sh","-c","/home/sudy/run.sh"]
