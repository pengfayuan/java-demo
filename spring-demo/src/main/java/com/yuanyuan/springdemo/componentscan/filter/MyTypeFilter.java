package com.yuanyuan.springdemo.componentscan.filter;

import java.io.IOException;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @author FAYUAN.PENG
 * @version \$Id: MyTypeFilter.java,  2021-08-01 14:51 FAYUAN.PENG Exp $$
 */
public class MyTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return false;
    }
}
