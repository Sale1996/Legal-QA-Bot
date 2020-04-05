use semanticweb;


INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (1,'user@example.com',b'1','Marko','Markovic','2020-02-14 12:15:48.123000','$2a$10$DhFbbEIBJ7eqvLBRUx6mt.wQzW1UNRsFtCGvDAGkjlgr4CyCspgwK','lawyer',b'0');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (2,'admin@example.com',b'1','Nikola','Nikolic','2017-10-01 00:00:00.000000','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','admin',b'0');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (3,'pcloadlett1er@gmail.com',b'1','Veljko1','Petroviccc','2020-02-06 17:01:06.391000','$2a$10$X2qGxEpDYvm8/3tvNkqVvunpsvHkbNQ9L/2omlFS1dJbwXd/QlWb.','pcloadletter',b'0');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (4,'markomarkovic@gmail.com',b'1','marko','markovic','2020-02-10 16:55:47.755000','$2a$10$3NlswH7BvX2NsWjswEu6wuz3v1jl2HzGLrZZmsBh/S5ur40jxO0zq','admin2',b'1');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (5,'danijelvenus@gmail.com',b'1','Danijel','Venus','2020-02-10 16:56:49.849000','$2a$10$6XgziGMEXZ48cdp15ljjhOYItFGrJDChI2vSc0H4SQJK6QxvsffE.','skidampoene',b'1');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (6,'brankoperisic@gmail.com',b'1','Branko','Perisic','2020-02-10 16:58:19.301000','$2a$10$dZe6uVCQFN1RrYji7hEH/e13zwW/xTsdcrRJ3.6Ph6UkkLh.lvpji','ducksick',b'0');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (7,'test@email.com',b'1','test','test','2020-02-14 12:22:52.090000','$2a$10$coJMBTUT8eLRCFTIOZKmiOxOZRtGygCwawm5NTdDx0g3dlU0rP.Z.','admin3',b'0');
INSERT INTO `users` (`id`,`email`,`enabled`,`first_name`,`last_name`,`last_password_reset_date`,`password`,`username`,`deleted`) VALUES (8,'test@gmail.com',b'1','test1','test2','2020-02-14 12:24:40.699000','$2a$10$TWavayQALXqOzw9IGTvtBunR4qDfIr18oMaC6vyI29bbDrj8R27ei','sparql1',b'0');


