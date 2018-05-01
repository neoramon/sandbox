docker network create --subnet=178.18.0.0/16 cassandra_net
docker run --net cassandra_net -it --rm -v ~/workspace/:/workspace/ neoramon/cassandra:2.1.19 /bin/bash