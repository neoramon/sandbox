docker stop $(docker ps | grep neoramon/redis:3.2.11 | awk '{print $1}')