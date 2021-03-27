# Ensialligence: Science-Oriented Social Media

This project is an attempt to create a social network geared toward sharing knowledge and research with JEE toolsets.

## Introduction

This repository contains our Java EE project which
main aim was to put into practice the skills and the knowledge we acquired in terms of web development and
software engineering during our 2nd year at ENSIAS.

Concerning the subject, we chose to make an attempt to create a science-oriented social network geared
toward sharing knowledge and research.

It was first necessary to apply the fundamental phases in most, if not all, web and mobile engineering
methodologies. Starting by the analysis, we established our specifications. Then came conception phase through
UML diagrams which allowed us to structure the business layer of the application. Based on the previous
steps, we developped a prototype according to the needs. In the following implementation phase, system unit
components were built effectively with respect to quality, performance, baselines, libraries, and debugging issues,
to finally be able to carry out the necessary tests.

## Technologies Used

- JavaEE (Java Enterprise Edition) - Maven - JDBC - JAX-RS
- React
- JUnit
- MySQL
- Docker

## Setting up the Project locally

### Clone Project

    git clone https://github.com/Ignema/ensialligence.git

### Install [Docker](https://www.docker.com/products/docker-desktop)

### Run project

#### 1st Method (Production) : Build the necessary containers

    docker-compose -p ensialligence up

#### 2st Method (Development)

##### Frontend

###### Install dependencies

    npm install

###### Running the react application

    npm start

##### Backend

###### Set up a mySQL database on port 3306

###### Set up a server like tomcat and then run the backend on port 8080

## Remarks

- We still need to connect the backend with the frontend
- You can also run tests with JUnit

This project still needs to be revisited but we're happy with the results we achieved. Here are some screenshots:

### Login Page

![Login Page](https://i.postimg.cc/yNwxXnSf/Whats-App-Image-2021-03-27-at-11-24-11-PM.jpg)

### Home Page

#### Main Interface

![Main Interface](https://i.postimg.cc/ZRpRf38J/Whats-App-Image-2021-03-27-at-11-24-10-PM.jpg)

#### Shortcut Interface

![Shortcut Interface](https://i.postimg.cc/VvzYDhsF/Whats-App-Image-2021-03-27-at-11-24-29-PM.jpg)

#### Adding a Friend Interface

![Friend Interface](https://i.postimg.cc/sgHv13fC/Whats-App-Image-2021-03-27-at-11-23-49-PM.jpg)

#### Creating Posts

##### Writing Post

![Writing Post](https://i.postimg.cc/8CrP5WnL/Whats-App-Image-2021-03-27-at-11-24-39-PM-1.jpg)

##### Created Post

![Post Created](https://i.postimg.cc/pVBVpPkc/Whats-App-Image-2021-03-27-at-11-24-39-PM.jpg)

#### Posts

##### Post

![Post](https://i.postimg.cc/C54K0grt/Whats-App-Image-2021-03-27-at-11-24-38-PM-1.jpg)

##### Exploded Post

![Exploded Post](https://i.postimg.cc/P5J5g0W3/Whats-App-Image-2021-03-27-at-11-24-38-PM.jpg)

##### Writing Comment

![Writing Comment](https://i.postimg.cc/4dk4hdrq/Whats-App-Image-2021-03-27-at-11-24-39-PM-2.jpg)

##### Comment

![Comment](https://i.postimg.cc/wMF9Pk7Y/Whats-App-Image-2021-03-27-at-11-24-40-PM.jpg)

##### Post with Comment

![Post with Comment](https://i.postimg.cc/GhQBwkZ2/Whats-App-Image-2021-03-27-at-11-24-11-PM-1.jpg)

#### Search

![Search](https://i.postimg.cc/5yJtD0gL/Whats-App-Image-2021-03-27-at-11-24-35-PM.jpg)

#### Alerts

![Alerts](https://i.postimg.cc/x8GXdH86/Whats-App-Image-2021-03-27-at-11-23-40-PM.jpg)

### Discover Page

![Discover Page](https://i.postimg.cc/pLSLRkk2/Whats-App-Image-2021-03-27-at-11-24-08-PM.jpg)

### Stories Page

![Stories Page](https://i.postimg.cc/3JJ8Gzc8/Whats-App-Image-2021-03-27-at-11-24-30-PM.jpg)

### Chat Page

![Chat Page](https://i.postimg.cc/6qx7wzW7/Whats-App-Image-2021-03-27-at-11-23-34-PM.jpg)

### Profile

#### Profile Dropdown

![Profile Dropdown](https://i.postimg.cc/3xxkKkTZ/Whats-App-Image-2021-03-27-at-11-24-12-PM.jpg)

#### Profile Page

![Profile Page](https://i.postimg.cc/028Qfzbq/Whats-App-Image-2021-03-27-at-11-24-13-PM.jpg)
