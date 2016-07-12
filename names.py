#!/usr/bin/env python
#
# Copyright (c) 2011 jesus m. rodriguez
#
# This software is licensed to you under the GNU General Public License,
# version 2 (GPLv2). There is NO WARRANTY for this software, express or
# implied, including the implied warranties of MERCHANTABILITY or FITNESS
# FOR A PARTICULAR PURPOSE. You should have received a copy of GPLv2
# along with this software; if not, see
# http://www.gnu.org/licenses/old-licenses/gpl-2.0.txt.
#

import sys

lastname = None

if len(sys.argv) < 2:
    print "Usage: names.py [filename]"
    sys.exit(-1)

if len(sys.argv) > 2:
    lastname = sys.argv[2]

file = open(sys.argv[1])

names = []
while 1:
    line = file.readline()
    name = line.rstrip()
    if name != '':
        names.append(name)
    if not line:
        break

names.sort()

for firstname in names:
    for middlename in names:
        if firstname != middlename:
            if not lastname:
                print "%s %s" % (firstname, middlename)
            else:
                print "%s %s %s - %s%s%s" % (
                    firstname, middlename, lastname,
                    firstname[:1], middlename[:1], lastname[:1])
