package pattern.constructpattern;
/**
 * @author JiaBing
 * @date 2019-10-23 14:46:12 
 * 	案例描述： 新能源汽车的发动机有电能发动机（Electric Motor）和光能发动机（Optical Motor）等，各种发动机的驱动方法不同。
 * 		例如，电能发动机的驱动方法 electricDrive() 是用电能驱动，而光能发动机的驱动方法 opticalDrive() 是用光能驱动，
 * 		它们是适配器模式中被访问的适配者。
 *	客户端希望用统一的发动机驱动方法 drive() 访问这两种发动机。
 *	所以必须定义一个统一的目标接口 Motor，然后再定义电能适配器（Electric Adapter）和光能适配器（Optical Adapter）去适配这两种发动机。
 */
public class AdapterPattern {
	public static void main(String[] args) {
		drive(new ElectricAdapter());
		drive(new OpticalAdapter());
	}
	
	public static void drive(Motor motor) {
		motor.drive();
	}
}

interface Motor{
	public void drive();
}

class ElectricMotor{
	public void electricDrive() {
		
	}
}

class OpticalMotor{
	public void opticalDrive() {
		
	}
}

class ElectricAdapter implements Motor{
	private ElectricMotor electricMotor;
	public ElectricAdapter() {
		electricMotor = new ElectricMotor();
	}
	@Override
	public void drive() {
		electricMotor.electricDrive();	
	}
	
}

class OpticalAdapter implements Motor{
	private OpticalMotor opticalMotor;
	public OpticalAdapter() {
		opticalMotor = new OpticalMotor();
	}
	@Override
	public void drive() {
		opticalMotor.opticalDrive();
	}
}
