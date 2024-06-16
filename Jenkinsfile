pipeline {
    agent any

    tools {
        // Install the Maven version configured in Jenkins
        maven 'Maven 3.9.7' // Ensure this matches the name of the Maven installation in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the SCM
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Run Maven clean and package
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Example of deploying artifacts if needed
                // You can define your own deployment steps
                sh 'mvn deploy'
            }
        }
    }

    post {
        success {
            // Actions to take on successful build
            echo 'Build completed successfully!'
        }
        failure {
            // Actions to take on build failure
            echo 'Build failed.'
        }
        always {
            // Actions to take in any case
            cleanWs() // Clean workspace
        }
    }
}
