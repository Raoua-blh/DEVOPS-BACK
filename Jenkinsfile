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
           stage("Jacoco Report") {
            steps {
                echo "Testing the backend app ..."
                sh 'mvn jacoco:report'
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
               stage("Push to Docker front ") {
            steps {
               // withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PWD')]) {
                    script {
                        sh "docker login -u $DOCKER_USER -p $DOCKER_PWD"
                        sh "docker push rawaablh/devops-front "
                    }
                }
            }
           stage("Docker Compose front + back + prometheus + grafana +cAdvisor ") {
            steps {
                echo "Docker compose down if there is any containers"
                sh "docker login -u $DOCKER_USER -p $DOCKER_PWD"
               // sh "docker compose build --no-cache"
                sh 'docker compose down '
                echo "docker compose up "
                sh 'docker compose up -d '
            }
        }
          stage('Performance Testing K6') {
            steps {

                echo 'Running K6 performance tests...'
                sh 'k6 run perfomrance-test.js'
                //sh 'K6_PROMETHEUS_RW_SERVER_URL=http://192.168.33.10:9090/api/v1/write  k6 run -o experimental-prometheus-rw performance-test.js'
            }
        }
        
    }

    post {
        always {
            script {
                currentBuild.result = currentBuild.currentResult
            }
            emailext subject: "Pipeline Status  ${currentBuild.result}: ${currentBuild.projectName}",
                body: "The pipeline has ended with status: ${currentBuild.result}",
                to: 'rawaa.blh@gmail.com'
        }    
            }
 
    
}
