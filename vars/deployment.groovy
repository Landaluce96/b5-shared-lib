
def deploy(){
    stage('Deploy'){
        
        def dockerfile = libraryResource ('com/landaluce/Dockerfile')
        writeFile (file: 'Dockerfile', text: dockerfile)
        def dockerCompose = libraryResource ('com/landaluce/docker-compose.yml')
        writeFile (file: 'docker-compose.yml', text: dockerCompose)
        
        withDockerRegistry(credentialsId: 'Docker_hub') {
            def app = docker.build("landaluce/b5-jenkins-app:${BUILD_ID}")
            app.push()
            app.push 'latest'
        }
        
    }
}
