#!/bin/bash
JAR_FILE="target/eurofins-genomics-0.0.1-SNAPSHOT.jar"
PODMAN_IMAGE_NAME="eurofins"
docker build -t $PODMAN_IMAGE_NAME .
docker run -p 8080:8080 $PODMAN_IMAGE_NAME