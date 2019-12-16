Testing GRPC with REST  
  
References:  
  
* https://spring.io/blog/2015/03/22/using-google-protocol-buffers-with-spring-mvc-based-rest-services  
* https://thenewstack.io/build-real-world-microservices-with-grpc/  
* https://matthewpalmer.net/kubernetes-app-developer/articles/
  
  
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
    
    Tutorial: https://kubernetes.io/docs/tutorials/hello-minikube/
    

3. Installing K8s dashboard

    installing the app
        
        kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta6/aio/deploy/recommended.yaml

    creating user

         kubectl apply -f src/main/resources/dashboard-adminuser.yaml
    
    You can access Dashboard using the kubectl command-line tool by running the following command:

        kubectl proxy
         
    get Bearer Token
     
        kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')
        
    Now copy the token and paste it into Enter token field on login screen.
    


4. Configure ingress

   https://medium.com/@Oskarr3/setting-up-ingress-on-minikube-6ae825e98f82

        echo "$(minikube ip) grpc.info" | sudo tee -a /etc/hosts
        
        

  https://kubernetes.io/docs/reference/kubectl/cheatsheet/#interacting-with-running-pods