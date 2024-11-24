package com.digital.common_lib.enums;

public class UserStoreEnum {

	public enum UserStoreStatus {
		Y("Active"), N("InActive");

		private String nameShow;

		private UserStoreStatus(String nameShow) {
			this.nameShow = nameShow;
		}

		public String getNameShow() {
			return this.nameShow;
		}
	}
}
