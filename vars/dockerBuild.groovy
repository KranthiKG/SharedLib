def build(String tag) {
    sh """
        docker build -t "${tag}" .
    """
}

def push(String tag) {
    sh """
        docker push "${tag}"
    """
}

def tag(String tag, String tag){
   sh """
       docker image tag "${tag}" "${tag}"
      """ 
}
