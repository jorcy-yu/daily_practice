package Log4j;

import org.apache.log4j.Logger;

public class log {
    private static Logger Loge=Logger.getLogger(log.class.getName());
    public static void starttestcase(String testcasename){
        Loge.info("--------------------------------------------------------");
        Loge.info("*****************   "+testcasename+"   *****************");
    }
    public static void endtestcase(String testcasename){
        Loge.info("***************** "+testcasename+"over *****************");
        Loge.info("--------------------------------------------------------");
    }
    public static void info(String message){
        Loge.info(message);
    }
    public static void warn(String message){
        Loge.warn(message);
    }
    public static void error(String message){
        Loge.error(message);
    }
    public static void fatal(String message){
        Loge.fatal(message);
    }
    public static void debug(String message){
        Loge.debug(message);
    }
}
