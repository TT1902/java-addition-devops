
pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Prepare Dockerfile') {
            steps {
                writeFile file: 'Dockerfile', text: '''FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/java-addition-1.0.0.jar app.jar
CMD ["java", "-cp", "app.jar", "Addition"]
'''
                bat 'dir Dockerfile'
            }
        }

        stage('Docker Build') {
            steps {
                bat '"C:\\Users\\iamth\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" build -t java-addition:latest .'
            }
        }

        stage('Docker Run') {
            steps {
                bat '"C:\\Users\\iamth\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" run --rm java-addition:latest'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Java tests, packaging, Docker build and Docker run completed!'
        }
        failure {
            echo 'Pipeline failed. Check the first error in Console Output.'
        }
    }
}
