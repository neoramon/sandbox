FROM neoramon/java:8

# Rocketmq version
ENV ROCKETMQ_VERSION 4.1.0-incubating

# Rocketmq home
ENV ROCKETMQ_HOME  /opt/rocketmq-${ROCKETMQ_VERSION}

WORKDIR  ${ROCKETMQ_HOME}

RUN mkdir -p \
		/opt/logs \
		/opt/store

RUN curl https://dist.apache.org/repos/dist/release/incubator/rocketmq/${ROCKETMQ_VERSION}/rocketmq-all-${ROCKETMQ_VERSION}-bin-release.zip -o rocketmq.zip
RUN unzip rocketmq.zip
RUN mv rocketmq-all-$ROCKETMQ_VERSION/* .
RUN rmdir rocketmq-all-$ROCKETMQ_VERSION
RUN rm rocketmq.zip

ADD bin/runserver.sh bin/

RUN chmod +x bin/mqnamesrv

ENV JAVA_OPT " -Duser.home=/opt"


EXPOSE 9876
VOLUME /opt/logs \
		/opt/store