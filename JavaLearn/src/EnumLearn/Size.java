package EnumLearn;

public enum Size{
	//定义所有枚举值
	SMALL("S"), MEDIUM("M"), LARGE("L"),EXTREMELARGE("XL");
	//定义枚举值的缩写
	private String abbreviation;
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation(){
		return abbreviation;
	}
}