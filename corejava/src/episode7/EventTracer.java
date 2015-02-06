package episode7;

import java.awt.Component;
import java.awt.Container;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EventTracer
{
	/*
	 * 跟踪AWT事件
	 */
	private InvocationHandler handler;


	public EventTracer()
	{
		handler = new InvocationHandler()
		{

			@Override
			public Object invoke(Object obj, Method method, Object[] aobj) throws Throwable
			{
				System.out.println( method + ":" + aobj[0] );
				return null;
			}
		};
	}


	public void add(Component c)
	{
		try
		{
			// Introspector 类为通过工具学习有关受目标 Java Bean 支持的属性、事件和方法的知识提供了一个标准方法
			// 在 Java Bean 上进行内省，了解其所有属性、公开的方法和事件
			BeanInfo info = Introspector.getBeanInfo( c.getClass() );

			// 描述给定 Java bean 激发的一组事件的 EventSetDescriptor
			EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
			for ( EventSetDescriptor eventSet : eventSets )
			{
				addListener( c, eventSet );
			}
		}
		catch (Exception e)
		{
		}
		if (c instanceof Container)
		{// get all children and call and recursively
			for ( Component comp : ((Container) c).getComponents() )
			{
				add( comp );
			}
		}
	}


	// add a listener to the given event set
	public void addListener(Component c, EventSetDescriptor eventSet)
	{
		Object proxy = Proxy.newProxyInstance( null, new Class[] { eventSet.getListenerType() }, handler );
		Method addListenerMethod = eventSet.getAddListenerMethod();
		try
		{
			addListenerMethod.invoke( c, proxy );
		}
		catch (Exception e)
		{
		}
	}
}
