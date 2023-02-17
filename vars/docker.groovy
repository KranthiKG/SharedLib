def dockerBuild(String repository){
  sh "docker build -t ${repository} ."
}

def dockerBuild1(){
  sh 'docker build -t kranthikg/sharedlibimage .'
}

def dockerPush(String repository){
  sh "docker push ${repository}"
}

def dockerPush1(string repository)
 withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u kranthikg -p ${dockerhubpwd}'
}
sh "docker push kranthikg/sharedlibimage"

def dockerPull(String repository){
  sh "docker pull ${repository}"
}
