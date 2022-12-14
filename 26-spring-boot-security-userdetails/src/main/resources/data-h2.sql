SET @TEASER = '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus quis blandit eros. Morbi tincidunt varius sem, quis lacinia mauris ullamcorper a. Vivamus a ipsum libero. Donec lorem diam, varius ut metus ut, commodo hendrerit nulla. Sed tellus nisl, gravida vestibulum odio ut, ullamcorper scelerisque felis. In interdum pharetra odio, non fringilla diam. Nulla vitae velit quis nisl mattis pulvinar vel a tellus. In non nibh feugiat orci tincidunt iaculis ut at ipsum. Duis ac sodales nisl. Suspendisse vitae nibh dapibus tellus suscipit porttitor eget id orci. Morbi consectetur, nunc a posuere viverra, ex felis gravida ante, quis vulputate sapien dolor nec odio. Integer pretium felis dapibus nisi luctus vulputate eget eget ipsum. Vivamus cursus mollis sollicitudin. In dapibus, quam ac elementum condimentum, lorem mi laoreet lorem, eget interdum mi orci finibus erat. Proin porta vehicula blandit. Sed posuere ante ut dictum mattis.</p>';
SET @BODY = '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eu arcu sit amet mauris egestas dignissim. Morbi non congue turpis. Curabitur elit sapien, mattis non diam vitae, lobortis pulvinar ex. Phasellus posuere in diam et luctus. Aliquam in magna consectetur, mollis turpis sed, placerat tortor. Integer sed lacinia diam. Duis sem lacus, placerat eu diam vitae, semper auctor sem. Quisque faucibus viverra sem id suscipit. Morbi maximus consectetur sem et aliquam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque egestas a ligula non ornare. Donec venenatis accumsan lectus, sed egestas eros facilisis vitae. Cras auctor non tellus sollicitudin rutrum. Curabitur finibus cursus leo, et tincidunt purus dignissim a. Sed imperdiet cursus sapien nec facilisis.</p><p>Mauris volutpat euismod finibus. Praesent ipsum massa, pellentesque a aliquam at, pretium id diam. Donec vel est sed dolor blandit laoreet ut nec ipsum. Suspendisse viverra hendrerit ligula quis volutpat. Cras vestibulum ornare finibus. Nam a tincidunt odio, vitae placerat massa. Vestibulum ullamcorper nunc viverra lacus luctus, quis placerat massa vehicula. In vulputate purus lorem, eget vulputate elit pulvinar eget. Nullam blandit tellus eu suscipit accumsan. Nam orci diam, maximus sed ornare quis, vulputate vitae sapien. Vivamus faucibus quam blandit mauris blandit, a commodo arcu semper.</p><p>Nam hendrerit est metus, ut condimentum ipsum fermentum vitae. Integer placerat, neque sit amet vehicula posuere, orci lacus congue ipsum, sed ultrices tortor leo sed erat. Cras quam elit, hendrerit et nunc eget, molestie pharetra quam. Suspendisse luctus quam et faucibus imperdiet. Sed varius mauris dui, ut lacinia nisl accumsan a. Vivamus sit amet diam egestas, viverra tellus a, iaculis velit. Praesent ac tellus ac neque auctor condimentum sagittis pellentesque massa. Aenean arcu est, rutrum vitae lacus aliquam, auctor consectetur enim. Proin magna eros, imperdiet id mauris ac, malesuada tincidunt nunc. Aliquam erat volutpat.</p>';

insert into `user` (`id`,`email`,`full_name`,`password`) values (1,'admin@admin.ch','admin','admin');
insert into `user` (`id`,`email`,`full_name`,`password`) values (2,'user@user.ch','user','user');
insert into `role` (`id`,`role`) values (1,'ROLE_ADMIN');
insert into `role` (`id`,`role`) values (2,'ROLE_USER');
insert into `user_role` (`user_id`,`role_id`) values (1,1);
insert into `user_role` (`user_id`,`role_id`) values (2,2);


