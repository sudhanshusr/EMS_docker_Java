# EMS Application 


#Steps to run application

1.Execute script DDL.sql (\src\main\resources\DDL.sql)

2.Change jdbc.properties file according to DB (\src\main\webapp\WEB-INF\jdbc.properties)

3.To run selenium tests, change base url in each selenium test according to your application url
	(for selenium tests use firefox version 30\31\32)

Note:This application is deployed to the path http://172.27.59.96:8080/EMS_Hibernate1
	 To change this path provide url in tomcat plugin in pom.xml
	 
Docker:

1. first build the docker file using following command

docker build -t javaimg .

2. Create container using this command

docker run -p 8092:8080 -it javaimg

3. if you have .m2 folder already exist at your docker_host and you want to mount it with container while creating container.

docker run -v /root/.m2:/root.m2 -p 8092:8080 -it javaimg

4. to attach to your running container

docker exec -it {container_id} /bin/bash


