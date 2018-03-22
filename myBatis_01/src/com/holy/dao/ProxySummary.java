package com.holy.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * 知识点：代理 反射 类加载 native proxyClassCache
 * 
 * @author hadoop
 *
 */
public class ProxySummary {
	@Test
	public void summary() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*1:在运行时 生成代理类的字节码 所谓动态指的就是在运行时生成代理类*/
		Class<?> proxyClass = Proxy.getProxyClass(
				/*该加载器就是将jvm生成的字节码加载到内存，生成Class类的实例
				 *由proxyClass.getName()知道加载路径为当前源码文件所在包，*/
				Thread.currentThread().getContextClassLoader(),
				/*由proxyClass.getInterfaces();知道proxyClass所对应的类，
				 *实现了所有提供的接口，且继承了Proxy类*/
				Target.class, Target2.class,TestProxy.class);
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
		Object newInstance = constructor.newInstance(new IInvocationHandler(new TargetObj()));
	}
	/*2：源码跟踪：
	 * 	2.1 Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces)
	 * 		内容：Java的安全检查
	 *      返回：getProxyClass0(loader, intfs);
	 *  2.2 Class<?> getProxyClass0(loader, intfs);
	 *      内容：判断接口个数，
	 *      返回：proxyClassCache.get(loader, interfaces);
	 *      说明：文档注释：a cache of proxy classes Proxy类的成员变量
	 *      	 WeakCache<ClassLoader, Class<?>[], Class<?>> proxyClassCache
	 *           // If the proxy class defined by the given loader implementing
        		 // the given interfaces exists, this will simply return the cached copy;
        		 // otherwise, it will create the proxy class via the ProxyClassFactory
        2.3  private static final class ProxyClassFactory
        			implements BiFunction<ClassLoader, Class<?>[], Class<?>>
        	 内容：各种对接口的遍历各种调用defineClass0（Proxy类本地方法生成二进制的字节码流）
        	      生成的字节流加载为Class，由
        	      private static final String proxyClassNamePrefix = "$Proxy";
        	      知道每生成一个代理的Class会以末尾数字编号 测例 com.holy.dao.$Proxy4
        3：是如何调用 invoke方法的 
        	3.1 protected InvocationHandler h;
        		protected InvocationHandler h;
        		private Proxy() {}
    			Proxy(InvocationHandler h) {
        			Objects.requireNonNull(h);
        			this.h = h;
    			}
    		直接new显然是不可能的，只能通过反射构造一个实例了，或者反射执行一个方法
    		因为代理类实现了所有的接口方法，且由
    		public static Object newProxyInstance(
    		ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
    		知道在实例化时将invocationHandler传入，那么很显然由父类Proxy的成员变量h
    		接收，那么所实现的接口方法中很显然就调用了invoke方法。经反编译该class可证实
    		3.2通过反射构造也知道构造函数需要接收参数InvocationHandler
    	4：反射获取代理类的成员方法知道 重写了 equals toString hashCode
    */
}
class IH implements InvocationHandler{
	public Object invoke(
			Object proxy,    
				//Object proxy = this
			Method method, 
				//被调用方法的接口必须被一个类实现才能反射执行，因为 
				//反射Method的invoke（）方法 需要传入一个方法所在类的实例
			Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	  Object invoke = method.invoke(new TargetObj(), args);
    	  return invoke;
      }
	/*
	private static Method m1;
    private static Method m2;
    private static Method m4;
    private static Method m3;
    private static Method m0; 
    public $Proxy20(final InvocationHandler invocationHandler) {
        super(invocationHandler);
    }
    static {
        try {
            $Proxy20.m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            $Proxy20.m2 = Class.forName("java.lang.Object").getMethod("toString", (Class<?>[])new Class[0]);
            $Proxy20.m4 = Class.forName("com.test.reflect.Scholar").getMethod("infoLocal", (Class<?>[])new Class[0]);
            $Proxy20.m3 = Class.forName("com.test.reflect.Scholar").getMethod("searching", Class.forName("java.lang.String"));
            $Proxy20.m0 = Class.forName("java.lang.Object").getMethod("hashCode", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException ex) {
            throw new NoSuchMethodError(ex.getMessage());
        }
        catch (ClassNotFoundException ex2) {
            throw new NoClassDefFoundError(ex2.getMessage());
        }
    }
    public final String infoLocal() {
        try {
            return (String)super.h.invoke(this, $Proxy20.m4, null);
        }
        catch (Error | RuntimeException error) {
            throw;
        }
        catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }

    public final String searching(final String s) {
        try {
            return (String)super.h.invoke(this, $Proxy20.m3, new Object[] { s });
        }
        catch (Error | RuntimeException error) {
            throw;
        }
        catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }
    */
	/**
	 * 在动态生成代理类时，为每一个方法生成一个Method，当代理类调用方法时，
	 * 就会调用构造时传入的且由Proxy中h接收的InvocationHandler中的invoke方法
	 * 传入的参数：当前代理实例，已经为接口中方法生成的“同名”Method，以及由外部传入的参数列表
	 * 
	 * are you mingbai？ 
	 * 
	 * 关键信息：Method中分装的方法信息包括 除去方法体的任何信息，所以要反射调用 Method的 invoke
	 * 方法的时候就需要 传入具有完全相同方法签名的实例，及其参数列表（显然参数列表是有严格顺序要求的！！）
	 * 否则就会报  Unknown Source 这显然是反射中的问题了
	 * */
	//参数则由同名方法传入的参数
	//接口引用代理类，运行时指向实例 代理对象 调用代理对象的实现方法 
}