insert into `author` (`id`,`first_name`,`last_name`,`email`) values (1,'Felix','Muster','Felix.Muster@example.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (2,'Matthias','Bachmann','M.Bachmann@united-portal.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (3,'Wendy','Guthrie','nunc@semper.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (4,'Yeo','Collins','adipiscing@convallis.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (5,'Tara','Aguilar','felis.purus.ac@gravidaPraesenteu.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (6,'Yolanda','Strickland','fringilla.Donec@sitametorci.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (7,'Joan','Joyce','risus@sedturpisnec.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (8,'Kane','Knapp','pede.et@utaliquam.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (9,'Olivia','Hebert','sed.sapien@eleifendegestas.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (10,'Gregory','Lynn','consequat@laciniaatiaculis.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (11,'Elvis','Hodges','nibh@etultricesposuere.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (12,'Octavius','Johnston','hendrerit.neque@etpede.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (13,'Jenna','Bailey','pretium.aliquet@nec.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (14,'Shoshana','Pollard','mus.Proin@ac.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (15,'Elliott','Cohen','sit@orciPhasellus.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (16,'Scarlett','Frost','Phasellus.elit@Pellentesque.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (17,'Kirestin','Pierce','fringilla.purus@semmolestie.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (18,'Zachery','Livingston','pharetra.Quisque@turpisnecmauris.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (19,'Eliana','Horton','sociis@Innecorci.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (20,'Kirestin','Lowery','tristique@sem.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (21,'Hammett','Wise','nascetur.ridiculus.mus@arcuVestibulumut.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (22,'Winter','Fleming','ultrices.Duis@mauris.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (23,'Joseph','Lloyd','Morbi.neque.tellus@sapienAenean.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (24,'Howard','Daniels','ac.mi.eleifend@eget.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (25,'Harlan','Massey','egestas.a.scelerisque@vitaeodio.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (26,'Simone','Lowe','sapien@Donecdignissimmagna.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (27,'Kermit','English','In.mi@Cumsociisnatoque.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (28,'Raya','Trujillo','Mauris@tellus.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (29,'Connor','Sanders','In.nec.orci@sodalesat.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (30,'Fredericka','Mullins','bibendum.ullamcorper.Duis@Pellentesque.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (31,'Cain','Sherman','cubilia.Curae.Donec@velitPellentesque.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (32,'Gannon','Trevino','enim.commodo@Curabitur.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (33,'Xanthus','Merritt','at.arcu.Vestibulum@scelerisqueneque.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (34,'Brendan','Kent','euismod@eros.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (35,'Blaine','Ballard','ac.facilisis@velitCras.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (36,'Patrick','Cruz','sit.amet@ornareelitelit.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (37,'Erich','Tyler','sodales@magna.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (38,'Ruth','Wallace','vestibulum.Mauris.magna@Proin.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (39,'Leonard','Booker','nec.metus.facilisis@nulla.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (40,'Alden','Doyle','a.aliquet.vel@tristiquealiquetPhasellus.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (41,'Kennedy','Kerr','iaculis.enim.sit@dictum.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (42,'Henry','Nash','mattis.Integer.eu@hendrerit.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (43,'Jordan','Ratliff','et.netus@sem.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (44,'Keith','Watson','Nullam.velit.dui@ametconsectetuer.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (45,'Miranda','Montoya','lacinia@Duis.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (46,'Yolanda','Dickerson','ipsum.Phasellus@justofaucibuslectus.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (47,'Helen','Monroe','ullamcorper.nisl.arcu@elitAliquam.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (48,'Knox','Vega','ullamcorper.Duis@vel.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (49,'Ronan','Rowland','elit@mi.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (50,'Bruce','Cervantes','nunc.interdum@feugiat.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (51,'Darrel','Macdonald','sollicitudin@dictumeueleifend.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (52,'Rafael','Duran','natoque.penatibus.et@Suspendisse.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (53,'Griffin','Maddox','ut.odio.vel@Fusce.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (54,'Inga','Bryant','vulputate.nisi@Nullam.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (55,'Lee','Klein','sagittis@metusVivamuseuismod.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (56,'Bradley','Holman','tristique@Quisqueporttitoreros.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (57,'Lacy','Leonard','id.ante@quamquisdiam.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (58,'India','Preston','sem.elit.pharetra@facilisisnon.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (59,'Raphael','Perkins','tempus.non.lacinia@fermentumfermentumarcu.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (60,'Kristen','Turner','facilisi.Sed.neque@ante.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (61,'Aurora','Shepherd','vulputate@tellusnon.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (62,'Zia','Matthews','ornare@imperdietdictum.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (63,'Candice','Gardner','eu@natoque.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (64,'Prescott','Mills','nunc@odio.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (65,'Olympia','Waters','sed@ipsumleo.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (66,'Ingrid','Nichols','nec.ante.Maecenas@SuspendisseeleifendCras.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (67,'Ramona','Beasley','fames@ultrices.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (68,'Rigel','Soto','rutrum.urna@malesuada.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (69,'Dante','Blake','pellentesque.tellus@anteipsum.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (70,'Nero','Rowland','justo.nec@anequeNullam.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (71,'Noelani','Rios','at.pede.Cras@ipsumSuspendisse.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (72,'MacKensie','Ford','interdum@musAenean.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (73,'Kerry','Duke','Etiam@PraesentluctusCurabitur.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (74,'Allistair','Carr','Phasellus@vulputatelacusCras.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (75,'Kane','Whitehead','vel.sapien.imperdiet@commodoauctor.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (76,'Priscilla','Blanchard','et.pede@venenatisamagna.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (77,'Zia','Higgins','non@sitamet.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (78,'Armand','Riggs','mollis.non.cursus@sedpedenec.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (79,'Rinah','Morris','ante.dictum@ut.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (80,'Alexis','Molina','Ut.semper.pretium@vulputate.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (81,'Brian','Webb','ornare.elit@Cras.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (82,'Ross','Fitzpatrick','tempor.est.ac@taciti.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (83,'Gloria','Banks','lectus@eleifend.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (84,'Acton','Mooney','eleifend.nec@variusultricesmauris.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (85,'Eliana','Kemp','et.magnis.dis@Donecelementumlorem.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (86,'Len','Castillo','in.consequat@Quisquefringilla.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (87,'Aaron','Oneill','mauris.sapien@nonante.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (88,'Len','Gilbert','malesuada.vel.venenatis@vel.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (89,'Zephr','Maxwell','Sed@nislQuisque.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (90,'Lani','Logan','Suspendisse@tincidunt.org');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (91,'Gary','Best','vitae.risus@ultricesa.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (92,'Chancellor','Dillon','sed@etnuncQuisque.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (93,'Evangeline','Lang','vestibulum.neque@ipsumac.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (94,'Seth','Harris','posuere@dictumaugue.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (95,'Jaime','Schultz','euismod.et@blanditcongueIn.co.uk');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (96,'Molly','Boyle','Phasellus@in.edu');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (97,'Quin','Ballard','Proin.vel@ridiculusmusDonec.ca');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (98,'Madison','Frank','vitae@quispedePraesent.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (99,'Burke','Romero','magna.Lorem@placerat.com');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (100,'Amal','Johnston','enim@parturientmontesnascetur.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (101,'Quinn','Waters','arcu@mattis.net');
insert into `author` (`id`,`first_name`,`last_name`,`email`) values (102,'Yoshi','Hunt','dictum@ridiculusmusAenean.co.uk');

insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (1,'Spring Boot is cool!','spring-boot-is-cool',@TEASER,@BODY,2,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (2,'Spring Data is cool!','spring-data-is-cool',@TEASER,@BODY,2,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (3,'Felix Muster Blog Post 1','felix-blog-post-1',@TEASER,@BODY,1,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (4,'Felix Muster Blog Post 2','felix-blog-post-2',@TEASER,@BODY,1,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (5,'Felix Muster Blog Post 3','felix-blog-post-3',@TEASER,@BODY,1,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (6,'Refactoring the Spring Data Project','refactoring-spring-data-project',@TEASER,@BODY,2,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (7,'Spring Boot is cool','my-slug-1',@TEASER,@BODY,7,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (8,'Spring Boot is cool','my-slug-2',@TEASER,@BODY,8,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (9,'Spring Boot is cool','my-slug-3',@TEASER,@BODY,9,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (10,'Spring Boot is cool','my-slug-4',@TEASER,@BODY,10,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (11,'Spring Boot is cool','my-slug-5',@TEASER,@BODY,11,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (12,'Spring Boot is cool','my-slug-6',@TEASER,@BODY,12,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (13,'Spring Boot is cool','my-slug-7',@TEASER,@BODY,13,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (14,'Spring Boot is cool','my-slug-8',@TEASER,@BODY,14,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (15,'Spring Boot is cool','my-slug-9',@TEASER,@BODY,15,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (16,'Spring Boot is cool','my-slug-10',@TEASER,@BODY,16,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (17,'Spring Boot is cool','my-slug-11',@TEASER,@BODY,17,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (18,'Spring Boot is cool','my-slug-12',@TEASER,@BODY,18,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (19,'Spring Boot is cool','my-slug-13',@TEASER,@BODY,19,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (20,'Spring Boot is cool','my-slug-14',@TEASER,@BODY,20,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (21,'Spring Boot is cool','my-slug-15',@TEASER,@BODY,21,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (22,'Spring Boot is cool','my-slug-16',@TEASER,@BODY,22,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (23,'Spring Boot is cool','my-slug-17',@TEASER,@BODY,23,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (24,'Spring Boot is cool','my-slug-18',@TEASER,@BODY,24,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (25,'Spring Boot is cool','my-slug-19',@TEASER,@BODY,25,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (26,'Spring Boot is cool','my-slug-20',@TEASER,@BODY,26,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (27,'Spring Boot is cool','my-slug-21',@TEASER,@BODY,27,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (28,'Spring Boot is cool','my-slug-22',@TEASER,@BODY,28,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (29,'Spring Boot is cool','my-slug-23',@TEASER,@BODY,29,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (30,'Spring Boot is cool','my-slug-24',@TEASER,@BODY,30,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (31,'Spring Boot is cool','my-slug-25',@TEASER,@BODY,31,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (32,'Spring Boot is cool','my-slug-26',@TEASER,@BODY,32,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (33,'Spring Boot is cool','my-slug-27',@TEASER,@BODY,33,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (34,'Spring Boot is cool','my-slug-28',@TEASER,@BODY,34,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (35,'Spring Boot is cool','my-slug-29',@TEASER,@BODY,35,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (36,'Spring Boot is cool','my-slug-30',@TEASER,@BODY,36,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (37,'Spring Boot is cool','my-slug-31',@TEASER,@BODY,37,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (38,'Spring Boot is cool','my-slug-32',@TEASER,@BODY,38,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (39,'Spring Boot is cool','my-slug-33',@TEASER,@BODY,39,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (40,'Spring Boot is cool','my-slug-34',@TEASER,@BODY,40,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (41,'Spring Boot is cool','my-slug-35',@TEASER,@BODY,41,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (42,'Spring Boot is cool','my-slug-36',@TEASER,@BODY,42,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (43,'Spring Boot is cool','my-slug-37',@TEASER,@BODY,43,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (44,'Spring Boot is cool','my-slug-38',@TEASER,@BODY,44,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (45,'Spring Boot is cool','my-slug-39',@TEASER,@BODY,45,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (46,'Spring Boot is cool','my-slug-40',@TEASER,@BODY,46,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (47,'Spring Boot is cool','my-slug-41',@TEASER,@BODY,47,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (48,'Spring Boot is cool','my-slug-42',@TEASER,@BODY,48,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (49,'Spring Boot is cool','my-slug-43',@TEASER,@BODY,49,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (50,'Spring Boot is cool','my-slug-44',@TEASER,@BODY,50,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (51,'Spring Boot is cool','my-slug-45',@TEASER,@BODY,51,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (52,'Spring Boot is cool','my-slug-46',@TEASER,@BODY,52,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (53,'Spring Boot is cool','my-slug-47',@TEASER,@BODY,53,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (54,'Spring Boot is cool','my-slug-48',@TEASER,@BODY,54,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (55,'Spring Boot is cool','my-slug-49',@TEASER,@BODY,55,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (56,'Spring Boot is cool','my-slug-50',@TEASER,@BODY,56,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (57,'Spring Boot is cool','my-slug-51',@TEASER,@BODY,57,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (58,'Spring Boot is cool','my-slug-52',@TEASER,@BODY,58,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (59,'Spring Boot is cool','my-slug-53',@TEASER,@BODY,59,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (60,'Spring Boot is cool','my-slug-54',@TEASER,@BODY,60,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (61,'Spring Boot is cool','my-slug-55',@TEASER,@BODY,61,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (62,'Spring Boot is cool','my-slug-56',@TEASER,@BODY,62,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (63,'Spring Boot is cool','my-slug-57',@TEASER,@BODY,63,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (64,'Spring Boot is cool','my-slug-58',@TEASER,@BODY,64,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (65,'Spring Boot is cool','my-slug-59',@TEASER,@BODY,65,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (66,'Spring Boot is cool','my-slug-60',@TEASER,@BODY,66,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (67,'Spring Boot is cool','my-slug-61',@TEASER,@BODY,67,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (68,'Spring Boot is cool','my-slug-62',@TEASER,@BODY,68,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (69,'Spring Boot is cool','my-slug-63',@TEASER,@BODY,69,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (70,'Spring Boot is cool','my-slug-64',@TEASER,@BODY,70,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (71,'Spring Boot is cool','my-slug-65',@TEASER,@BODY,71,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (72,'Spring Boot is cool','my-slug-66',@TEASER,@BODY,72,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (73,'Spring Boot is cool','my-slug-67',@TEASER,@BODY,73,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (74,'Spring Boot is cool','my-slug-68',@TEASER,@BODY,74,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (75,'Spring Boot is cool','my-slug-69',@TEASER,@BODY,75,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (76,'Spring Boot is cool','my-slug-70',@TEASER,@BODY,76,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (77,'Spring Boot is cool','my-slug-71',@TEASER,@BODY,77,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (78,'Spring Boot is cool','my-slug-72',@TEASER,@BODY,78,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (79,'Spring Boot is cool','my-slug-73',@TEASER,@BODY,79,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (80,'Spring Boot is cool','my-slug-74',@TEASER,@BODY,80,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (81,'Spring Boot is cool','my-slug-75',@TEASER,@BODY,81,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (82,'Spring Boot is cool','my-slug-76',@TEASER,@BODY,82,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (83,'Spring Boot is cool','my-slug-77',@TEASER,@BODY,83,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (84,'Spring Boot is cool','my-slug-78',@TEASER,@BODY,84,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (85,'Spring Boot is cool','my-slug-79',@TEASER,@BODY,85,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (86,'Spring Boot is cool','my-slug-80',@TEASER,@BODY,86,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (87,'Spring Boot is cool','my-slug-81',@TEASER,@BODY,87,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (88,'Spring Boot is cool','my-slug-82',@TEASER,@BODY,88,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (89,'Spring Boot is cool','my-slug-83',@TEASER,@BODY,89,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (90,'Spring Boot is cool','my-slug-84',@TEASER,@BODY,90,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (91,'Spring Boot is cool','my-slug-85',@TEASER,@BODY,91,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (92,'Spring Boot is cool','my-slug-86',@TEASER,@BODY,92,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (93,'Spring Boot is cool','my-slug-87',@TEASER,@BODY,93,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (94,'Spring Boot is cool','my-slug-88',@TEASER,@BODY,94,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (95,'Spring Boot is cool','my-slug-89',@TEASER,@BODY,95,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (96,'Spring Boot is cool','my-slug-90',@TEASER,@BODY,96,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (97,'Spring Boot is cool','my-slug-91',@TEASER,@BODY,97,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (98,'Spring Boot is cool','my-slug-92',@TEASER,@BODY,98,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (99,'Spring Boot is cool','my-slug-93',@TEASER,@BODY,99,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (100,'Spring Boot is cool','my-slug-94',@TEASER,@BODY,100,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (101,'Spring Boot is cool','my-slug-95',@TEASER,@BODY,101,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (102,'Spring Boot is cool','my-slug-96',@TEASER,@BODY,102,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (103,'Spring Boot is cool','my-slug-97',@TEASER,@BODY,3,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (104,'Spring Boot is cool','my-slug-98',@TEASER,@BODY,4,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (105,'Spring Boot is cool','my-slug-99',@TEASER,@BODY,5,CURRENT_TIMESTAMP);
insert into `post` (`id`,`title`,`slug`,`teaser`,`body`,`author_id`,`posted_on`) values (106,'Spring Boot is cool','my-slug-100',@TEASER,@BODY,6,CURRENT_TIMESTAMP);
