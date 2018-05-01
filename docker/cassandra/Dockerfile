FROM neoramon/gradle:4.5

RUN wget https://archive.apache.org/dist/cassandra/2.1.19/apache-cassandra-2.1.19-bin.tar.gz
RUN tar -xzvf apache-cassandra-2.1.19-bin.tar.gz
RUN rm -rf apache-cassandra-2.1.19-bin.tar.gz
RUN mv apache-cassandra-2.1.19/ /opt/cassandra/
ENV CASSANDRA_HOME /opt/cassandra

ENV PATH="${CASSANDRA_HOME}/bin:${PATH}"
RUN apt-get update
RUN apt-get install -y python-software-properties

ADD config/cassandra.yaml /opt/cassandra/conf/cassandra.yaml
ADD scripts/start-cass.sh /opt/cassandra/bin/

EXPOSE 9160
EXPOSE 9042
EXPOSE 7199

CMD start-cass.sh