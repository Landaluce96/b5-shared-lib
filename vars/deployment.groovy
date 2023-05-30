
def deploy(){
    stage('Deploy'){
        
        def dockerfile = libraryResource ('com/landaluce/Dockerfile')
        writeFile (file: 'Dockerfile', text: dockerfile)
        def dockerCompose = libraryResource ('com/landaluce/docker-compose.yml')
        writeFile (file: 'docker-compose.yml', text: dockerCompose)
        
        withDocker(docker: 'Docker'){
            sh 'docker compose build'
        }        
    }
}
