package pattern.createobjectpattern;
/**
 *	抽象工厂（AbstractFactory）模式
 *	定义：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 *
 *	抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 *	使用场景：
 *	使用抽象工厂模式一般要满足以下条件。
 *	系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 *	系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 *
 *	优点：
 *	可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 *	当增加一个新的产品族时不需要修改原代码，满足开闭原则。
 *
 *	缺点：
 *	当产品族中需要增加一个新类型的产品时，所有的工厂类都需要进行修改。
 *
 *	抽象工厂模式与工厂方法模式基本类似。
 * @author JiaBing
 * @date 2019-09-25 16:31:30 
 */
public class AbstractFactoryPattern {

	public static void main(String[] args) {
		
		ElectricalFactory huaweiFactory = new HuaWeiFactory();
		huaweiFactory.newHandPhone();
		huaweiFactory.newPad();
		ElectricalFactory miFactory = new MiFactory();
		miFactory.newHandPhone();
		miFactory.newPad();
	}

}
/**
 * 	电器工厂
 */
interface ElectricalFactory{
	HandPhone newHandPhone();
	Pad newPad();
}
/**
 * 	手机
 */
interface HandPhone{}
/**
 *	平板电脑 
 */
interface Pad{}

/**
 * 	华为电子工厂
 */
class HuaWeiFactory implements ElectricalFactory{
	
	public HuaWeiFactory() {
		System.out.println("华为工厂");
	}
	
	@Override
	public HandPhone newHandPhone() {
		
		return new HuaWeiHandPhone();
	}

	@Override
	public Pad newPad() {
		
		return new HuaWeiPad();
	}
	
}

/**
 *	小米电子工厂
 */
class MiFactory implements ElectricalFactory{
	
	public MiFactory() {
		System.out.println("小米工厂");
	}
	
	@Override
	public HandPhone newHandPhone() {
	
		return new MiHandPhone();
	}

	@Override
	public Pad newPad() {
		return new MiPad();
	}
	
}

/**
 *	华为手机
 */
class HuaWeiHandPhone implements HandPhone{
	public HuaWeiHandPhone() {
		System.out.println("生产一个华为手机");
	}
}

/**
 *	小米手机
 */
class MiHandPhone implements HandPhone{
	public MiHandPhone() {
		System.out.println("生产一个小米手机");
	}
}

/**
 * 	华为平板电脑
 */
class HuaWeiPad implements Pad{
	public HuaWeiPad() {
		System.out.println("生产一个华为平板电脑");
	}
}

/**
 * 	小米平板电脑
 */
class MiPad implements Pad{
	public MiPad() {
		System.out.println("生产一个小米平板电脑");
	}
}


