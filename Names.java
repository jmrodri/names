
/*
 * Copyright (c) 2018 jesus m. rodriguez
 *
 * This software is licensed to you under the GNU General Public License,
 * version 2 (GPLv2). There is NO WARRANTY for this software, express or
 * implied, including the implied warranties of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. You should have received a copy of GPLv2
 * along with this software; if not, see
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.txt.
 */

import java.io.*;
import java.util.*;

public class Names {
    static String lastname = "";

    public static void main(String[] args) throws Exception {
        List<String> names = new ArrayList<String>();

        if (args.length < 1) {
            System.out.println("Usage: java Names [filename] [lastname]");
            System.exit(-1);
        }

        if (args.length > 1) {
		    lastname = args[1];
        }

        BufferedReader br = new BufferedReader(
                new FileReader(new File(args[0])));

        String line;
        while ((line = br.readLine()) != null) {
            if (line == null) {
                break;
            }

            String name = line.trim();
            if (name != "") {
                names.add(name);
            }
        }

	    Collections.sort(names);

        for (String firstname: names) {
            for (String middlename: names) {
                if (firstname != middlename) {
                    String msg;
                    if (lastname.equals("")) {
					    msg = String.format("%s %s\n", firstname, middlename);
                    } else {
                        System.out.println("[" + firstname + "]");
                        System.out.println("[" + middlename + "]");
                        System.out.println("[" + lastname + "]");
					    msg = String.format("%s %s %s - %s%s%s\n",
						    firstname, middlename, lastname,
                            String.valueOf(firstname.charAt(0)),
                            String.valueOf(middlename.charAt(0)),
                            String.valueOf(lastname.charAt(0)));
                    }
                    System.out.print(msg);
                }
            }
        }
    }
}
