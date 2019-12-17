.PHONY: build publish clean push

IMAGE         ?= eduardoarodrigues/basic
IMAGE_TAG     ?= grpc-1.3.jar

build:
	docker build . \
        --tag ${IMAGE}:${IMAGE_TAG}

publish: push

push:
    docker push ${IMAGE}:${IMAGE_TAG}

test:
	mvn clean test jacoco:report verify --debug

clean:
	rm ./grpc-1.1.jar || true