INSERT INTO `authority` (`id`,`name`) VALUES (1,'ROLE_LAWYER');
INSERT INTO `authority` (`id`,`name`) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authority` (`id`,`name`) VALUES (3,'ROLE_SPARQLSPECIALIST');


INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (2,2);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (1,1);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (3,1);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (4,2);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (5,1);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (6,3);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (7,2);
INSERT INTO `user_authority` (`user_id`,`authority_id`) VALUES (8,3);


INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (1,'Zakon');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (2,'Komercijalna poruka');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (3,'Elektronska usluga');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (4,'Ograničavanje slobode pružanja e-usluga');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (5,'Pružalac usluga');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (6,'Izrazi');


INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (1,'Na koga utiče zakon o elektronskoj trgovini?','SELECT DISTINCT ?x WHERE { ?norme expression:addressee ?x }',1);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (2,'Šta jedna komercijalna poruka mora da zadovolji?','SELECT DISTINCT ?x WHERE { ?obliged rdfs:label \'Duznost - definicija komercijalne poruke\' . ?obliged base:XML_URI ?x }',2);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (3,'Šta je ??? ?','SELECT DISTINCT ?x WHERE { ?definicije rdfs:label \'Definicije zakona o elektronskoj trgovini\' . ?def mereology:member ?definicije . ?def rdfs:label \'Definicija: ???\' . ?def base:XML_URI ?x }',6);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (4,'U kojim Službenim glasnicima je ovaj zakon objavljivan?','SELECT DISTINCT ?x WHERE { ?zakon process:participant_in ?sg . ?sg rdfs:comment ?x }',1);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (5,'Koje su moje dužnosti kao pružaoca usluga informacionog sistema pri sklapanju ugovora?','SELECT DISTINCT ?x ?y WHERE { {	?norma norm:allows ?duznost . ?norma rdfs:label \'Norma -  zakljucenje ugovora sa potencijalnim korisnikom usluga\' . ?duznost base:XML_URI ?x . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y } UNION { ?norma norm:allows ?duznost . ?norma rdfs:label \'Norma - dostupnost teksta ugovora\' . ?duznost base:XML_URI ?x . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y } }',5);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (6,'Kad ministarstvo može da mi ograniči slobodu pružanja usluga?','SELECT DISTINCT ?x WHERE { ?reason rdfs:label \'Razlozi ogranicavanja slobode pruzanja usluge\' . ?reason base:XML_URI ?x }',4);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (7,'Da li ja smem da šaljem email ili sms poruke ljudima koji mi nisu dali pristanak?','SELECT DISTINCT ?x ?y WHERE { ?doz expression:towards ?norma . ?doz rdfs:label \'Dozvola - slanje komercijalne poruke\' . ?doz base:XML_URI ?x . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y }',5);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (8,'Da li sam ja, kao pružalac usluga informacionog društva (npr. vlasnik Kupujem-prodajem), odgovoran na nedozvoljeno delovanje mojih korisnika?','SELECT DISTINCT ?x ?y WHERE { { ?duznost rdfs:label \'Duznost pruzaoca usluga - obavestavanje nadleznog organa\' . ?duznost base:XML_URI ?x . ?norma norm:allows ?duznost . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y } UNION { ?duznost rdfs:label \'Iskljucenje odgovornosti - nedopusteno delovanje korisnika usluga\' . ?duznost base:XML_URI ?x } }',5);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (9,'U kojoj valuti treba da bude cena robe?','SELECT DISTINCT ?x WHERE { ?duznost rdfs:label \'Duznost pruzaoca usluga - navodjenje cena\' . ?duznost base:XML_URI ?x }',3);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (10,'Prilikom prodaje, koje informacije sam ja dužan da dam korisniku?','SELECT DISTINCT ?x ?y WHERE { ?duznost rdfs:label \'Duznost pruzaoca usluge informacionog drustva -  zakljucenje ugovora sa potencijalnim korisnikom usluga\' . ?duznost base:XML_URI ?x . ?norma norm:allows ?duznost . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y }',5);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (12,'Da li se zakon primenjuje na \"igre na sreću\"?','SELECT DISTINCT ?x WHERE { ?obl rdfs:label \'Oblasti na koje se zakon ne primenjuje\' . ?obl base:XML_URI ?x }',1);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (13,'Da li je dozvoljena prekogranična usluga informacionog drustva?','SELECT DISTINCT ?x WHERE { ?z rdfs:label \'Prekogranicna usluga informacionog drustva\' . ?z base:XML_URI ?x }',3);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (14,'Ko obaveštava operatora elektronskih komunikacija da mora onemogućiti pristup uslugama?','SELECT DISTINCT ?x ?y WHERE { ?z rdfs:label \'Nadzor nad primenom zakona\' . ?z base:XML_URI ?x . ?norma norm:allows ?z . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y }',4);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (15,'Ukoliko je meni sloboda pružanja usluge ograničena, da li postoji nekakva opcija da se to opozove/kako ide opoziv?','SELECT DISTINCT ?x WHERE { ?z rdfs:label \'Opoziv ogranicavanja slobode pruzanja usluge\' . ?z base:XML_URI ?x }',4);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (16,'Imam internet stranicu i neko je postavio nešto što ja mislim da nije dopušteno. Da li smem da to izbrišem bez dozvole nadležnog organa?','SELECT DISTINCT ?x ?y WHERE { ?z rdfs:label \'Duznost pruzaoca usluge informacionog drustva - uklanjanje nedopustenog sadrzaja\' . ?z base:XML_URI ?x . ?norma norm:allows ?z . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y }',5);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (17,'Da li sam u obavezi da obrišem sadržaj ukoliko dobijem zahtev od trećeg lica da ga obrišem jer misli da je nedopušteni sadžaj?','SELECT DISTINCT ?x ?y WHERE { ?z rdfs:label \'Duznost pruzaoca usluge informacionog drustva - uklanjanje nedopustenog sadrzaja na zahtev treceg lica\' . ?z base:XML_URI ?x . ?norma norm:allows ?z . ?prekrsaj expression:evaluates ?norma . ?prekrsaj base:XML_URI ?y }',5);


INSERT INTO `question_property` (`question_property_id`,`question_property_name`,`question_property_type`,`sparql_question`) VALUES (1,'nazivIzraza','Text',3);