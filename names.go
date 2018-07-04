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

package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
)

var lastname string

func main() {
	var names []string

	if len(os.Args) < 2 {
		fmt.Println("Usage: names [filename]")
		os.Exit(-1)
	}

	if len(os.Args) > 2 {
		lastname = os.Args[2]
	}

	file, err := os.Open(os.Args[1])
	if err != nil {
		fmt.Println(err)
		os.Exit(-1)
	}

	rdr := bufio.NewReader(file)

	for {
		line, _, err := rdr.ReadLine()
		if err != nil {
			if err != io.EOF {
				fmt.Printf("error reading file: %v\n", err)
			}
			break
		}

		name := string(line)
		if name != "" {
			names = append(names, name)
		}
		if line == nil {
			break
		}
	}

	sort.Strings(names)

	for _, firstname := range names {
		for _, middlename := range names {
			if firstname != middlename {
				if lastname == "" {
					fmt.Printf("%s %s\n", firstname, middlename)
				} else {
					fmt.Printf("%s %s %s - %s%s%s\n",
						firstname, middlename, lastname,
						firstname[:1], middlename[:1], lastname[:1])
				}
			}
		}
	}
}
