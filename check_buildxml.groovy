def file = new File(/C:\jboss-eap-4.3\jboss-as\server\crs/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0


def outFile = new File(/C:\Users\rjilan01\Documents\project_stats_build.csv/).withWriter {out ->
out.writeLine("FileName" + "," + "NumberOfLines" + "," +  "Path")

file.eachFileRecurse {//println it

  if (it.isFile() ) 
  {
      if (it.toString().contains(".xml") || it.toString().contains(".properties")) {
          // def srcFile = new File(it)
       
          def srcType = ""
         
          
            it.eachLine {line -> 
                numerOflinesPerfile++
                if (line.contains("/DefaultJMSProvider")) { println it.toString() println line}
            }
           // println "${it.name}:${numerOflinesPerfile}"
            out.writeLine(it.name + "," + srcType + "," + numerOflinesPerfile  + "," +  it.getCanonicalPath())
            totalNumberOfLines = totalNumberOfLines + numerOflinesPerfile
            numerOflinesPerfile = 0 
      
     }
     
      nummberOfFile++
  } else {
      numberOfDir++
  }
}

// println(" ")
////println "Total number of dirs: ${numberOfDir}"
println "Total number of files: ${nummberOfFile}"
//println "Total number of lines in source files: ${totalNumberOfLines}"




}