package pattern.createobjectpattern;
/**
 *	 工厂方法（FactoryMethod）模式
 *	定义：定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类中。这满足创建型模式中所要求的“创建与使用相分离”的特点
 *
 *	特点：
 *	用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程
 *	在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则
 *	
 *	不足：
 *	每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
 *	
 * @author JiaBing
 * @date 2019-09-25 14:45:17 
 */
public class FactoryMethodPattern {
	public static void main(String[] args) {
		AbstractFactory factory1 = new ConcreteFactory1();
		AbstractFactory factory2 = new ConcreteFactory2();
		Product product1 = factory1.newProduct();
		Product product2 = factory2.newProduct();
		product1.show();
		product2.show();
	}
}

interface Product{
	void show();
}

interface AbstractFactory{
	Product newProduct();
}

class ConcreteProduct1 implements Product{

	@Override
	public void show() {
		System.out.println("ConcreteProduct1 show()");
		
	}
	
}
class ConcreteFactory1 implements AbstractFactory{

	@Override
	public Product newProduct() {
		return new ConcreteProduct1();
	}
	
}
class ConcreteProduct2 implements Product{

	@Override
	public void show() {
		System.out.println("ConcreteProduct2 show()");
		
	}
	
}
class ConcreteFactory2 implements AbstractFactory{

	@Override
	public Product newProduct() {
		return new ConcreteProduct2();
	}
	
}

