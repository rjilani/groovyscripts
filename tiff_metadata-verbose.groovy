
def fileName

def colorSpace

def compression

def fileSize

def file = new File(/C:\Users\rjilan01\Desktop\misc\1092013/)

def outFile = new File(/C:\Users\rjilan01\Desktop\misc\1092013\tiff_metadata.txt/).withWriter {out ->

    out.writeLine("FileName" + "," + "ColorSpace" + "," + "Compression" + "," +  "FileSize")

    file.eachFileRecurse {

        if (it.isFile() ) 
  
        { 
  
            if (it.name.endsWith(".tif") || it.name.endsWith(".TIF")) {
   
                println it
       
                filePath = it
       
                def a = "identify -verbose " + "\"" +  filePath +  "\""
       
                println a
       
                def c = a.execute().text
                
                out.writeLine(c)
       
               
       
               out.writeLine("-------------------------------------------------------------------------------------------------------------") 
                println "----------------------------------------------------------------------------------"
                
             
                
    
            }
  
            
        }
        
        
    }
    
    
}