package pattern.createobjectpattern;
/**
 * 	原型（Prototype）模式
 * 	定义：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 
 * 	适用场景：
 * 	在有些系统中，存在大量相同或相似对象的创建问题，如果用传统的构造函数来创建对象，会比较复杂且耗时耗资源，用原型模式生成对象就很高效
 * 
 * @author JiaBing
 * @date 2019-09-25 10:49:36 
 */
public class PrototypePattern implements Cloneable{
	public PrototypePattern() {
		
	}
	
	@Override
	public PrototypePattern clone() throws CloneNotSupportedException {
		
		return (PrototypePattern) super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Person person = new Person(1001, "Kate", new Address("1001", "Amk"));
		Person clone = (Person) person.clone();
		System.out.println(person == clone);
		System.out.println(clone);
	}
}

class Person implements Cloneable{
	private long id;
	private String name;
	private Address address;
	
	public Person(long id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Person)super.clone();
	}
	
}
class Address{
	private String streetCode;
	private String streetName;
	
	public Address(String streetCode, String streetName) {
		this.streetCode = streetCode;
		this.streetName = streetName;
	}
	
	@Override
	public String toString() {
		return "Address [streetCode=" + streetCode + ", streetName=" + streetName + "]";
	}
	
}