def path = "cmd /c echo %PATH%".execute().text
def pathList = path.split(";")

def outFile = new File(/C:\Users\rjilan01\Documents\pathInfo.txt/).withWriter {out ->

    out.writeLine("-------------Items in PATH-----------------")

    pathList.each {println it

        out.writeLine(it)
    }

    out.writeLine("-------------Items in class PATH-----------------")

    println pathList.length

    def classPath = "cmd /c echo %CLASSPATH%".execute().text
    def classPathList = classPath.split(";")

    println classPathList.length

    if (classPathList.length > 1) {

        classPathList.each {println it

        }

    }

}