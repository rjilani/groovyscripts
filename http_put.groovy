URL url = new URL("http://40368-nb:8080/");
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
httpCon.setDoOutput(true);
httpCon.setRequestMethod("PUT");
OutputStreamWriter out = new OutputStreamWriter(
    httpCon.getOutputStream());
//out.write("Resource content");
out.close();