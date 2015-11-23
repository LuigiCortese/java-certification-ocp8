package net.devsedge.resourceboundle.fromclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;

public class Labels_it extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "fam", new ArrayList<String>(Arrays.asList("Fratello", "Sorella")) }, 
			{ "wor", new ArrayList<String>(Arrays.asList("Impiegato", "Capo")) }, };
	}

}
