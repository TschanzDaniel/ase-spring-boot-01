#!/bin/bash

echo "curl http://localhost:8080/home/method0";
curl http://localhost:8080/home/method0;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home";
curl http://localhost:8080/home;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/xyz";
curl http://localhost:8080/home/xyz;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/method1";
curl http://localhost:8080/home/method1;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/method1/second";
curl http://localhost:8080/home/method1/second;
printf "\n\n*****\n\n";

echo "curl -X POST http://localhost:8080/home/method2";
curl -X POST http://localhost:8080/home/method2;
printf "\n\n*****\n\n";

echo "curl -X POST http://localhost:8080/home/method3";
curl -X POST http://localhost:8080/home/method3;
printf "\n\n*****\n\n";

echo "curl -X GET http://localhost:8080/home/method3";
curl -X GET http://localhost:8080/home/method3;
printf "\n\n*****\n\n";

echo "curl -H "name:hallovelo" http://localhost:8080/home/method4";
curl -H "name:hallovelo" http://localhost:8080/home/method4;
printf "\n\n*****\n\n";

echo "curl -H "name:hallovelo" -H "id:1" http://localhost:8080/home/method5";
curl -H "name:hallovelo" -H "id:1" http://localhost:8080/home/method5;
printf "\n\n*****\n\n";

echo "curl -H "Content-Type:text/html" http://localhost:8080/home/method6";
curl -H "Content-Type:text/html" http://localhost:8080/home/method6;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/method6";
curl http://localhost:8080/home/method6;
printf "\n\n*****\n\n";

echo "curl -H "Content-Type:text/html" -H "Accept:application/json" -i http://localhost:8080/home/method6";
curl -H "Content-Type:text/html" -H "Accept:application/json" -i http://localhost:8080/home/method6;
printf "\n\n*****\n\n";

echo "curl -H "Content-Type:text/html" -H "Accept:application/xml" -i http://localhost:8080/home/method6";
curl -H "Content-Type:text/html" -H "Accept:application/xml" -i http://localhost:8080/home/method6;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/method7/1";
curl http://localhost:8080/home/method7/1;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/method8/10/Lisa";
curl http://localhost:8080/home/method8/10/Lisa;
printf "\n\n*****\n\n";

echo "curl http://localhost:8080/home/method9?id=20";
curl http://localhost:8080/home/method9?id=20;
printf "\n\n*****DONE*****\n\n";