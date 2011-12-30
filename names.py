#!/usr/bin/env python
import sys

lastname = None

if len(sys.argv) < 2:
    print "Usage: names.py [filename]"

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

for firstname in names:
    for middlename in names:
        if firstname != middlename:
            if not lastname:
                print "%s %s" % (firstname, middlename)
            else:
                print "%s %s %s" % (firstname, middlename, lastname)
