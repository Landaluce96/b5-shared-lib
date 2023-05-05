
def packageStage(){
    stage('Package'){
        sh 'mvn -B -DskipTests package dependency:copy-dependencies'
        archiveArtifacts artifacts: 'target/**/*.jar', fingerprint: true
    }
}
