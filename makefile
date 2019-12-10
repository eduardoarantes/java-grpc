.PHONY: build publish clean

IMAGE         ?= eduardoarodrigues/basic
IMAGE_TAG     ?= grpc-1.3.jar

build:
	docker build . \
        --tag ${IMAGE}:${IMAGE_TAG}
    docker push ${IMAGE}:${IMAGE_TAG}

publish: build

clean:
	rm ./grpc-1.1.jar || true