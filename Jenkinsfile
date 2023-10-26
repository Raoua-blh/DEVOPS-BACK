pipeline {
    agent any
  
    stages {
        stage("Build") {
            steps {
                echo "Building the back end app..."
                sh 'mvn clean install'
            }
        }
     /*      stage("SonarQube analysis") {
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
         //}*/
 /*  stage("Docker Compose") {
            steps {
                echo "Docker compose"
                sh 'docker compose up -d '
            }
        }*/
        
      /*  stage("Nexus Deploy") {
            steps {
                echo "Deploying the backend app..."
                sh 'mvn deploy'
            }
        }*/

        stage('Récupération du code front ') {
            steps {
                git(
                    url: 'https://github.com/Raoua-blh/DEVOPS-FRONT.git'
                )
            }
        }
         stage("Build Docker Image front ") {
            steps {
                    echo "building docker image"
                    sh "docker build -t rawaablh/devops-front ."
            }
        }
    }
}
