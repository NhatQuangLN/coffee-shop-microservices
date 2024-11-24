package com.digital.common_lib.enums;

public class MenuEnum {

	public enum MenuStatus {
		Y("Active"), N("InActive");

		private String nameShow;

		private MenuStatus(String nameShow) {
			this.nameShow = nameShow;
		}

		public String getNameShow() {
			return this.nameShow;
		}
	}
}
