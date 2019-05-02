1) there is a folder with specific structure and docker files in it, attached to the email. build project and copy each jar file to the corresponding folder with the exact same name.

2) in your OS's host file add host name 'discovery' and map it to 127.0.0.1

3) now go to the directory which docker-compose file exists, and run the project with 'docker-compose up' command and wait until all services are discovered by discovery service.

4) by using a rest test tool, create some accounts :
    method : post
    headers :
        Accept : application/json
        Content-Type : application/json
        Cache-Control : no-cache
    url : http://127.0.0.1:9000/accounting/v1/account/create
    data(1) : {"name":"omid","accountId":"1","currencyType":"USD","amount":1000}
    data(2) : {"name":"ali","accountId":"2","currencyType":"EUR","amount":1000}

    now you have created two accounts :)

5) transfer some money from account id 1 to account id 2 :
    method : post
        headers :
            Accept : application/json
            Content-Type : application/json
            Cache-Control : no-cache
    url : http://127.0.0.1:9000/accounting/v1/account/transfer
    data : {"sourceAccountId":"1","destinationAccountId":"2","amount":200}

    by this transfer, a record is inserted in a table named 'transaction'

6) now you can see the log of the transaction by this api :
    method : post
    url : http://127.0.0.1:9000/logger/v1/log/list


I've handled data consistency by using optimistic lock using a version field in Account entity.


