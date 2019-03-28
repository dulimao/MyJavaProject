package tips.http_demo;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Http设置代理
 */
public class HttpProxy {
    public static void main(String[] args){
        setHttpsProxy("https://www.baidu.com","","192.168.56.1",8080);
    }


    /**
     * https或http请求设置代理
     * @param url
     * @param params
     * @param host
     * @param port
     */
    public static String setHttpsProxy(String url,String params,String host,int port) {
        HttpsURLConnection httpsConn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String result = null;
        try {
            URL urlClient = new URL(url);
            System.out.println("请求url: " + urlClient);
            SSLContext sc = SSLContext.getInstance("SSL");
            //制定信任https
            sc.init(null,new TrustManager[] {new TrustAnyTrustManager()},new SecureRandom());
            //创建代理
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(host,port));

            //设置代理
            httpsConn = (HttpsURLConnection) urlClient.openConnection(proxy);
            //不设置代理
           // httpsConn = (HttpsURLConnection) urlClient.openConnection();

            httpsConn.setSSLSocketFactory(sc.getSocketFactory());
            httpsConn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            //设置通用的请求属性
            httpsConn.setRequestProperty("accept","*/*");
            httpsConn.setRequestProperty("connection","KeepAlive");
            httpsConn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //发送POST请求必须设置这两个属性
            httpsConn.setDoInput(true);
            httpsConn.setDoOutput(true);

            //获取UrlConnection对象的输出流
            out = new PrintWriter(httpsConn.getOutputStream());
            //发送请求参数
            out.println(params);
            out.flush();
            //定义BufferedReader输入流读取URL的响应
            in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

            //断开连接
            httpsConn.disconnect();
            System.out.println("result: " + result);
            System.out.println("返回结果： " + httpsConn.getResponseMessage());

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(in,out);
        }
        return result;
    }



    private static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    private static class TrustAnyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }
    }

}
