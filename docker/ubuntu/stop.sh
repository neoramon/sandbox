docker stop $(docker ps | grep neoramon/ubuntu:16.04 | awk '{print $1}')