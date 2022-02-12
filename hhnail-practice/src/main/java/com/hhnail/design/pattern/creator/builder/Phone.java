package com.hhnail.design.pattern.creator.builder;

public class Phone {

	private String cpu;
	private String screen;
	private String memory;
	private String mainboard;

	private Phone(Builder builder){
		this.cpu = builder.cpu;
		this.screen = builder.screen;
		this.memory = builder.memory;
		this.mainboard = builder.mainBoard;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"cpu='" + cpu + '\'' +
				", screen='" + screen + '\'' +
				", memory='" + memory + '\'' +
				", mainboard='" + mainboard + '\'' +
				'}';
	}

	/**
	 * 静态内部类
	 */
	public static final class Builder{
		private String cpu;
		private String screen;
		private String memory;
		private String mainBoard;

		public Builder(){}

		public Builder setCpu(String cpu){
			this.cpu = cpu;
			return this;
		}
		public Builder setScreen(String screen){
			this.screen = screen;
			return this;
		}
		public Builder setMemory(String memory){
			this.memory = memory;
			return this;
		}
		public Builder setMainBoard(String mainBoard){
			this.mainBoard = mainBoard;
			return this;
		}
		public Phone build(){
			return new Phone(this);
		}
	}
}
