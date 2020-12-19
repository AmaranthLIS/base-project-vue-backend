APP?=rest-admin
PORT?=9080

BUILD_TIME?=$(shell date -u '+%Y-%m-%d_%H:%M:%S')



.DEFAULT_GOAL := prepare

# ----- ----- ----- ----- -----
prepare:
	@echo "Choose command: \n - run \n - test \n - assemble \n - push \n - clean \n - deploy \n - cur_time \n - assemble-graal \n - build-docker"

clean:
	./gradlew clean
	#rm -f ${APP}

run:
	MICRONAUT_SERVER_PORT=${PORT} ./gradlew clean run --args="micronaut.server.port=${PORT}"
	# ./gradlew -Dmicronaut.environments=dev run -t

assemble:
	./gradlew clean build
	#./gradlew assemble

assemble-graal:	#switches to use GraalVM CE 20.3.0 as a base image
	./gradlew dockerBuildNative


test:
	./gradlew cleanTest test


build-docker:
	./gradlew dockerBuild

run-jar: assemble
	java -Dmicronaut.server.port=8080 -Dmicronaut.environments=foo,dev -jar ./foo.jar

push:
	@echo "soon impl"

deploy:
	@echo "soon impl"
