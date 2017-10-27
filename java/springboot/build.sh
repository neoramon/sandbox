mvn -f pom.xml clean package -DskipTests
docker build -t  neoramon/person:1 .
