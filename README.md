### OBO STADIUM WEBSITE
Trang thương mại điện tử bán giày

### Run app with docker-compose
```shell
docker build -t ecommerce-spring .
docker-compose up -d
```

### Run app with docker without docker-compose
```shell
docker build -t ecommerce-spring .
docker ps
docker run -d mysql:latest
docker run -d ecommerce-spring:latest
```

### Catch logs of container, run "run docker ps" to show container are running. find container_id that you want to see logs, then run docker logs with -t for timestamp and -f for following
```shell
docker ps
docker logs -t -d <container_id>
```

### Chạy app bằng maven

```shell
mvn spring-boot:run
```

### Mockup dữ liệu ban đầu

Import file ```obo.sql``` vào MySQL. Sử dụng 2 account sau để đăng nhập vào web:

- Admin account:
    - Username: doanptand@gmail.com
    - Password: 123456
- Member account:
    - Username: doanpt93cntt@gmail.com
    - Password: 123456
    

Truy cập ```/admin``` để vào trang admin.

### Built with
- [Java Spring](https://spring.io/) - The web framework used
- [Maven](https://mvnrepository.com/) - Dependency Management