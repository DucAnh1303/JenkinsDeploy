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
               sh './gradlew clean'
           }
        }
        stage('Build Docker Image') {
            steps {
              withDockerRegistry(credentialsId: 'dockerhub',url: 'https://github.com/DucAnh1303/JenkinsDeploy.git') {
              					sh 'docker build -t ducanh1398/jenkins:jenkins .'
              					sh 'docker push ducanh1398/jenkins:jenkins'
             }
            }
        }
        stage('Run Docker Image') {
            steps {
                 script {
                       echo 'Deploying and running Docker container'
                       // Chạy Docker container, ánh xạ cổng 9091 tới cổng 8080 của container
                       sh 'docker run -d --rm --name ducanh-jenkins -p 9091:8080 ducanh1398/jenkins:jenkins'
                   }
            }
        }
    }
    post {
        always{
               clearWs()
            }
    }
}
