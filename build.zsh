#GRAALVM_HOME=/home/evacchi/.jabba/jdk/graalvm@1.0.0-11
#GRAALVM_HOME=$HOME/Apps/jdk/graalvm-ce-1.0.0-rc10
GRAALVM_HOME=/home/evacchi/Devel/graal/graal/vm/latest_graalvm_home

NATIVE_IMAGE=$GRAALVM_HOME/bin/native-image
PROJECT=/home/evacchi/Devel/redhat/pr/qs-playground
MAVEN=/home/evacchi/.m2/repository/

cp=(
    $PROJECT/playground/target/classes
    $PROJECT/jbpm/jbpm-flow-builder/target/classes
    $PROJECT/drools/drools-compiler/target/classes
    $PROJECT/drools/drools-core-reflective/target/classes
    $PROJECT/drools/drools-core/target/classes
    $PROJECT/drools/drools-core-static/target/classes
    $PROJECT/api/kie-api/target/classes
    $PROJECT/api/kie-internal/target/classes
    $PROJECT/jbpm/jbpm-flow/target/classes
    $PROJECT/drools/kie-dmn/kie-dmn-api/target/classes
    $PROJECT/drools/kie-dmn/kie-dmn-model/target/classes
    $MAVEN/org/antlr/antlr-runtime/3.5.2/antlr-runtime-3.5.2.jar
    $MAVEN/org/eclipse/jdt/core/compiler/ecj/4.6.1/ecj-4.6.1.jar
    $MAVEN/com/thoughtworks/xstream/xstream/1.4.10/xstream-1.4.10.jar
    $MAVEN/xmlpull/xmlpull/1.1.3.1/xmlpull-1.1.3.1.jar
    $MAVEN/xpp3/xpp3_min/1.1.4c/xpp3_min-1.1.4c.jar
    $MAVEN/org/mvel/mvel2/2.4.3.Final/mvel2-2.4.3.Final.jar
    $MAVEN/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar
    $MAVEN/org/slf4j/slf4j-simple/1.7.25/slf4j-simple-1.7.25.jar
    $MAVEN/com/google/protobuf/protobuf-java/3.6.1/protobuf-java-3.6.1.jar
)

$NATIVE_IMAGE -H:ReflectionConfigurationFiles=reflection.json --language:js -classpath ${(j.:.)${cp}} org.kie.playground.Main

#time java -classpath ${(j.:.)${cp}} org.jbpm.graal.playground.Main


