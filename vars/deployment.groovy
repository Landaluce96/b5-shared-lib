
def deploy(){
    stage('Deploy'){
        
        def dockerfile = libraryResource ('com/landaluce/Dockerfile')
        writeFile (file: 'Dockerfile', text: dockerfile)
        def dockerCompose = libraryResource ('com/landaluce/docker-compose.yml')
        writeFile (file: 'docker-compose.yml', text: dockerCompose)
        
        docker.withTool('Docker'){
            String name = 'landaluce/b5-jenkins-app'
            sh "docker build -t ${name}:${BUILD_ID} -t ${name}:latest"
            withCredentials([usernamePassword(credentialsId: 'Docker_hub', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
                sh "docker login -u ${USER} -p ${PASSWORD}"
                sh "docker push ${name}:${BUILD_ID}"
                sh "docker push ${name}:latest"
            }
        }        
    }
}
