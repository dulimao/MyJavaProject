package http;

import sun.rmi.runtime.Log;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 多线程下载
 */
public class MultiThreadDowload {

    private Executor executor = Executors.newFixedThreadPool(3);

    class DownloadRunnable implements Runnable{

        private String url;
        private String fileName;
        private long start;
        private long end;

        public DownloadRunnable(String url, String fileName, long start, long end) {
            this.url = url;
            this.fileName = fileName;
            this.start = start;
            this.end = end;
            System.out.println("线程名：" + Thread.currentThread().getName() + " 开始位置： " + start + " 终止位置： " + end);
        }

        @Override
        public void run() {
            try{
                URL httpUrl = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestProperty("Range","bytes=" + start + "-" + end);
                conn.setRequestMethod("GET");
                RandomAccessFile accessFile = new RandomAccessFile(fileName,"rwd");
                accessFile.seek(start);
                InputStream inputStream = conn.getInputStream();
                byte[] bytes = new byte[1024 * 2];
                int len;
                while ((len = inputStream.read(bytes)) != -1){
                    accessFile.write(bytes,0,len);
                }

                accessFile.close();
                inputStream.close();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void startDownload(){
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545107628698&di=cf4fba0032ec2042543e5d2d65812227&imgtype=0&src=http%3A%2F%2Fimage.17173.com%2Fbbs%2Fv1%2F2010%2F03%2F24%2F1269416139181.jpg";
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            int contentLength = conn.getContentLength();
            int block = contentLength / 3;
            File file = new File(url.substring(url.lastIndexOf("%") + 1));

            for (int i = 0; i < 3; i++){
                int start = i * block;
                int end = (i + 1) * block - 1;
                if (i == 2){
                    end = contentLength;
                }
                DownloadRunnable downloadRunnable = new DownloadRunnable(url,file.getAbsolutePath(),start,end);
                executor.execute(downloadRunnable);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
