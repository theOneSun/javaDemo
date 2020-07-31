package study.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author sunjian.
 */
public class CglibDemo {
    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();        // 为代理类指定需要代理的类，也即是父类
        enhancer.setSuperclass(FootballPlayer.class);        // new 一个新的方法拦截器
        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();        // 设置方法拦截器回调引用，对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept() 方法进行拦截
        enhancer.setCallback(cglibMethodInterceptor);        // 获取动态代理类对象并返回
        FootballPlayer player = (FootballPlayer) enhancer.create();
        player.setName("messi");
        player.goal();
    }
}
