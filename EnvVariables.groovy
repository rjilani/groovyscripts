def path = "cmd /c set".execute().text
def pathList = path.split(";")

def outFile = new File(/C:\Users\rjilan01\Documents\EnvVariables.txt/).withWriter {out ->

    out.writeLine("-------------List of Environments Variables-----------------")

    pathList.each {println it

        out.writeLine(it)
    }

   

}