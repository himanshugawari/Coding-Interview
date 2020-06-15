package in.himanshugawari.java.javaprogrammingmasterclass.innerclass.innerclass1;

// 1  static nested class
// 2  non-static nested class (inner class)
// 3  local class (inner class defined inside a scope block i.e method )
// 4  anonymous class(nested class without a class name)


public class Main {
	public static void main(String[] args) {
		/*GearBox mcLaren=new GearBox(6);
		GearBox.Gear first=mcLaren.new Gear(1,12.3);
		System.out.println(first.driveSpeed(1000));
		
		GearBox.Gear second=new GearBox(6).new Gear(1,12.3);
		System.out.println(second.driveSpeed(1000));*/
		
		GearBox mcLaren=new GearBox(6);
		//added in gearbox constructor
		/*mcLaren.addGear(1, 5.3);
		mcLaren.addGear(2, 10.6);
		mcLaren.addGear(3, 15.9);*/
		mcLaren.operateClutch(true);
		mcLaren.changeGear(1);
		mcLaren.operateClutch(false);
		System.out.println(mcLaren.wheelSpeed(1000));
		mcLaren.changeGear(2);
		System.out.println(mcLaren.wheelSpeed(3000));
		mcLaren.operateClutch(true);
		mcLaren.changeGear(3);
		mcLaren.operateClutch(false);
		System.out.println(mcLaren.wheelSpeed(6000));
	}
}
