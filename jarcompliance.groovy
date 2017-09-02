def reportPath = /C:\Users\rjilan01\Desktop\compare/

def file = new File(/C:\Users\rjilan01\Documents\Jars_Analysis\CRS\mrkpr01/)

file.eachFileRecurse {

if (it.toString().endsWith(".jar")) {
    def jar1 = it.toString()
    def name = it.name.replace(".jar",".html")

    def jar2 = it.toString().replace("mrkpr01","mrcealp2")

    println jar1
    println jar2

    def path = "cmd /c japi-compliance-checker.pl ${jar1} ${jar2} -v1 old -v2 new -report-path ${reportPath}\\${name}".execute().text

    println path
}

}