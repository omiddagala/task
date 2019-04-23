
get token in terminal  and use access key in swagger
curl "http://food_apps@localhost:9000/security/oauth/token" -d "grant_type=password&username=maysam&password=﻿12341234"
curl "http://food_apps@192.168.1.42:9000/security/oauth/token" -d "grant_type=password&username=maysam&password=123456"
curl "http://food_apps@192.168.1.42:9000/security/oauth/token" -d "grant_type=password&username=company&password=12345678"
curl "http://food_apps@192.168.1.42:9000/security/oauth/token" -d "grant_type=password&username=admin&password=123456"



Swagger address
http://192.168.1.107:9000/   // http://192.168.1.107:9000/pepper/v2/api-docs
http://192.168.1.107:9000/    //  http://192.168.1.107:9000/accounting/v2/api-docs


Eureka address // registered micro services
http://localhost:9010/




BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

if (!encoder.matches(dto.getOldPassword(), authorizedUser.getPassword()))
            throw new ServiceException("Submitted password is not valid", ErrorCodes.ACCESS_DENIED.getCode());









