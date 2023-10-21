pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage("Build") {
            steps {
                echo "Building the back end app..."
            }
        }
        stage("Test") {
            steps {
                echo "Testing the backend app..."
            }
        }
        stage("Deploy") {
            steps {
                echo "Deploying the app..."
            }
        }
    }
}
