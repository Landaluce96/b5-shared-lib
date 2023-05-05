
def deploy(){
    stage('Deploy'){
        sh 'mkdir docker'
        def dockerfile = libraryResource 'com/landaluce/Dockerfile'
        writeFile file: 'docker/Dockerfile' text: "${dockerfile}"
        def dockerCompose = libraryResource 'com/landaluce/docker-compose.yml'
        writeFile file: 'docker/docker-compose.yml' text: "${dockerCompose}"

        sh 'docker compose -f docker/docker-compose.yml build'
    }
}