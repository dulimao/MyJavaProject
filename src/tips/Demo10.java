package tips;

import java.util.concurrent.TimeUnit;

/**
*@author: 杜立茂
*@createDate  : 2019/3/24 15:54
*@description: ThreadLocal
*/

public class Demo10 {

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("const: " + Profiler.end() + " ms");
    }

    static class Profiler {
        private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
            @Override
            protected Long initialValue() {
                return System.currentTimeMillis();
            }
        };

        public static void begin(){
            TIME_THREADLOCAL.set(System.currentTimeMillis());
        }

        public static long end(){
            return System.currentTimeMillis() - TIME_THREADLOCAL.get();
        }


    }

}
