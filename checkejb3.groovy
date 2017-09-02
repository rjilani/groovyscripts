def file = new File(/C:\workspace\rjilan01_jboss\CRS/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0

def ejbAnnotations = ['@ejb','@Resource','@Local','@Stateless','@PersistenceContext','@Stateful','@Remote','@BusinessMethod','MessageDriven','@Service']


def outFile = new File(/C:\Users\rjilan01\Documents\code_stats\ejb_stats_crs_jboss.csv/).withWriter {out ->
out.writeLine("FileName" + "," + "LineNumber" + "," + "Line" + "," + "Path")

file.eachFileRecurse {//println it

  if (it.isFile() ) 
  {
      if (it.toString().contains(".java")) {
         
           
            it.eachLine {line ->
            
             numerOflinesPerfile++
              def no = numerOflinesPerfile
            
                if (line.contains(/@ejb/) || line.contains(/@Resource/) || line.contains(/@Local/) || 
                line.contains(/@Stateless/) || line.contains(/@PersistenceContext/) || line.contains(/@Stateful/) || line.contains(/@Stateful/)
                || line.contains(/@Remote/) || line.contains(/@MessageDriven/) || line.contains(/@BusinessMethod/) || line.contains(/@Service/)) {
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