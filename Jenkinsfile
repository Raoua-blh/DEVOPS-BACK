pipeline {
    agent any
    triggers {
        github(
            allowPush: true,
            allowPullRequest: false,
            autoInvalidate: true,
        )
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
