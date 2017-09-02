
def fileName

def colorSpace

def compression

def fileSize

def file = new File(/C:\Users\rjilan01\Desktop\misc\MGS_Test\itext_mail\large_tiff/)



    file.eachFileRecurse {

        if (it.isFile() ) 
  
        { 
  
            if (it.name.toString().contains(".tif") || it.name.toString().contains(".TIF")) {
   
                println it
       
                filePath = it
                
                def fileNames = it.name.toString().split("\\.")
               
               def e = "${fileNames[0]}-c.tif"
                
                
       
                //def a = "cmd /c convert -resize 20% " +  filePath + " " +  ""
                
                //def a = "cmd /c convert -resize 20% " +  filePath + " " +  filePath.toString().replace(".tif", "-c.jpg")
       
                   def a = "cmd /c convert " +  filePath + " " + "-resize 20% " +  " " +  filePath.toString().replace(".tif", "-c.jpeg")
               
                println a
       
                def c = a.execute()
                 c.waitFor()
              
             // def p = "cmd /c convert -resize 20% C:\\Users\\rjilan01\\Documents\\test_tiff\\reduce_image\\Sketch204W-v2.tif C:\\Users\\rjilan01\\Documents\\test_tiff\\reduce_image\\Sketch204W-v2.jpg".execute()
             // p.waitFor()
       
              
       }
                       
    }
    
}