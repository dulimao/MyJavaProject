package http;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;



/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/18 13:39
*@Description: 修改内容
*/

public class UploadImageThread extends Thread {

    private String url;
    private String fileName;

    public UploadImageThread(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        super.run();
        try {
            String boundary = "---------------------5645645484545";
            String prifix = "--";
            String end = "\r\n";

            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
            outputStream.writeBytes(prifix + boundary + end);
            outputStream.writeBytes("Content-Disposition:form-data;"
            + "name=\"file\";filename=\"" + "picture.jpg" + "\"" + end);
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            byte[] buff = new byte[1024 * 2];
            int len;
            while ((len = fileInputStream.read(buff)) != -1){
                outputStream.write(buff);
            }
            outputStream.writeBytes(end);
            outputStream.writeBytes(prifix + boundary + prifix + end);
            conn.disconnect();
            outputStream.close();
            fileInputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
