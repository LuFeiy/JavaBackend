package java_3_advanced.ad_3_type_information;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 定义一个接口
interface MyInterface {
    void performAction();
}

// 实现InvocationHandler接口，用于处理代理的方法调用
class MyInvocationHandler implements InvocationHandler {
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在调用实际方法前可以添加自定义行为
        System.out.println("Before method: " + method.getName());

        // 调用实际对象的方法
        Object result = method.invoke(target, args);

        // 在调用实际方法后可以添加自定义行为
        System.out.println("After method: " + method.getName());

        return result;
    }
}


//static proxy
interface ServiceInterface {
    void doSomething();
}

class RealService implements ServiceInterface {
    @Override
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

class StaticProxy implements ServiceInterface {

    private ServiceInterface realService;

    public StaticProxy(ServiceInterface realService) {
        this.realService = realService;
    }

    @Override
    public void doSomething() {
        System.out.println("Before doing something...");
        this.realService.doSomething();
        System.out.println("After doing something...");
    }
}


//dynamic proxy
class DynamicProxyHandler implements InvocationHandler {
    private final Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before doing something...");
        Object result = method.invoke(target, args);
        System.out.println("After doing something...");
        return result;
    }
}

//two interfaces
interface AnotherInterface {
    void doAnotherThing();
}

class RealServices2 implements ServiceInterface, AnotherInterface {
    @Override
    public void doSomething() {
        System.out.println("Doing something in ServiceInterface...");

    }

    @Override
    public void doAnotherThing() {
        System.out.println("Doing another thing in AnotherInterface...");

    }
}



public class ProxyExample {

    @Test
    public void test_01(){

       // 创建实现接口的匿名类实例
        MyInterface original = new MyInterface() {
            @Override
            public void performAction() {
                System.out.println("Action performed");
            }
        };

        //创建InvocationHandler
        InvocationHandler invocationHandler = new MyInvocationHandler(original);

        // 创建代理类实例
        MyInterface proxyInstance = (MyInterface)Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                invocationHandler
        );

        //通过代理对象调用方法
        proxyInstance.performAction();

    }


    //static proxy test
    @Test
    public void test_02(){
        RealService realService = new RealService();

        StaticProxy staticProxy = new StaticProxy(realService);

        staticProxy.doSomething();
    }


    @Test
    public void test_03(){
        RealService realService = new RealService();
        ServiceInterface proxyInstance = (ServiceInterface)Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                new Class[]{ServiceInterface.class},
                new DynamicProxyHandler(realService)
        );
        proxyInstance.doSomething();
    }


    @Test
    public void test_04(){
        RealServices2 realServices2 = new RealServices2();

        Object proxyInstance = Proxy.newProxyInstance(
                RealService.class.getClassLoader(),
                new Class[]{ServiceInterface.class, AnotherInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before doing something...");
                        Object result = method.invoke(realServices2, args);
                        System.out.println("After doing something...");
                        return result;
                    }
                }
        );


        ServiceInterface serviceInterface = (ServiceInterface) proxyInstance;
        serviceInterface.doSomething();
        ((AnotherInterface) proxyInstance).doAnotherThing();

    }

}
