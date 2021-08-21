package com.yuanyuan.jacksondemo.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

/**
 * @author FAYUAN.PENG
 * @version \$Id: AnnotationDemoTest.java,  2021-08-15 15:36 FAYUAN.PENG Exp $$
 */
class AnnotationDemoTest {

    private AnnotationDemo demo = new AnnotationDemo();

    @Test
    void testJsonProperty() throws JsonProcessingException {
        demo.testJsonProperty();
    }

    @Test
    void testJsonIgnore() throws JsonProcessingException {
        demo.testJsonIgnore();
    }

    @Test
    void testJsonCreator() throws JsonProcessingException {
        demo.testJsonCreator();
    }

    @Test
    void testJsonAnyGetter() throws JsonProcessingException {
        demo.testJsonAnyGetter();
    }
}