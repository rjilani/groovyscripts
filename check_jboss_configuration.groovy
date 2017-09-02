//def file = new File(/C:\jboss-eap-5.1/)

def file = new File(/C:\Users\rjilan01\Documents\ALinuxTempFolder\tmp/)

def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0




def outFile = new File(/C:\Users\rjilan01\Desktop\info.csv/).withWriter {out ->
    out.writeLine("FileName" + "," + "LineNumber" + "," + "Line" + "," + "Path")

    file.eachFileRecurse {
        
        if (it.isFile() ) 
        {
           
            
            if (it.toString().contains(".xml")) {
                it.eachLine {line ->
                    //println line
                    numerOflinesPerfile++
                    def no = numerOflinesPerfile
                    if (line.contains("cspDSXA") ) {
                        out.writeLine(it.name + "," + no  + "," +  line.replaceAll(",", " ") + "," +  it.getCanonicalPath())
                        println (it.name + "," + no  + "," + line+ "," +  it.getCanonicalPath())
                    }
                }
                
                totalNumberOfLines = totalNumberOfLines + numerOflinesPerfile
                numerOflinesPerfile = 0 
            }
            
            
            
            nummberOfFile++
        }
        
         
        else {
            numberOfDir++ 
        }

    }
}

println(" ")
println "Total number of dirs: ${numberOfDir}"
println "Total number of files: ${nummberOfFile}"
println "Total number of lines in source files: ${totalNumberOfLines}"