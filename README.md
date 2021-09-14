## Micronaut 3.0.1 Documentation

- [User Guide](https://docs.micronaut.io/3.0.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.0.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.0.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

**Tech Stack used**

- micronaut framework
- java 11
- H2 inmemory database

**Starting application**

- go to Application.java in src/main/java/com/hospital/Application.java and run 
  
- csv data is preloaded in src/main/java/com/hospital/DataLoader.java upon application startup





EndPoints:

1)Get all appointments for the given doctor & date:
(localhostport)/doctor/get-appointments

sample json:
{
"doctorName": "D1Name",
"date": "2018-03-08"
}




2)Fix appointment by patient, doctor and date & time:
(localhostport)/doctor/fix-appointments

sample json:
{
"patientName": "P1Name",
"doctorName": "D1Name",
"localDateTime": "2032-03-08T09:00:00"
}



3)Cancel appointment by patient, doctor and date & time:
(localhostport)/doctor/cancel-appointments

sample json:
{
"patientName": "P1Name",
"doctorName": "D1Name",
"localDateTime": "2018-03-08T09:00:00"
}





