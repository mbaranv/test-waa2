pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               echo 'Compiling the java source code'
                sh 'mvn compile'
                }
             }

        stage('Test') {
            steps {
                echo 'Running the compiled java code.'
                sh 'mvn test -Dtest=Test01'
                }
             }
           }
        }