package cn.itcast.text;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	@Value("阿斯顿.马丁")
	private String name;
	@Value("掉渣灰")
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

}
