****This is Intuit home work assigment

Installation guidelenes- 
MySQL
    1) Install MySql on your local machine or use allready installed version you have``
    2) Define new schema - intuit
    3)Run db.sql script(commited with the project) in order to create a new table
    4) Change in module - risk-> application.properties to your connection details of mySql

Kafka -
 For WIndows
    1)Download binary jar - https://www.apache.org/dyn/closer.cgi?path=/kafka/1.0.1/kafka_2.11-1.0.1.tgz
    2)Create in kafka extracted folder(7 Zip works well for extraction) two new folders - zookeeper and logs
    3)go to config\server.properties and change log.dirs= {log folder} and config\zookeeper.properties change dataDir={zookeeper folder} and change the folder. the new folder need to be write with / and not .
    	
    4)Start zookeper
    	bin\windows\zookeeper-server-start.bat config\zookeeper.properties
    5)Start Kafka
    	bin\windows\kafka-server-start.bat config\server.properties
 For OsX/Linux - instructions on kafka site. The scripts are under bin floder and not
      bin\windows
      
      
Project -
    Two modules - 
        payments- Recieve payments via RestAPI - PaymentController and sends them to Kafka
        risk- Consumes messages from kafka. Runs RiskEngine and saves to DB 
