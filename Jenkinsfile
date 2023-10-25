pipeline {
    agent any
  
    stages {
        stage("Build") {
            steps {
                echo "Building the back end app..."
                sh 'mvn clean install'
            }
        }
         stage("SonarQube analysis") {
            steps {
                echo "test statique"
                 sh 'mvn sonar:sonar'
            }
        }
        stage("Test unitaire") {
            steps {
                echo "Testing the backend app ..."
                sh 'mvn test'
            }
        }
         stage("Build Docker Image ") {
            steps {
                    echo "building docker image"
                    sh "docker build -t rawaablh/devops-back:${BUILD_NUMBER} ."
            }
        }
         stage("Push to Docker") {
            steps {
               // withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PWD')]) {
                    script {
                        sh "docker login -u $DOCKER_USER -p $DOCKER_PWD"
                        sh "docker push rawaablh/devops-back:${BUILD_NUMBER} "
                    }
                }
            }
         //}
        stage("Nexus Deploy") {
            steps {
                echo "Deploying the backend app..."
                sh 'mvn deploy'
            }
        }
    }
}
