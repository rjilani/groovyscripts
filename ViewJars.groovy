def file = new File(/C:\jboss-eap-6.0/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0


def outFile = new File(/C:\Users\rjilan01\Documents\stats.csv/).withWriter {out ->
out.writeLine("FileName" + "," + "SrcType" + "," +  "FilePath")

file.eachFileRecurse {//println it

  if (it.isFile() ) 
  {
      if (it.toString().contains(".jar") || it.toString().contains(".xml") || it.toString().contains(".properties")) {
          
          def srcType = ""
          if (it.toString().contains(".jar")) {
          srcType = "Jar"
          } else if  (it.toString().contains(".properties")) {
           srcType = "Properties"
          } else {
           srcType = "XML"
          }
           
            out.writeLine(it.name + "," + srcType  + "," + it.getCanonicalPath())
      }
     
      nummberOfFile++
  } else {
      numberOfDir++
  }
}

 println(" ")
println "Total number of dirs: ${numberOfDir}"
println "Total number of files: ${nummberOfFile}"




}