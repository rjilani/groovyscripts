

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.2' )

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT
 
new HTTPBuilder('http://www.google.com/').request(GET) { req ->
 
  response.success = { resp ->
    println 'request was successful'
    println resp.toString()
    assert resp.status < 400
  }
 
  response.failure = { resp ->
    println 'request failed'
    assert resp.status >= 400
  }
}