pipeline {
    agent any

    stages {
        stage('pull') {
            steps {
                echo 'this is pull operation'
            }
        }
        stage('build') {
            steps {
                echo 'this is build operation'
            }
        }
        stage('test') {
            steps {
                echo 'this is test operation'
            }
        }
        stage('quallity check') {
            steps {
                echo 'this is quality check operation'
            }
        }
        stage('deploy') {
            steps {
                echo 'this is deploy operation'
            }
        }
    }
}