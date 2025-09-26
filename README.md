# POC - CCE - DEMO

## Crear imagen docker del servicio

* Crear imagen docker (situarse en la carpeta raiz)

```shell
#docker build -f <module>/Dockerfile -t sebastianbran/poc-cce-directory-service .
docker build -f directory/Dockerfile -t sebastianbran/poc-cce-demo-directory-service .

#Con podman
podman build -f directory/Dockerfile -t docker.io/sebastianbran/poc-cce-demo-directory-service .
```

## Crear recursos de kubernetes

* Ir a la carpeta **kubernetes**

```shell
cd kubernetes
```

* Crear la infraestructura

```shell
kubectl apply -f .
```

## Forward de puertos

* Realizar el forward de puertos para acceder a los servicios desde el localhost

```shell
kubectl port-forward svc/transaction-service-svc 8080:8080

kubectl port-forward svc/directory-service-svc 8081:8080

kubectl port-forward svc/notification-service-svc 8082:8080
```