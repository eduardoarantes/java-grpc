.PHONY: build publish clean push

IMAGE         ?= eduardoarodrigues/basic
IMAGE_TAG     ?= grpc-1.3.jar

build:
	docker build . \
        --tag ${IMAGE}:${IMAGE_TAG}
    docker push ${IMAGE}:${IMAGE_TAG}

publish: build

push:
    docker push ${IMAGE}:${IMAGE_TAG}

clean:
	rm ./grpc-1.1.jar || true