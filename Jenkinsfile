pipeline {
    agent any

    tools {

        jdk 'JDK21'

    }

    environment {

        DB_PASSWORD = credentials('db-password')

    }

    stages {

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
    }
}