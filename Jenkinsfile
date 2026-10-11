
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


stage('Check Docker Access') {
    steps {
        bat 'whoami'
        bat 'dir "C:\\Users\\iamth\\AppData\\Local\\Programs\\Docker\\Docker\\resources\\bin\\docker.exe"'
    }
}
      
stage('Docker Build') {
    steps {
        bat '"C:\\Users\\iamth\\AppData\\Local\\Programs\\Docker\\Docker\\resources\\bin\\docker.exe" build -t java-addition:latest .'
    }
}

stage('Docker Run') {
    steps {
        bat '"C:\\Users\\iamth\\AppData\\Local\\Programs\\Docker\\Docker\\resources\\bin\\docker.exe" run --rm java-addition:latest'
    }
}

    }

    post {
        success {
            echo 'Java Addition pipeline with Docker completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
