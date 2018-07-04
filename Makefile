NAMESFILE ?= names.txt
LASTNAME  ?= ""

all: names Names.class ## builds all compilable languages

go names: names.go ## builds names executable
	@go build names.go

java Names.class: Names.java ## builds java tool
	@javac Names.java

rungo: ## runs golang
	@go run names.go $(NAMESFILE) $(LASTNAME)

runjava: Names.class ## runs java
	@java Names $(NAMESFILE) $(LASTNAME)

runpy: ## runs python
	@python names.py $(NAMESFILE) $(LASTNAME)

clean: ## cleans up executables
	@rm -f Names.class names

help: ## Show this help screen
	@echo 'Usage: make <OPTIONS> ... <TARGETS>'
	@echo ''
	@echo 'Available targets are:'
	@echo ''
	@grep -E '^[\. a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-20s\033[0m %s\n", $$1, $$2}'
	@echo ''

.PHONY: help clean all go java rungo runjava runpy
