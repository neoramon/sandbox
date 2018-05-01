#docker run --rm -d -p8080:8080 --name wso2-apim neoramon/wso2-apim:2.2.0
docker run -d --rm -p8080:8080 -p8280:8280 -p8243:8243 -p9763:9763 -p9443:9443 -p9099:9099 -p5672:5672 -p9711:9711 -p9611:9611 -p7711:7711 -p7611:7611 -p10397:10397 --name wso2-apim neoramon/wso2-apim:2.2.0
#docker run --net=host -it --rm -p8080:8080 -p8280:8280 -p8243:8243 -p9763:9763 -p9443:9443 -p9099:9099 -p5672:5672 -p9711:9711 -p9611:9611 -p7711:7711 -p7611:7611 -p10397:10397 --name wso2-apim neoramon/wso2-apim:2.2.0 /bin/bash
docker ps