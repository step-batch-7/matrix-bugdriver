#! /bin/bash

rm -rf out
mkdir out
javac -cp .:testLib/junit-4.13.1.jar:testLib/hamcrest-core-1.3.jar -d out $(find . -name "*.java")