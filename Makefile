
java_code = src/*.java src/control/*.java src/entities/*.java src/actions/*.java src/states/*.java \
            src/utils/*.java src/GUI/*.java
all: run

run:
	make out
	sh run.sh

out: $(java_code)
	-rm -rf out
	mkdir out
	javac -d out $(java_code)

zip_requirements = graph/ src/ Makefile run.sh FinalProject/ FinalProject.asta
project.zip: $(zip_requirements)
	-rm project.zip
	zip project.zip -r $(zip_requirements)

unzip_requirements = source.zip 037.zip
src: $(unzip_requirements)
	ls $(unzip_requirements)
	sh unzip.sh "$(unzip_requirements)"