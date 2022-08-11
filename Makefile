.ONESHELL:
SHELL := /bin/bash
.SHELLFLAGS := -o pipefail -euc

DOCKER_IMAGE_TAG = 'spark-scala'

# build Docker image
.PHONY: docker/build
docker/build:
	@echo "\n== docker/build\n"
	docker build -t $(DOCKER_IMAGE_TAG) .

# run Docker image mounting the current directory
# NOTE: do not override the entrypoint as spark-shell may fail to run due to .ivy location
# NOTE: run spark-shell to access Spark web UI at http://localhost:4040/
.PHONY: docker/run
docker/run:
	@echo "\n== docker/run\n"
	docker run -it --rm --mount src="$$(pwd)",target=/workspaces,type=bind -p 4040:4040 $(DOCKER_IMAGE_TAG) /bin/bash

#  export PATH=${PATH}:/opt/spark/bin
