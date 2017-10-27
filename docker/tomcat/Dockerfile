FROM neoramon/java:1.8

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME

ENV TOMCAT_MAJOR 9
ENV TOMCAT_VERSION 9.0.1


ENV TOMCAT_TGZ_URL https://www.apache.org/dyn/closer.cgi?action=download&filename=tomcat/tomcat-$TOMCAT_MAJOR/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz

ENV TOMCAT_ASC_URL https://www.apache.org/dist/tomcat/tomcat-$TOMCAT_MAJOR/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz.asc

RUN wget -O tomcat.tar.gz "$TOMCAT_TGZ_URL"
RUN tar -xvf tomcat.tar.gz --strip-components=1
RUN rm bin/*.bat
RUN rm tomcat.tar.gz*
#RUN apt-get purge -y --auto-remove $nativeBuildDeps

ADD tomcat-users.xml conf/tomcat-users.xml

RUN ls
RUN cat conf/tomcat-users.xml

EXPOSE 8080

CMD ["bin/catalina.sh", "run"]