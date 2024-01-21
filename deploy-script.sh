./mvnw clean package

cd ./bookkeeper-service-alarms
sh build.sh
cd ../
cd ./bookkeeper-service-info
cd ../
sh build.sh
cd ./bookkeeper-service-mgmt
cd ../
sh build.sh