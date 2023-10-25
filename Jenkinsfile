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
        stage("Nexus Deploy") {
            steps {
                echo "Deploying the backend app..."
                sh 'mvn deploy'
            }
        }
    }
}
