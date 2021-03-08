FROM node:latest

# RUN apt update
# RUN apt install -y sudo
# RUN sudo apt install -y nodejs
# RUN sudo apt install -y npm
# RUN npm install npm@latest -g

WORKDIR /app
COPY package*.json ./

RUN npm install

COPY . .

RUN npm install -g serve
RUN npm build

CMD ["serve", "-s", "build"]
