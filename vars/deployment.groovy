
def deploy(){
    stage('Deploy'){
        docker.withTool('Docker'){
            withDockerRegistry(credentialsId: 'Docker_hub') {
            
                def dockerfile = libraryResource ('com/landaluce/Dockerfile')
                writeFile (file: 'Dockerfile', text: dockerfile)
                def app = docker.build("landaluce/b5-jenkins-app:${BUILD_ID}")
                app.push()
                app.push 'latest'
                
            }
        }
    }
}
