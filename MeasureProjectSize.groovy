def file = new File(/C:\rhino1_7R4\src/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0

def outFile = new File(/C:\Users\rjilani\Documents\stats.txt/).withWriter {out ->

file.eachFileRecurse {//println it

  if (it.isFile() ) 
  {
      if (it.toString().contains(".java") || it.toString().contains(".xml") || it.toString().contains(".properties")) {
          // def srcFile = new File(it)
           
            it.eachLine {numerOflinesPerfile++}
            println "${it.name}:${numerOflinesPerfile}"
            out.writeLine(it.name + " : " + numerOflinesPerfile)
            out.writeLine(" ")
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


 out.writeLine(" ")
  out.writeLine("##############################################")
 out.writeLine( "Total number of dirs" + " : " + numberOfDir)
 out.writeLine(" ")
 out.writeLine( "Total number of files" + " : " + nummberOfFile)
 out.writeLine(" ")
 out.writeLine( "Total number of lines in source files" + " : " + totalNumberOfLines)
  out.writeLine("#############################################")

}