import static groovy.io.FileType.FILES

def dir = new File(/C:\Users\rjilan01\Documents\TSB/)

dir.eachFileRecurse(FILES) {

    def file = it.toString()

    if (file.endsWith(".xsd")) {
        
        println it
        
        def xmlName = it.name.replace(".xsd",".xml")
       // println xmlName
        def name = ''
        
         if (file.endsWith("Request.xsd")) {
             name = "Request"
         } else {
              name = "Response"
         }
         
         def parentFile = it.getParentFile().toString()
         println parentFile
         
        println "xsd2inst.cmd ${file} -name ${name} > ${parentFile}\\${xmlName}"
        
      // def path = "xsd2inst.cmd ${file} -name ${name} > ${parentFile}\\${xmlName}".execute().text
       // println path
    }
    //def path = "xsd2inst.cmd ${it} -name Request".execute().text

}

