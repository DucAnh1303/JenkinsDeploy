pipeline {
    agent any

    tools{
        gradle 'jenkins'
    }

    stages {
        stage('build') {
            steps {
                sh './gradlew --version'
                sh 'java --version'
                sh './gradlew clean build'
            }
        }
        stage('Build Docker Image') {
            steps {
              withDockerRegistry(credentialsId: 'RunDockerImage',url:'https://index.docker.io/v1/') {
              					sh 'docker build -t ducanh1398/jenkins:jenkins .'
              					sh 'docker push ducanh1398/jenkins:jenkins'
             }
            }
        }
        stage('Run Docker Image') {
            steps {
                script {
                   echo 'Deploying and cleaning'
                   sh 'docker container run -d --rm --name ducanh-jenkins -p 8081:8080 ducanh1398/jenkins:jenkins'
                }
            }
        }
    }
}
