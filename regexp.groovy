def file = new File(/C:\Users\rjilan01\Documents\TSB\regexp.txt/)

file.eachLine {

if (it =~ /^[0-9]{4}-[0-9]{2}-[0-9]{2} .*\S \[TransactionID-(\d)*\]; .*\s\[begins\...\]$/) {

println "tews"

}

println it}