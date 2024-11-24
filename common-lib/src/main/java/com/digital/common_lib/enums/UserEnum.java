package com.digital.common_lib.enums;

public class UserEnum {

	public enum UserType {
		A("Admin"), SO("ShopOwner"), CU("Customer");

		private String nameShow;

		private UserType(String nameShow) {
			this.nameShow = nameShow;
		}

		public String getNameShow() {
			return this.nameShow;
		}
	}
}
