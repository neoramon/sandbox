docker ps -a
docker ps -q -a | xargs docker rm

docker images
docker rmi -f $(docker images -q) #-f dangling=true