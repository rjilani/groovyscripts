
def file = new File(/C:\Users\rjilani\Documents\IdeaProjects\SonarQubeCodeAnalysis/)

def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0




def outFile = new File(/C:\Users\rjilani\Documents\code_stats\find.csv/).withWriter {out ->
    out.writeLine("FileName" + "," + "LineNumber" + "," + "Line" + "," + "Path")

    file.eachFileRecurse {

        if (it.isFile() )
        {


            if (it.toString().contains(".log") || it.toString().contains(".xml") || it.toString().contains(".java") || it.toString().contains(".properties") || it.toString().contains(".prop")
                    || it.toString().contains(".conf") || it.toString().contains(".configuration") ||  it.toString().contains(".include") || it.toString().contains(".txt")) {
                it.eachLine {line ->
                    //println line
                    numerOflinesPerfile++
                    def no = numerOflinesPerfile
                    if (line.contains("java") ) {
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