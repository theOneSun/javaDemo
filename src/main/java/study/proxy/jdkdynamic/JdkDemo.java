package study.proxy.jdkdynamic;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author sunjian.
 */
public class JdkDemo {

    //第一种创建代理的方式
    @Test
    public void testJdkProxy(){

        final InvocationHandler handler = new PeopleInvocationHandler<>(new Referee());
        final IPeople peopleProxy = (IPeople) Proxy.newProxyInstance(IPeople.class.getClassLoader(), new Class[]{IPeople.class}, handler);
        peopleProxy.eat("套餐");
    }

    //第二种创建代理的方式
    @Test
    public void testJdkProxy2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final IPeople referee = new Referee();
        final InvocationHandler handler = new PeopleInvocationHandler<>(referee);
        final Class<?> proxy = Proxy.getProxyClass(IPeople.class.getClassLoader(), IPeople.class);

        final Constructor<?> constructor = proxy.getConstructor(InvocationHandler.class);
        final IPeople refereeProxy = (IPeople) constructor.newInstance(handler);
        refereeProxy.eat("套餐加鸡腿");
    }
}
