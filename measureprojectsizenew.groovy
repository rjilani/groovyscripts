def file = new File(/C:\Users\rjilani\Documents\IdeaProjects\SonarQubeCodeAnalysis/)
def nummberOfFile = 0
def numberOfDir = 0
def numerOflinesPerfile = 0
def totalNumberOfLines = 0


def outFile = new File(/C:\Users\rjilani\Documents\code_stats\size.csv/).withWriter { out ->
    out.writeLine("FileName" + "," + "SrcType" + "," + "NumberOfLines" + "," + "Path" + "," + "Count")

    file.eachFileRecurse {//println it

        if (it.isFile() & !it.toString().contains("\\test\\")) {
            if (it.toString().endsWith(".xml") || it.toString().endsWith(".java") || it.toString().endsWith(".jsp") ||
                    it.toString().endsWith(".sh") || it.toString().endsWith(".bat") || it.toString().endsWith(".conf") || it.toString().endsWith(".config")
                    || it.toString().endsWith(".jar") || it.toString().endsWith(".properties") || it.toString().endsWith(".prop") || it.toString().endsWith(".sql") || it.toString().endsWith(".js")
                    || it.toString().endsWith(".include") || it.toString().endsWith(".txt") || it.toString().endsWith(".rb") || it.toString().endsWith("yaml")) {

                def srcType = ""
                if (it.toString().contains(".xml")) {
                    srcType = "XML"
                } else if (it.toString().contains(".java")) {
                    srcType = "Java"
                } else if (it.toString().contains(".jsp")) {
                    srcType = "JSP"
                } else if (it.toString().contains(".sh")) {
                    srcType = "sh"
                } else if (it.toString().contains(".bat")) {
                    srcType = "bat"
                } else if (it.toString().contains(".conf")) {
                    srcType = "Conf"
                } else if (it.toString().contains(".config")) {
                    srcType = "Config"
                } else if (it.toString().contains(".jar")) {
                    srcType = "jar"
                } else if (it.toString().contains(".properties")) {
                    srcType = "properties"
                } else if (it.toString().contains(".prop")) {
                    srcType = "prop"
                } else if (it.toString().contains(".sql")) {
                    srcType = "SQL"
                } else if (it.toString().contains(".js")) {
                    srcType = "js"
                }  else if (it.toString().contains(".include")) {
                    srcType = "include"
                }  else if (it.toString().contains(".txt")) {
                    srcType = "txt"
                } else if (it.toString().contains(".rb")) {
                    srcType = "ruby"
                } else {
                    srcType = "Yaml"
                }

                if (!(it.toString().contains(".dll") || it.toString().contains(".class"))) {

                    it.eachLine { line ->
                        if (line && !line.startsWith("'")) {

                            if (srcType == "Java") {

                                if (!line.trim().startsWith("/**") && !line.trim().startsWith("/*") && !line.trim().startsWith("*") && !line.trim().startsWith("//"))
                                    numerOflinesPerfile++
                            } else {

                                numerOflinesPerfile++
                            }
                        }
                    }
                }

                println "${it.name}:${numerOflinesPerfile}"
                out.writeLine(it.name + "," + srcType + "," + numerOflinesPerfile + "," + it.getCanonicalPath().replace("C:", "file:\\\\") + "," + 1)
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
