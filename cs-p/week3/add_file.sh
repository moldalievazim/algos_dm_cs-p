#!/usr/bin/env bash

project_dir="$( "$( cs-p "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

# shellcheck disable=SC2164
cd "$project_dir"
echo "project_dir is: $project_dir"
git add .
git commit -m "Added new files"
git push origin master