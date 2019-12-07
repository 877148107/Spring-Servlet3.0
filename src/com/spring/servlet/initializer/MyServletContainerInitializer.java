package com.spring.servlet.initializer;

import com.spring.servlet.service.HandlesTypesService;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @ClassName: MyServletContainerInitializer
 * =================================================
 * @Description: 运行时插件，容器在启动的时候会扫描当前应用里面每一个jar包下面的/META-INF/services/javax.servlet.ServletContainerInitializer
 *               里面指定的实现类，启动并运行这个实现类的方法
 *               1、必须绑定在/META-INF/services/javax.servlet.ServletContainerInitializer
 *               2、必须实现ServletContainerInitializer的类的全类名
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2019/12/7 20:32
 * @Version: V1.0
 */
//容器启动的时候会将HandlesTypes指定的这个类型下面的子类、子接口传递过来,感兴趣的类型
@HandlesTypes(value = {HandlesTypesService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动的时候回执行这个方法
     * @param set HandlesTypes感兴趣的类型
     * @param servletContext  代表web应用的servletContext，一个web应用一个servletContext
     *
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型：");
        for (Class<?> aClass : set) {
            System.out.println(aClass);
        }
        //可以用servletContext添加filter、listener、Servlet
    }
}
