package com.spring.servlet.Async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: AsyncServlet
 * =================================================
 * @Description: 异步请求Servlet
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @CreateDate: 2019/12/5 22:49
 * @Version: V1.0
 */
@WebServlet(value = "/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();

        System.out.println("主线程开始："+Thread.currentThread());
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("副线程程开始："+Thread.currentThread());
                    sayHello();
                    //获取响应
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("hello  Async...............");
                    asyncContext.complete();
                    System.out.println("副线程程结束："+Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        resp.getWriter().write("hello  Async主线程...............");
        System.out.println("主线程结束："+Thread.currentThread());
    }

    public void sayHello() throws InterruptedException {
        System.out.println(Thread.currentThread()+"...................");
        Thread.sleep(3000);
    }
}
