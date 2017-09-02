
def listOfFile = []
def destFolder = "C:\\Users\\rjilan01\\Documents\\test_tiff\\ScalingTest\\merged" 
def file = new File(/C:\Users\rjilan01\Documents\test_tiff\ScalingTest/)


    file.eachFile {

        if (it.isFile() ) 
  
        { 
  
            if (it.name.toString().contains(".tif") || it.name.toString().contains(".TIF")) {
   
                println it
                
                listOfFile << it
            }
        }
    
}

def files = listOfFile.join(' ')

 def a = "tiffcp " + files + " ${destFolder}test.tif"
 
 println a
       
def c = a.execute().text