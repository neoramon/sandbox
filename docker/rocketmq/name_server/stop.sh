docker stop $(docker ps | grep neoramon/rocketmq-name-server:4.1.0-incubating | awk '{print $1}')
docker rm $(docker ps | grep neoramon/rocketmq-name-server:4.1.0-incubating | awk '{print $1}')