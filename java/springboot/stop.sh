docker stop $(docker ps | grep neoramon/person:1 | awk '{print $1}')
