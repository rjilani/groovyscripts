@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.URLENC

def page = new URL("https://www.cspuat.ca/csp/")

page.eachLine {line ->
    
    if (line ==~ /^<form.*$/) {
       // println line
        
        def tokens = line.split(" ")
        
       // println tokens[3]
        
        tokens = tokens[3].split("=")
        
        def url = "https://www.cspuat.ca" + tokens[1].replace(/"/,"") + "=" + tokens[2].replace(/"/,"")
        
        println url
        
       def http = new HTTPBuilder(url)
       def postBody = [loginBoxOn: 'true', redirectUrl: '/', j_username: 'amit.ajmani@teranet.ca', j_password: 'Teranet@456']
       
       http.post( path: '/', body: postBody, requestContentType: URLENC ) { resp ->
       
 
          println "POST Success: ${resp.statusLine}"
          println "Response length: ${resp.headers.'Location'}"
          assert resp.statusLine.statusCode == 302
        }
    }
}
