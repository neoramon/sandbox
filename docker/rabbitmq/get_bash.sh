docker exec -it $(docker ps | grep neoramon/rabbitmq:3.6.10 | awk '{print $1}') bash