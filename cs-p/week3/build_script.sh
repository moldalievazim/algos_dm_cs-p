#!/bin/bash

echo "Welcome to my Build Script!"

firstline=$(head -n 1 source/changelog.md)
read -a splitfirstline <<< $firstline
version=${splitfirstline[1]}
echo "You are building version" $version
echo "If you want to make any change to the version enter 1(to continue), otherwise 0"
read versioncontinue

if [ $versioncontinue -eq 1 ]
then
  for filename in source/*
    do
      # echo $filename
     if [ "$filename" == "source/secretinfo.md" ] 
      then 
        echo "copying and replacing the number in" $filename
        cp $filename
        sed 's/42/XX/g' /$filename
      else
        # echo "Copying" $filename
        cp $filename build/.
      fi
    done
else 
  echo "Please come back when youre ready"
fi

cd build/
echo "Build version $version contains:"
ls
cd ..


for file