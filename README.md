# IOT_Project

To start the project:
1. Modify database configuration and add the correct username and password in application.properties file.
2. Start the server and the tables will get created.
3. Database export files can be found in  [/data](data).

For testing the required APIS endpoints kindly refer to  http://localhost:8090/swagger-ui.html
 
  
  
a. Returns all devices in the warehouse that are waiting for activation: GET  http://localhost:8090/v1/private/api/devices?statusId=2&pageNo=0

b. Management endpoints that enable the shop manager to remove or update a device
  configuration status.

  1. For updating device status use: PATCH http://localhost:8090/v1/private/api/device-status	
   ````json
  {
    "deviceId" : "1" ,
    "statusId": 5
  }  
  ````

  2. For updating from status lookup use : PATCH http://localhost:8090/v1/private/api/status
  ````json
  {
    "id": 0,
    "statusValue": "string"
  }
  ````
   3. For deleting from status lookup use : DELETE http://localhost:8090/v1/private/api/status?statusId=


c. Returns an ordered result of devices available for sale: GET  http://localhost:8090/v1/private/api/devices?pageNo=0&verified=true


