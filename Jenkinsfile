pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your Git repository
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Compile the Java source code
                bat 'javac SendEmail.java'
            }
        }
        stage('Run') {
            steps {
                // Run the Java application
                bat 'java SendEmail'
            }
        }
    }

    post {
        always {
            cleanWs() // Clean up workspace after build
        }
    }
}
