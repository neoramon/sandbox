FROM neoramon/java:1.8

#RUN wget -O wso2am-2.2.0.zip --user user --password pass https://product-dist.wso2.com/products/api-manager/2.2.0/wso2am-2.2.0.zip

ADD wso2am-2.2.0.zip wso2am-2.2.0.zip

RUN unzip wso2am-2.2.0.zip

RUN ls -lha wso2am-2.2.0

RUN pwd

# expose ports
EXPOSE 8280 8243 9763 9443 9099 5672 9711 9611 7711 7611 10397

ENTRYPOINT /data/wso2am-2.2.0/bin/wso2server.sh
