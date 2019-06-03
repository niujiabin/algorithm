package jiabin.spring.parser;

import jiabin.spring.core.PerfectBox;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;


/**
 * 解析spring xml
 */
public class XmlParser {

    private static final Logger logger = LoggerFactory.getLogger(XmlParser.class);
    private static final SAXReader reader = new SAXReader();
    private static final String DEFAULT_FILE = "perfectContext,xml";

    /**
     * 加载资源文件
     *
     * @param resourcePath
     * @return
     */
    public static PerfectBox loadResource(String resourcePath) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(resourcePath);
        try {
            Document document = reader.read(url);
            Element element = document.getRootElement();
            logger.info(element.getName());
        } catch (Exception e) {
            logger.error("parse xml error", e);
            e.printStackTrace();
        }
        return null;
    }

    public static PerfectBox loadResource() {
        return loadResource(DEFAULT_FILE);
    }

}
