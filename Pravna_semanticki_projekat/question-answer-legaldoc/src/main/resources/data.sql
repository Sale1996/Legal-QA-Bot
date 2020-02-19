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


INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (1,'Stav/Tačka');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (2,'Kazna');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (3,'Dozvola');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (4,'Član');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (5,'Izraz');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (6,'Elektronska usluga');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (7,'Ograničavanje slobode pružanja e-usluga');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (8,'Pružalac usluge');
INSERT INTO `legal_entity` (`legal_entity_id`,`legal_entity_name`) VALUES (9,'Komercijalna poruka');


INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (1,'Vrati sve nazive članova','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#> SELECT DISTINCT ?x WHERE { ?norm base:nazivClana ?x }',4);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (2,'Šta znaci izraz ???','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#> SELECT DISTINCT ?x WHERE { ?izraz base:opisIzraza ?x . ?izraz base:nazivIzraza \"???\" }',5);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (3,'Koji su razlozi ogranicavanja slobode pruzanja usluge?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#> SELECT DISTINCT ?x WHERE { ?ogranicenje base:razloziOgranicenja ?norme . ?norme base:tekstTacke ?x }',7);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (4,'Ukoliko je hitno ogranicavanje puzanja slobode usluge koliki broj dana treba da se obavesti o hitnoj meri?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#> SELECT DISTINCT ?x WHERE { ?ogranicenje base:hitnostOgranicavanja true . ?ogranicenje base:brojDanaZaObavestenje ?x }',7);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (5,'Da li je potrebna dozvola za elektronske usluge?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT ?x WHERE { ?usluga base:potrebnaDozvola ?x}',6);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (6,'Da li su dozvoljene prekogranicne elektronske usluge?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#> SELECT ?x WHERE { ?usluga base:prekogranicnaUsluga ?x}',6);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (7,'Ko preduzima mere ogranicavanja slobode pruzanja usluge elektronskog poslovanja?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT DISTINCT ?x WHERE { ?x base:preduzimaMereOgranicenja ?ogranicenja}',7);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (8,'Ko opoziva ogranicavanje slobode pruzanja usluge elektronskog poslovanja?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT DISTINCT ?x WHERE { ?x base:izdajeOpoziv ?opoziv}',7);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (9,'Koje informacije Pružalac usluge informacionog društva treba da pruži korisnicima?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT DISTINCT ?x WHERE { ?pruzanjeInf base:informacije ?norme . ?norme base:tekstTacke ?x}',8);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (10,'Koje odgovornosti snosi Pružalac usluge prenosa elektronske poruke?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT DISTINCT ?x WHERE { ?pruzalacEP base:snosiOdgovornost ?odgovornost . ?odgovornost base:tipOdgovornosti ?x}',8);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (11,'Koji je minimalan broj dana za cuvanje podataka korisnika od strane Pružalaca usluge prenosa elektronske poruke?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT DISTINCT ?x WHERE { ?puPrenosa base:imaObavezuCuvanja ?cuvanje . ?cuvanje base:rokCuvanjaPodataka ?x}',8);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (12,'Koji su obavezni podaci koji se Pružaoci usluge prenosa elektronske poruke moraju da čuvaju?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT DISTINCT ?x WHERE { ?puPrenosa base:imaObavezuCuvanja ?cuvanje . ?cuvanje base:obavezniPodaci ?podatak . ?podatak base:podaci ?x}',8);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (13,'Koje uslove mora zadovoljiti komercijalna poruka?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>SELECT ?x WHERE { ?poruka base:zadovoljavaUslove ?tacka . ?tacka base:tekstTacke ?x}',9);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (14,'Ako je neko prekrsio clan ??? stav ???, kolika je kazna?','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#> PREFIX lkif: <http://www.estrellaproject.org/lkif-core/expression.owl#> SELECT ?x ?y ?z WHERE { ?clan base:brojClana \'???\' .	?clan lkif:bears ?stav .	?stav base:brojStava ??? . ?prekrsaj base:prekrsenJe ?stav . ?prekrsaj base:kaznaOd ?y .	?prekrsaj base:kaznaDo ?z. ?prekrsaj base:pocinilac ?x }',2);
INSERT INTO `sparql_question` (`sparql_question_id`,`query_text`,`sparql_query_text`,`legal_entity`) VALUES (15,'Koji stav je prekrsen ukoliko je kazna izmedju ??? i ???','PREFIX base: <https://github.com/Sale1996/Legal-QA-Bot/blob/master/SerbianLaw.owl#>PREFIX lkif: <http://www.estrellaproject.org/lkif-core/expression.owl#>SELECT DISTINCT ?x WHERE { ?prekrsaj base:prekrsenJe ?x . ?x base:brojStava ?broj . ?prekrsaj base:kaznaOd ?min . ?prekrsaj base:kaznaDo ?max . FILTER (?min >= ???) FILTER (?max <= ???) }',1);


INSERT INTO `question_property` (`question_property_id`,`question_property_name`,`question_property_type`,`sparql_question`) VALUES (1,'nazivIzraza','Text',2);
INSERT INTO `question_property` (`question_property_id`,`question_property_name`,`question_property_type`,`sparql_question`) VALUES (2,'brojČlana','Number',14);
INSERT INTO `question_property` (`question_property_id`,`question_property_name`,`question_property_type`,`sparql_question`) VALUES (3,'brojStava','Number',14);
INSERT INTO `question_property` (`question_property_id`,`question_property_name`,`question_property_type`,`sparql_question`) VALUES (4,'kaznaOd','Number',15);
INSERT INTO `question_property` (`question_property_id`,`question_property_name`,`question_property_type`,`sparql_question`) VALUES (5,'kaznaDo','Number',15);
