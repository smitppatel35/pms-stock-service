INSERT INTO ailment
VALUES ('1', 'Orthopadic');
INSERT INTO ailment
VALUES ('2', 'General');
INSERT INTO ailment
VALUES ('3', 'Neurologist');

INSERT INTO medicine
VALUES ('1', 'DOLO-650', 'paracetamol', '2022-1-14', '2000');
INSERT INTO medicine
VALUES ('2', 'Ecosprin 75mg ', 'Aspirin, acetyl  acid', '2022-1-14', '2000');
INSERT INTO medicine
VALUES ('3', 'Pan 40mg', 'Pantoprazole', '2022-1-14', '100');
INSERT INTO medicine
VALUES ('4', 'Supradyn Multivitamin Tablets', 'vitamin b12, vitamin A, vitamin C', '2022-1-14', '20000');

insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('1', '1');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('2', '2');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('3', '3');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('1', '4');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('2', '1');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('3', '1');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('1', '3');
insert into MEDICINE_AILMENT_MAPPING (AILMENT_ID, MEDICINE_ID)
VALUES ('2', '3');