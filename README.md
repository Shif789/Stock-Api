# Stock-Api
This is a microservices project which includes mutiple monolithic projects. Created using spring rest, spring web, spring data jpa, eureka server, h2 database, lombok, api-gateway.
Download them in the same forlder.
Run the eureka server first.
Then run the rest.
On the browser type "http://localhost:8761/". This will display eureka server ui page. Instances of the other projects registered to this server(eureka client) will be shown to identify which projects are running
On the browser "http://localhost:7777/STOCK-UI/ui/"
To know the company name and price check the data.sql file in the resource folder of Stock-Service project.
