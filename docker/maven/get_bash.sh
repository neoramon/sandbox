docker exec -it $(docker ps | grep neoramon/maven:3.5.0 | awk '{print $1}') bash