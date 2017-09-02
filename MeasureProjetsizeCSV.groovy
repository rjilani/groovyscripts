def file = new File(/C:\workspace\jboss-as/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0


def outFile = new File(/C:\Users\rjilan01\Documents\code_stats\project_stats_jboss7.csv/).withWriter {out ->
out.writeLine("FileName" + "," + "SrcType" + "," + "NumberOfLines" + "," +  "Path")

file.eachFileRecurse {//println it

  if (it.isFile() ) 
  {
      if (it.toString().contains(".java") || it.toString().contains(".xml") || it.toString().contains(".properties") || it.toString().contains(".jar")) {
          // def srcFile = new File(it)
          
          def srcType = ""
          if (it.toString().contains(".java")) {
          srcType = "Java"
          } else if  (it.toString().contains(".properties")) {
           srcType = "Properties"
          } else if  (it.toString().contains(".jar")) {
           srcType = "jar"
          }  else {
           srcType = "XML"
          }
            if (!it.toString().contains(".jar")) {
                it.eachLine {numerOflinesPerfile++}
            }
            println "${it.name}:${numerOflinesPerfile}"
            out.writeLine(it.name + "," + srcType + "," + numerOflinesPerfile  + "," +  it.getCanonicalPath())
            totalNumberOfLines = totalNumberOfLines + numerOflinesPerfile
            numerOflinesPerfile = 0 
      }
     
      nummberOfFile++
  } else {
      numberOfDir++
  }
}

 println(" ")
println "Total number of dirs: ${numberOfDir}"
println "Total number of files: ${nummberOfFile}"
println "Total number of lines in source files: ${totalNumberOfLines}"




}