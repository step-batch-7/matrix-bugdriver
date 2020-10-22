#! /bin/bash

rm -rf out
mkdir out
javac -cp .:junit-4.13.1.jar:hamcrest-core-1.3.jar -d out $(find . -name "*.java")