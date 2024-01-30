package webserver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentHandler {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);
    public static String[] supportExtraContent(String splitHeader_1) {
        int idx = splitHeader_1.lastIndexOf(".");
        String ext = splitHeader_1.substring(idx+1);
        String reqPath = "src/main/resources/templates", reqType = null;

        if(ext.equals("html")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath += splitHeader_1;
            reqType = "text/html";
        }
        if(ext.equals("css")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "text/css";
        }
        if(ext.equals("woff")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "font/woff";
        }
        if(ext.equals("ttf")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "font/ttf";
        }
        if(ext.equals("js")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "application/javascript";
        }
        if(ext.equals("ico")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "image/x-icon";
        }

        if(ext.equals("png")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "image/png";
        }
        if(ext.equals("jpg")) {
            logger.debug("splitHeader: " + splitHeader_1);
            reqPath = "src/main/resources/static" + splitHeader_1;
            reqType = "image/jpg";
        }

        return new String[] {reqPath, reqType};
    }


    
    
}
/*
            int idx = splitHeader_1.lastIndexOf(".");
            String ext = splitHeader_1.substring(idx+1);

            if(ext.equals("html")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath += splitHeader_1;
                reqType = "text/html";
            }
            if(ext.equals("css")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "text/css";
            }
            if(ext.equals("woff")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "font/woff";
            }
            if(ext.equals("ttf")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "font/ttf";
            }
            if(ext.equals("js")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "application/javascript";
            }
            if(ext.equals("ico")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "image/x-icon";
            }

            if(ext.equals("png")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "image/png";
            }
            if(ext.equals("jpg")) {
                logger.debug("splitHeader: " + splitHeader_1);
                reqPath = "src/main/resources/static" + splitHeader_1;
                reqType = "image/jpg";
            }
 */