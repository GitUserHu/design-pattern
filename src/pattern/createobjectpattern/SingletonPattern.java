package pattern.createobjectpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Singleton 单例模式<p>
 *	定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。
 *
 *	特点：
 *	1、单例类只有一个实例对象
 *	2、该单例对象必须由单例类自行创建
 *	3、单例类对外提供一个访问该单例的全局访问点
 *	
 *	应用场景：
 *		某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
 *		当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
 *		当某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。
 * @author JiaBing
 * @date 2019-09-25 10:03:08 
 */

public class SingletonPattern {
	
	private static final SingletonPattern single = new SingletonPattern(); 
	
	private SingletonPattern() {
		
	}
	
	public static SingletonPattern getInstance() {
		return single;
	}
}

/**
 * 	懒加载单例模式
 *
 */
class SingletonPatternLazy{
	
	private static volatile SingletonPatternLazy singleLazy; // 保证在多线程中同步
	
	private SingletonPatternLazy() {} // private修饰符保证不能在外部被实例化
	
	public static synchronized SingletonPatternLazy getInstance() {
		if (singleLazy == null) {
			singleLazy = new SingletonPatternLazy();
		}
		return singleLazy;
	}
}

/**
 *    扩展
 * MultitonPattern创建10个实例，获取MultitonPattern实例时随机获取。
 */
class MultitonPattern{
	private static final int size =10;
	private int num;
	private static final List<MultitonPattern> multitons;
	static{
		multitons = new ArrayList<MultitonPattern>();
		for (int i = 0; i < size; i++) {
			multitons.add(new MultitonPattern(i));
		}
	}
	private MultitonPattern(int num) { 
		this.num = num;
	}
	
	public MultitonPattern getRandomInstance() {
		int randomVal = (int) (Math.random()*size);
		return multitons.get(randomVal);
	}
}