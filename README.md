

Testing GRPC with REST  
  
References:  
  
* https://spring.io/blog/2015/03/22/using-google-protocol-buffers-with-spring-mvc-based-rest-services  
* https://thenewstack.io/build-real-world-microservices-with-grpc/  
  
  
Tools   
  
* gRPC Client: https://github.com/uw-labs/bloomrpc  

* gRPC Gateway: https://github.com/grpc-ecosystem/grpc-gateway

   it generates gRPC and REST endpoints at the same time
  
Considerations:  
  
* Load Balancing: https://kubernetes.io/blog/2018/11/07/grpc-load-balancing-on-kubernetes-without-tears/  
* Monitoring: https://github.com/grpc/grpc/blob/master/doc/health-checking.md  
* authorizatoin: https://sultanov.dev/blog/securing-java-grpc-services-with-jwt-based-authentication/  
  
  
Running on K8s  
  
1.  installing kubectl

    Download the latest release with the command
	
    `brew install kubectl `
    
    Test to ensure the version you installed is up-to-date:  
      
    `kubectl version`
  
  
2.  Installing minikube
  
    `brew install minikube`