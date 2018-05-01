#!/bin/bash

IFS=. read ip1 ip2 ip3 ip4 <<< "$(hostname -i)"

seeds="$ip1.$ip2.$ip3.1"

for i in `seq 2 254`;
do
    seeds="$seeds,$ip1.$ip2.$ip3.$i"
done

sed -i s/@SEEDS/$seeds/g /opt/cassandra/conf/cassandra.yaml

sed -i s/@HOST/$(hostname -i)/g /opt/cassandra/conf/cassandra.yaml

cassandra > /workspace/logs/cassandra.out &