CREATE TABLE medicine
(
    id             INT          NOT NULL PRIMARY KEY,
    MEDICINE_NAME  VARCHAR(45)  NOT NULL,
    chemicals      VARCHAR(191) NOT NULL,
    DATE_OF_EXPIRY DATE         NOT NULL,
    STOCK_COUNT    INT          NOT NULL
);

CREATE TABLE ailment
(
    id           INT         NOT NULL PRIMARY KEY,
    AILMENT_NAME VARCHAR(45) NOT NULL
);

CREATE TABLE MEDICINE_AILMENT_MAPPING
(
    medicine_id INT NOT NULL,
    ailment_id  INT NOT NULL,
    CONSTRAINT FK_MAPPING_AILMENT_ID
        FOREIGN KEY (ailment_id)
            REFERENCES ailment (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION,
    CONSTRAINT FK_AMPPING_MEDICINE_ID
        FOREIGN KEY (medicine_id)
            REFERENCES medicine (id)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);

