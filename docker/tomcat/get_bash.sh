docker exec -it $(docker ps | grep neoramon/tomcat:9 | awk '{print $1}') bash