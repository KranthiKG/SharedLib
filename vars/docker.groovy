def dockerBuild(String repository){
  sh "docker build -t ${repository} ."
}

def dockerBuild1(String repository){
  docker.build${repository}
}

def dockerPush(String repository){
  sh "docker push ${repository}"
}

def dockerPush1(string repository)
 withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u kranthikg -p ${dockerhubpwd}'
}
sh "docker push ${repository}"

def dockerPull(String repository){
  sh "docker pull ${repository}"
}
