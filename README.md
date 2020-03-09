# ClientServerDatabase

1) Listens to the new User entries on port 8080

- **http://localhost:8080/userLoginPage**

- ![LOGINPAGE](https://sun9-14.userapi.com/c857132/v857132856/1103f3/DNq-pHtmsno.jpg)

2) Stores them in UserLocalDB.txt in JSON format

3) Updates local H2 Database with new the entry

  - **http://localhost:8080/h2-console/**
 
4) On every start of the application uploads all the previous entries to H2 from the UserLocalDB.txt
