package com.zzz.tools.junit.useProperties;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by Jack on 21/04/2016.
 */
@ContextConfiguration(locations={"classpath:com/frames/springJDBC/example1/applicationContext.xml"})
public abstract class useProperties extends AbstractJUnit4SpringContextTests{
    public useProperties() {
        super();
    }


}
