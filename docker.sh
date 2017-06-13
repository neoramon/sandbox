#!/usr/bin/env bash
sudo apt-get remove docker docker-engine

sudo apt-get install \
    linux-image-extra-$(uname -r) \
    linux-image-extra-virtual


sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common


curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -


#sudo add-apt-repository \
#   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
#   $(lsb_release -cs) \
#   stable"

sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   xenial \
   stable"

sudo apt-get update


sudo apt-get install docker-ce


sudo docker run hello-world

sudo gpasswd -a $USER docker