package net.devsedge.resourceboundle.fromclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;

public class Labels_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "fam", new ArrayList<String>(Arrays.asList("Brother", "Sister")) }, 
			{ "wor", new ArrayList<String>(Arrays.asList("Employee", "Boss")) }, };
	}

}