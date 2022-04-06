make:
	@javac Project.java
	@clear
	@java Project
	@clear
clean:
	@rm -f *.class
	@rm -f *.json
	@rm -rf data
	@clear
