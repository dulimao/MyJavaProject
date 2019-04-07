package tips.concurrent_demo.thread_pool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
*@author: 杜立茂
*@createDate  : 2019/3/26 19:48
*@description: 一个基于线程池的简单Web服务器
*/

public class SimpleHttpServer {

    //处理HttpRequest的线程池
    private static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>();
    //服务器根路径
    private static String basePath;
    private static ServerSocket serverSocket;
    //服务器监听端口
    private static int port = 8080;


    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    //启动服务
    public static void startServer() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            //接收一个客户端Socket,生成一个HttpRequestHandler,放入线程池中执行
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }


    static class HttpRequestHandler implements Runnable {

        private Socket socket;
        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                //由相对路径计算出绝对路径
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                //如果请求的资源后缀为jpg或ico，则读取并输出
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int len = 0;
                    while ((len = in.read()) != -1) {
                        baos.write(len);
                    }
                    //k开始向客户端写流
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server:axin");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length:" + array.length);
                    out.println("");
                    socket.getOutputStream().write(array,0,array.length);
                } else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server:axin");
                    out.println("Content-Type:text/html;charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null){
                        out.println(line);
                    }
                }
                out.flush();

            } catch (Exception e) {
                if (out != null) {
                    out.println("HTTP/1.1 500");
                    out.println("");
                    out.flush();
                }
            }finally{
                close(br,in,reader,out,socket);
            }

        }

        private static void close(Closeable... closeables) {
            for (Closeable closeable : closeables){
                try {
                    closeable.close();
                }catch (Exception e){
                }
            }
        }

    }
}
