BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "monitores" (
	"id"	INTEGER,
	"ancho"	INTEGER,
	"alto"	INTEGER,
	"diagonal"	INTEGER,
	"color"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "monitores" VALUES (1,640,480,14,'Negro');
INSERT INTO "monitores" VALUES (2,800,600,15,'Blanco');
INSERT INTO "monitores" VALUES (3,1024,768,17,'Gris');
INSERT INTO "monitores" VALUES (4,1280,720,15,'Negro');
INSERT INTO "monitores" VALUES (5,1400,1200,20,'Gris');
INSERT INTO "monitores" VALUES (6,2000,1000,30,'Rosa');
INSERT INTO "monitores" VALUES (9,1920,1080,21,'Gris');
INSERT INTO "monitores" VALUES (10,1920,1080,21,'Gris');
COMMIT;
