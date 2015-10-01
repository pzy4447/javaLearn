package EnumLearn;

public class Device {
	DeviceType dvcType;
	public DeviceType getType() {
		return dvcType;
	}
	
	public Device(DeviceType type){
		dvcType = type;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Device d1 = new Device(DeviceType.PC);
		Device d2 = new Device(DeviceType.ROUTER);
		Device d3 = new Device(DeviceType.SERVER);
		
		System.out.println(d1.getType());
		System.out.println(d2.getType());
		System.out.println(d3.getType());
		
		System.out.println(d1.getType().ordinal());
		System.out.println(d2.getType().ordinal());
		System.out.println(d3.getType().ordinal());
	}
	
	
}
