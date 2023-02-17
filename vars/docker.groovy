def dockerBuild(String repository){
  sh """
  docker build -t ${repository} .
  """
}

def dockerBuild1(){
  sh 'docker build -t kranthikg/sharedlibimage .'
}

def dockerPush(String repository){
  sh "docker push ${repository}"
}

def dockerLogin(){
 withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
   sh """
   docker login -u kranthikg -p ${dockerhubpwd}
   """
 }
}
def dockerPull(String repository){
  sh "docker pull ${repository}"
}
