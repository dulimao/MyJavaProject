package http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 状态码：200：请求成功
 *         4.. 本地请求错误
 *         5.. 服务器发生错误
 */

public class HttpUrlConnectionThread extends Thread{

    @Override
    public void run() {
        super.run();
        doGet();
    }

    /**
     * GET请求 请求数据大小有限制
     */
    private void doGet(){
        try {
//            URL url = new URL("https://www.baidu.com/");//下载文档
            //下载一张图片
            URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545107628698&di=cf4fba0032ec2042543e5d2d65812227&imgtype=0&src=http%3A%2F%2Fimage.17173.com%2Fbbs%2Fv1%2F2010%2F03%2F24%2F1269416139181.jpg");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            InputStream inputStream = conn.getInputStream();
            File file = new File("D://myPicture.jpg");
            FileOutputStream out = new FileOutputStream(file);
            byte[] buff = new byte[1024 * 2];//缓冲区
            int len = 0;
            while ((len = inputStream.read(buff)) != -1){
                out.write(buff,0,len);//写入文件
            }
            System.out.println("写入成功");

//            BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String str;
//            while ((str = bufferedReader.readLine()) != null){
//                System.out.println(str);//控制台打印
//            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * GET请求上传数据
     * @param name
     * @param password
     */
    private void goGetWithParamter(String name,String password){
        try {
            //需要utf编码，不然会乱码
            String url = "url" + "?name=" + URLEncoder.encode(name,"utf-8")+ "&password=" + password;
            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200){
                System.out.println("请求成功");
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doPostWithParameter(String name,String password){
        try {
            URL url = new URL("http://localhost:8080/web/severlet");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");
            OutputStream outputStream = conn.getOutputStream();
            //POST请求不用编码，因为默认是用UTF-9=8的编码
            String content = "?name=" + name + "&password=" + password;
            outputStream.write(content.getBytes());
            if (conn.getResponseCode() == 200){
                System.out.println("POST请求成功");
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
