
def deploy(){
    stage('Deploy'){
        docker.withTool('Docker'){
            
            def dockerfile = libraryResource ('com/landaluce/Dockerfile')
            writeFile (file: 'Dockerfile', text: dockerfile)

            String name = "landaluce/b5-jenkins-app"
            sh "docker build -t ${name}:${BUILD_ID} -t ${name}:latest ."
            withCredentials([usernamePassword(credentialsId: 'Docker_hub', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
                sh "docker login -u ${USER} -p ${PASSWORD}"
                sh "docker push ${name}:${BUILD_ID} ${name}:latest"
            }              
        }
    }
}
