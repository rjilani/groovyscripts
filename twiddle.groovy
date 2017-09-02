def path = "cmd /c C:\\jboss-eap-5.2\\jboss-as\\bin\\twiddle.bat -s mrkcrsbtvlut01:1299 -u admin -p admin get jboss.ws:service=ServerConfig WebServicePort".execute().text

//path = "cmd /c C:\\jboss-eap-5.2\\jboss-as\\bin\\twiddle.bat -s msscrsbtvlut01 -u admin -p admin get jboss.system:type=ServerInfo".execute().text

//path = "cmd /c C:\\jboss-eap-5.2\\jboss-as\\bin\\twiddle.bat -s msscrsbtvlut01 -u admin -p admin invoke jboss:service=JNDIView list true".execute().text