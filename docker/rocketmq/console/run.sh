#docker run --rm --name rmqconsole -e "JAVA_OPTS=-Drocketmq.namesrv.addr=172.17.0.2:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" -e  NAMESRV_ADDR='172.17.0.2:9876' -p 8081:8080 -t styletang/rocketmq-console-ng

docker run --rm --name rmqconsole -e "JAVA_OPTS=-Drocketmq.namesrv.addr=172.17.0.2:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" -e  NAMESRV_ADDR='172.17.0.2:9876' -p 8081:8080 -t neoramon/rocketmq-console-ng:1 java -jar rocketmq-console-ng-1.0.0.jar


docker  ps
echo "USE 8081!!!"
