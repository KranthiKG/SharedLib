def dockerBuild(String repository){
  sh """
  docker build -t ${repository} .
  """
}



def dockerPush(String repository){
  sh "docker push ${repository}"
}

def dockerLogin(){
 withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
   sh """
   docker login --username="kranthikg" --password="${dockerhubpwd}"
   """
 }
}
def dockerPull(String repository){
  sh "docker pull ${repository}"
}

def dockerBuildPush(String dockerHubCredentialsId, String dockerFilePath, String dockerImageName, String dockerImageTag) {
    try {
        def docker = new DockerClient('unix:///var/run/docker.sock')
        docker.withRegistry("https://index.docker.io/v1/", dockerhubpwd) {
            def dockerImage = docker.build("${dockerImageName}:${dockerImageTag}", dockerFilePath)
            dockerImage.push()
        }
    } catch (e) {
        println("Failed to build and push Docker image: ${e}")
        throw e
    }
}
