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

def tag(String tag1, String tag2){
   sh """
       docker image tag "${tag1}" "${tag2}"
      """ 
}
