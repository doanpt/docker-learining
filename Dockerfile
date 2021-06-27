FROM maven:latest
RUN mkdir /ecommerce
WORKDIR /ecommerce
COPY . .
EXPOSE 8080
CMD ["mvn", "spring-boot-run"]