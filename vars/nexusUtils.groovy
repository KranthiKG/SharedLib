@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.13')

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.HttpMultipartMode
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.impl.client.HttpClients
import hudson.util.Secret

def uploadMavenArtifactToNexus(String groupId, String artifactId, String version, File artifact, String nexusUrl, String nexusCredentialsId, String repositoryId) {
    def nexusCredentials = hudson.util.Secret.fromString(Jenkins.instance.credentials.getById(nexusCredentialsId).password)
    def nexusUsername = Jenkins.instance.credentials.getById(nexusCredentialsId).username

    def httpclient = HttpClients.createDefault()
    def httpPost = new HttpPost("$nexusUrl/#admin/repository/repositories=$repositoryId")
    httpPost.setHeader("Authorization", "Basic " + "${nexusUsername}:${nexusCredentials.getPlainText()}".bytes.encodeBase64())

    def builder = MultipartEntityBuilder.create()
    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
    builder.addBinaryBody("maven2.asset1", artifact, ContentType.APPLICATION_OCTET_STREAM, artifact.getName())
    builder.addTextBody("maven2.groupId", groupId)
    builder.addTextBody("maven2.artifactId", artifactId)
    builder.addTextBody("maven2.version", version)

    def multipart = builder.build()
    httpPost.setEntity(multipart)

    HttpResponse response = httpclient.execute(httpPost)
    response.getEntity().getContent().close()
    httpclient.close()
}
