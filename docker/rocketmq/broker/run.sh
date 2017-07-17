docker run --rm -d -p 10911:10911 -p 10909:10909 --name rmqbroker neoramon/rocketmq-broker:4.1.0-incubating bin/mqbroker -c config-a.properties
docker ps