docker exec -it $(docker ps | grep neoramon/person:1 | awk '{print $1}') bash
