package fr.romain_neil.valwin;

import fr.romain_neil.valwin.core.tools.AbstractTool;
import java.util.List;

/**
 * @author Romain Neil
 * @version 1.0.1
 */
public class Utils {

	/**
	 * Return the item index in the list, by the tool name, or -1
	 * @param list the tools list
	 * @param name the tool name to look for
	 * @return the item index, or -1
	 */
	public static int getIndexByToolName(List<AbstractTool> list, String name) {
		int index = 0;

		for(AbstractTool tool : list) {
			if(tool.getName().equals(name)) {
				return index;
			}

			index++;
		}

		return -1;
	}

}
