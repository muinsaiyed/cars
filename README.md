# Car Dealership App


## Description
This application is created using Springboot, MYSQL and Docker to containerize the app. This app will launch locally on port 8085. In order to launch the application, Docker must be installed.

## API Information
There are two endpoints /cars and /cars/{id}. The id will be an integer from 1-4 to pull information back. 

The two endpoints to test are:
localhost:8085/cars, 
localhost:8085/cars/{id}


## Unit Testing
There are three small unit tests which will test the endpoints with one negative test.

## Launch Instructions
1. Navigate to your app directory

2. Run Docker build using the following command:
`make build`

3. Run Application Locally using the following command: 
`make local-dev`

4. If you want to stop the application: 
`make local-dev-down`

IF MAKE FILE DOESN'T WORK:
1. `docker build -t car-dealership .`
2. `docker-compose up`