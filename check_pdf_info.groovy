def file = new File(/C:\projects\CSP2/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0

def ejbAnnotations = ['@ejb','@Resource','@Local','@Stateless','@PersistenceContext','@Stateful','@Remote','@BusinessMethod','MessageDriven','@Service']


def outFile = new File(/C:\Users\rjilan01\Documents\csp_stats.csv/).withWriter {out ->
out.writeLine("FileName" + "," + "LineNumber" + "," + "Line" + "," + "Path")

file.eachFileRecurse {//println it

  if (it.isFile() ) 
  {
      if (it.toString().contains(".java")) {
         
           
            it.eachLine {line ->
            
             numerOflinesPerfile++
              def no = numerOflinesPerfile
            
                if (line.contains(/static /)) {
                    out.writeLine(it.name + "," + no  + "," + line + "," +  it.getCanonicalPath())
                }
            }
            println "${it.name}:${numerOflinesPerfile}"

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