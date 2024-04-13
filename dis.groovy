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
        stage('test') {
            steps {
                sh ''' /opt/apache-maven-3.9.6/bin/mvn sonar:sonar \\
                         -Dsonar.projectKey=studentapp-ui \\
                         -Dsonar.host.url=http://54.160.104.13:9000 \\
                         -Dsonar.login=82f7747e418b8ddd8e47230e61eb72fba01c737f'''
                echo 'this is test operation'
            }
        }
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
