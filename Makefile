NAMESFILE ?= names.txt
LASTNAME  ?= ""

all: names Names.class

go names: names.go
	@go build names.go

java Names.class: Names.java
	@javac Names.java

rungo:
	@go run names.go $(NAMESFILE) $(LASTNAME)

runjava: Names.class
	@java Names $(NAMESFILE) $(LASTNAME)

runpy:
	@python names.py $(NAMESFILE) $(LASTNAME)

clean:
	@rm -f Names.class names

.PHONY: clean all go java rungo runjava runpy
