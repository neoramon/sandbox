docker run --rm -d --name jenkins -p 49001:8080 -v $PWD/jenkins:/var/jenkins_home:z -t jenkins
docker ps