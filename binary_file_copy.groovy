File src = new File(/C:\Users\rjilani\Desktop\sonar_png\alerts.PNG/)
new File(/C:\Users\rjilani\Desktop\sonar_png\alerts_bkup.PNG/).withOutputStream{ out ->
out.write src.readBytes()
}