# Legal-QA-Bot

# Front-end
Neophodno je instalirati:
- Visual Studio Code - https://code.visualstudio.com/
- NodeJS - https://nodejs.org/en/
- AngularCLI
- Angular

Nakon toga uraditi npm-install kako bi se povukli dependencies.
Nakon toga se build-uje sa ng build (mora se pokrenuti i backend).
Ukoliko zelite pokrenuti samo frontend, komanda je ng serve i pokrece se na http://localhost:4200

# Back-end

Za izradu projekta korisceno je:
- Java + Spring (Radno okruzenje Eclipse IDE 2020 - https://www.eclipse.org/downloads/)
- Neophodno je skinuti Maven dependency-je koji se nalaze u pom.xml fajlu.

Za skladištenje podataka korišćena je MySql baza.
- Potrebno je skinuti MySql server - https://dev.mysql.com/downloads/mysql/ i MySql workbench - https://dev.mysql.com/downloads/workbench/
- Treba napraviti semu sa nazivom "semanticweb".
- U application.properties treba uneti username i password.

Da bi se uspešno pokrenula aplikacija neophodno je 
- Build-ovati klijenta koji se nalazi na: https://github.com/Sale1996/Legal-QA-Bot/tree/master/Pravna_semanticki_projekat/question-answer-legaldoc
- Pokrenuti backend u radnom okruženju.
- Pošto je ubačena i db skripta za punjenje podacima, u application.properties ostaviti property: 
    spring.jpa.hibernate.ddl-auto=create
- Iz tog razloga, ukoliko se primene izmene podataka tokom rada projekta neophodno je uraditi 2 stvari da bi se podaci sačuvali:
    - U application.properties treba promeniti property na: spring.jpa.hibernate.ddl-auto=create
    - U db skripti 'data.sql' treba zakomentarisati INSERT naredbe koje liče sledećoj: 
          INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (1,1);
Aplikacija se pokreće na https://localhost:8080
