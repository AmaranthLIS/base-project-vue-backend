APP?=rest-admin
PORT?=9080

BUILD_TIME?=$(shell date -u '+%Y-%m-%d_%H:%M:%S')



.DEFAULT_GOAL := prepare

# ----- ----- ----- ----- -----
prepare:
	@echo "Choose command: \n - run \n - test \n - assemble \n - push \n - clean \n - deploy \n - cur_time \n - init"

clean:
	./gradlew clean
	#rm -f ${APP}

run:
	MICRONAUT_SERVER_PORT=${PORT} ./gradlew clean run --args="micronaut.server.port=${PORT}"
# ./gradlew -Dmicronaut.environments=dev run -t
#./gradlew run --args="-endpoints.health.enabled=true -config.property=test"



#java -Dmicronaut.server.port=7070 -jar ./foo.jar
# 'gradle run -Dmicronaut.environments=dev'
#'gradle run --args="-Dmicronaut.environments=dev"' does not work,

#$ java -Dmicronaut.environments=foo,bar -jar myapp.jar






#./gradlew run -t
#./gradlew assemble

#./gradlew dockerBuild
#switches to use GraalVM CE 20.3.0 as a base image
#./gradlew dockerBuildNative
