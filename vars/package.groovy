
def package(){
    stage('Package'){
        sh 'mvn -B -DskipTests package dependency:copyDependencies'
    }
}