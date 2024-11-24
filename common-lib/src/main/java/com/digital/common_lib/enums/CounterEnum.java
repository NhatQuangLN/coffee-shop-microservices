package com.digital.common_lib.enums;

public class CounterEnum {

	public enum CounterStatus {
		Y("Active"), N("InActive");

		private String nameShow;

		private CounterStatus(String nameShow) {
			this.nameShow = nameShow;
		}

		public String getNameShow() {
			return this.nameShow;
		}
	}
}
