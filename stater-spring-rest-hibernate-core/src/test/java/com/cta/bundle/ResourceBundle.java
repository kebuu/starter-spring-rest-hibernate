package com.cta.bundle;


import java.util.ListResourceBundle;

public class ResourceBundle extends ListResourceBundle {

	public static final String CANCEL_KEY = "CancelKey";
	public static final String OK_KEY = "OkKey";

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
	             {OK_KEY, "OK"},
	             {CANCEL_KEY, "Cancel"}
	        };

	}
}
