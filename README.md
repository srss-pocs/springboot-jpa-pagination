A Simple Spring Boot JPA Pagination application

Start the application
Insert Few records using below APIs

POST API :
http://localhost:8080/api/products
{
"name":"A1 smartwatch",
"price":28000,
"description":"Health Check Smart Watch",
"productType":"Watches"
}

GET API : http://localhost:8080/api/products/pagination/0/10 [Page No=0 and Records Per Page=10]