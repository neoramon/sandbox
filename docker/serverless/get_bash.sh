docker exec -it $(docker ps | grep neoramon/serverless | awk '{print $1}') bash