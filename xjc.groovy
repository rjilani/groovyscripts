
def packagName = "com.ca.teranet"
def destinationDir = /C:\Users\rjilan01\Documents\TSB\schemas\jaxb\12.0/
def xsdFile = /C:\Users\rjilan01\Documents\TSB\schemas\jaxb\12.0\Response\DawsserviceChangePasswordResponse.xsd/

def file = new File(/C:\Users\rjilan01\Documents\TSB\schemas\jaxb\12.0/)

file.eachFileRecurse {


    if (it.toString().endsWith(".xsd")) {
    
       //println it
       
       //def path = /C:\Program Files\Java\jdk1.7.0_51\bin\xjc -d ${destinationDir}  -p ${packagName} ${it}/.execute().text
    }

}


def path = /C:\Program Files\Java\jdk1.7.0_51\bin\xjc -d ${destinationDir}  -p ${packagName} ${xsdFile}/.execute().text


