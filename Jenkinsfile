pipeline {
    agent any
  
    stages {
        stage("Build") {
            steps {
                echo "Building the back end app..."
                sh 'mvn clean install'
            }
        }
        stage("Test") {
            steps {
                echo "Testing the backend app..."
                sh 'mvn test'
            }
        }
        stage("Deploy") {
            steps {
                echo "Deploying the backend app..."
            }
        }
    }
}
