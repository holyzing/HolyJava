package com.holy.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * invoke：vt. 调用；祈求；引起；恳求
 * @author hadoop
 *
 */
public class MyProxy{
	@Test
	public void testProxy() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//1:创建一个目标类的对象 目标对象由实现接口或对应类引用不受影响
		Target target = new TargetObj();
		//2:创建执行处理类 的对象，并将目标类的对象注入
		IInvocationHandler<Target> iInvocationHandler = new IInvocationHandler<Target>(target);
		
		//3:获取到代理对象 之所以可以进行强转是因为代理类和目标类都实现了目标接口
		//Target newProxyInstance1 = (Target)iInvocationHandler.returnProxy();
		//4：调用代理对象实现接口的目标方法
		//System.out.println(newProxyInstance1.targetMethod("李丹阳"));
		
		Object newProxyInstance2 = newProxyInstance(Target.class, iInvocationHandler);
		Target target1 = (Target)newProxyInstance2;
		System.out.println(target1.targetMethod("刘淑仪"));
		
		Target2 target2 = (Target2)newProxyInstance2;
		System.out.println(target2.targetMethod2(5));
		
		//已添加接口到接口组中，但是委托类并没有实现 ，代理类实现了
		/*object is not an instance of declaring class  / Unknown Source
		TestProxy target = (TestProxy)newProxyInstance2;
		System.out.println(target2.testProxyMethod());*/
		
		//即使目标类实现了接口，如果没有加入到提供给Proxy的接口组中，代理类也不会实现
		/*ClassCastException: com.holy.dao.$Proxy4
		Target3 target3 = (Target3)newProxyInstance2;
		System.out.println(target3.targetMethod3(5));*/
		
		
	}
	/**
	 *（所谓动态：
	 *就是在运行时获得 具体执行处理类 的类型 this）
	 */
	public  Object newProxyInstance(Class<?> clazz,InvocationHandler handler) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		/*0：生成$Proxy0的class文件   com\sun\proxy 
		 * eclipse的jvm启动项里加入-verbose:class ，打印load的class*/
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); 
		/*1：提供将要被代理的接口信息（类加载器，字节码）进行封装 生成动态代理类 
		 *   1.1：提供接口信息是为了限定代理类是由这些接口变量引用的*/ 
		Class<?> proxyClass = Proxy.getProxyClass(clazz.getClassLoader(), Target2.class,clazz,TestProxy.class);
		
		/*2：通过源码知道构造器需要提供参数，通过反射获取到 动态代理类 的构造器，
		 *   parameterTypes:一组参数类型 动态参数 */
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
		/*3：提供具体 执行处理类，生成代理实例，注意该代理实例不是执行处理类的实例*/
		
		Object newProxyInstance = constructor.newInstance(handler); 
		
		System.out.println(proxyClass.getSuperclass().getName()+"--"+proxyClass.getName());
		System.out.println("------------------------------------------");
		Method[] methods = proxyClass.getMethods();
		Class<?>[] interfaces = proxyClass.getInterfaces();
		for(Class i:interfaces) {
			System.out.println(i.getName());
		}
		for(Method method:methods) {
			System.out.println(method.getName()+":"+method.getReturnType());
			/**
			 * jdk1.7反射中没有 parameter
			 */
			//method.invoke(newProxyInstance, handler); 参数类型显然无法匹配
			//Parameter[] parameters = method.getParameters();
			//for(Parameter parameter:parameters) {
				//System.out.println(parameter.getName()+":"+parameter.getType());
			//}
		}
		System.out.println("---------------------------------------");
		Field[] fields = proxyClass.getFields();
		for(Field field:fields) {
			System.out.println(field.getName()+"----"+field.getType());
		}
		
		return newProxyInstance;
	}
}
/**
 * 具有特定增强功能的执行处理类
 */
class IInvocationHandler<T> implements InvocationHandler{
	private T target;   
	public  IInvocationHandler(T target) {
		this.target=target;
	}
	@Override
	public Object invoke(
			Object proxy,  //
			Method method, //
			Object[] args) //
					throws Throwable {
		System.out.println("--------目标方法前：说我爱你马伊琍-------------");
		Object result = method.invoke(target, args);
		System.out.println("--------目标方法后：说我爱你邓紫棋-------------");
		return result;
	}

	public Object returnProxy() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*
		 * Proxy。newInstance方法是使用ProxyGenerator来直接动态生成字节码的，
		 */
		// Proxy类的静态方法     
		return Proxy.newProxyInstance(
				// 获取当前线程的类加载器以便加载接口的class文件，
				// 注意理解类加载器的作用 类加载器从上到下按 路径 加载
				Thread.currentThread().getContextClassLoader(),
				// 目标类所实现的接口及其迭代的一组接口
				target.getClass().getInterfaces(),
				// this:调用该方法的对象，也就是当前执行处理类的 对象
				this);
	}
}
 
/**目标方法所在接口*/
interface Target{
	String targetMethod(String name);
}
interface Target2{
	int targetMethod2(int i);
}
interface Target3{
	String targetMethod3(int i);
}
/**实现接口的目标类*/
class TargetObj implements Target,Target2,Target3{
	int i = 0;
	@Override
	public String targetMethod(String name) {
		System.out.println("执行目标类（对象）中的方法时 说我爱你");
		return "我爱你"+name;
	}
	@Override
	public int targetMethod2(int i) {
		System.out.println("第二个接口方法");
		return i;
	}
	@Override
	public String targetMethod3(int i) {
		System.out.println("第二个接口方法");
		return "i";
	}
}
