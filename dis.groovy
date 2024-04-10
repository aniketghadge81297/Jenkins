pipeline {
    agent any

    stages {
        stage('pull') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/aniketghadge81297/studentapp.ui'
                echo 'this is pull operation'
            }
        }
        stage('build') {
            steps {
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                echo 'this is build operation'
            }
        }
        // stage('test') {
        //     steps {
        //         echo 'this is test operation'
        //     }
        // }
        // stage('quallity check') {
        //     steps {
        //         echo 'this is quality check operation'
        //     }
        // }
        // stage('deploy') {
        //     steps {
        //         echo 'this is deploy operation'
        //     }
        // }
    }
}
