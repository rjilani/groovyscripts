
def imageWidth = ""

def imageLength  = ""

def compression  = ""

def resolution  = ""

def strips  = ""

def tiles  = ""

int size  

def file = new File(/C:\Users\rjilan01\Documents\test_tiff\scripts/)

def outFile = new File(/C:\Users\rjilan01\Documents\test_tiff\scripts\tiff_metadata.csv/).withWriter {out ->

    out.writeLine("FileName" + "," + "FileSize" + "," + "ImageWidth" + "," + "ImageLength" + "," +  "Compression" + "," + "Resolution" + "," + "Strips" + "," + "Tiles")

    file.eachFileRecurse {

        if (it.isFile() ) 
  
        { 
  
            if (it.name.toString().contains(".tif") || it.name.toString().contains(".TIF")) {
   
               // println it
       
                filePath = it
                
                size = it.length()/1024
                
                println size
       
                def a = "tiffinfo -s " + "\"" +  filePath +  "\""
       
                println a
       
                def c = a.execute().text
       
                c.eachLine {line -> //println line
       
                   
                   if (line.contains("Image Width:")) {
       
                        def lin = line.split(" ")
                        
                        imageWidth = lin[4]
                        imageLength = lin[7]
                         
                        
       
                    }
                   
                   
                    if (line.contains("Resolution:")) {
       
                        def lin = line.split(":")
                        
                       resolution = lin[1].replace(",","")
                       
                        
       
                    }
                    
                     if (line.contains("Compression Scheme:")) {
       
                        def lin = line.split(":")
                        
                        
                        compression = lin[1]
                        
                        
       
                    }
                    
                     if (line.contains("Strips:")) {
       
                        def lin = line.split(" ")
                      
                       strips = lin[2]
                       
                       
                       
                         //out.writeLine(it.name+ "," + size + "," + imageWidth + "," + imageLength + "," +  compression + "," + resolution + "," + strips + "," + tiles)
                        
       
                    }
                    
                     if (line.contains("Tiles:")) {
       
                        def lin = line.split(" ")
                        
                          tiles = lin[2]
                          
                        
                         //out.writeLine(it.name+ "," + size + "," + imageWidth + "," + imageLength + "," +  compression + "," + resolution + "," + strips + "," + tiles)
       
                    }
       
                       
                       
                        
                }
                
                        println imageWidth
                        println imageLength
                        println resolution
                        println compression
                        println strips
                        println tiles
                        println filePath
                        
                       
                            out.writeLine(it.toString()+ "," + size + "," + imageWidth + "," + imageLength + "," +  compression + "," + resolution + "," + strips + "," + tiles)
                        
                        
                        imageWidth = ""
                        imageLength = ""
                        resolution = ""
                        compression = ""
                        strips = ""
                        tiles = ""
                        size = 0
       
       
                    println "------------------------------------"
                
             
                       
    
            }
  
            
        }
        
        
    }
    
    
}