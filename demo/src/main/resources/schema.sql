
/* Table of Organizations */

CREATE TABLE IF NOT EXISTS organization (
    organization_id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    organization_name        VARCHAR(50),
    organization_fullname    VARCHAR(50),
    version                  INTEGER NOT NULL,
    organization_inn         INTEGER,
    organization_kpp         INTEGER,
    organization_address     VARCHAR(70),
    organization_phone       VARCHAR(20),
    organization_is_active   BOOLEAN
);

/* Table of Offices */

CREATE TABLE IF NOT EXISTS office (
    office_id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    office_org_id      INTEGER ,
    version            INTEGER NOT NULL ,
    office_name        VARCHAR(50) ,
    office_address     VARCHAR(70) ,
    office_phone       VARCHAR(20) ,
    office_is_active   BOOLEAN
);

/* Table of Users */

CREATE TABLE IF NOT EXISTS user (
    user_id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    user_office_id   INTEGER ,
    version          INTEGER NOT NULL,
    user_firstname   VARCHAR(50) ,
    user_secondname  VARCHAR(50) ,
    user_middlename  VARCHAR(50) ,
    user_lastname    VARCHAR(50) ,
    user_position    VARCHAR(50) ,
    user_doc_code    INTEGER ,
    user_doc_name    VARCHAR(50) ,
    user_doc_number  INTEGER ,
    user_doc_date    DATE ,
    user_citizenship_name VARCHAR(50) ,
    user_citizenship_code INTEGER ,
    user_phone       VARCHAR(20) ,
    user_is_identified    BOOLEAN
);

/* Table of Doc */

CREATE TABLE IF NOT EXISTS doc (
    doc_name        VARCHAR(50) NOT NULL,
    version         INTEGER NOT NULL,
    doc_code        INTEGER  PRIMARY KEY
);

/* Table of Countries */

CREATE TABLE IF NOT EXISTS country (
    country_name    VARCHAR(50) NOT NULL,
    version         INTEGER NOT NULL,
    country_code    INTEGER  PRIMARY KEY
);

/* FOREIGN KEY LINKING TABLES & INDEXES */

/* Organization <-> Office */

CREATE INDEX IX_office_organization_Id ON office (office_org_id, version, office_name, office_address, office_phone, office_is_active) ;
ALTER TABLE office ADD FOREIGN KEY (office_org_id) REFERENCES organization (organization_id);

/* Office <-> User */

CREATE INDEX IX_user_office_Id ON user (user_office_id, version, user_firstname, user_secondname, user_middlename, user_lastname, user_position, user_doc_code, user_doc_name, user_doc_number, user_doc_date, user_citizenship_name, user_citizenship_code, user_phone, user_is_identified) ;
ALTER TABLE user ADD FOREIGN KEY (user_office_id) REFERENCES office (office_id);

/* User -> Doc */

CREATE INDEX IX_user_doc ON doc (doc_code);
ALTER TABLE user ADD FOREIGN KEY (user_doc_code) REFERENCES doc (doc_code);

/* User -> Country */

CREATE INDEX IX_user_country ON country (country_code);
ALTER TABLE user ADD FOREIGN KEY (user_citizenship_code) REFERENCES country (country_code);


-- /* Organization <-> Office */
--
-- CREATE TABLE IF NOT EXISTS Organization_Office (
--     fk_organization_id     INTEGER  ,
--     fk_office_org_id       INTEGER  ,
--     PRIMARY KEY (fk_organization_id, fk_office_org_id)
-- );
--
-- /* Office <-> User */
--
-- CREATE TABLE IF NOT EXISTS Office_User (
--     fk_office_id           INTEGER  ,
--     fk_user_office_id      INTEGER  ,
--     PRIMARY KEY (fk_office_id, fk_user_office_id)
-- );
--
-- /* Organization <- Office */
--
-- CREATE INDEX IX_Organization_Office_Id ON Organization_Office (fk_office_org_id);
-- ALTER TABLE Organization_Office ADD FOREIGN KEY (fk_office_org_id) REFERENCES Organization (organization_id);
--
-- /* Organization -> Office */
--
-- CREATE INDEX IX_Office_Organization_Id ON Organization_Office (fk_organization_id);
-- ALTER TABLE Organization_Office ADD FOREIGN KEY (fk_organization_id) REFERENCES Office (office_org_id); /* error 1822 */
--
-- /* Office -> User */
--
-- CREATE INDEX IX_Office_User_Id ON Office_User (fk_user_office_id);
-- ALTER TABLE Office_User ADD FOREIGN KEY (fk_user_office_id) REFERENCES Office (office_id);
--
-- /* Office <- User */
--
-- CREATE INDEX IX_User_Office_Id ON Office_User (fk_office_id);
-- ALTER TABLE Office_User ADD FOREIGN KEY (fk_office_id) REFERENCES User (user_office_id); /* error 1822 */
-- --
-- /* User -> Doc */
--
-- CREATE INDEX IX_User_Doc ON Doc (doc_name);
-- ALTER TABLE User ADD FOREIGN KEY (user_doc_name) REFERENCES Doc (doc_name);
--
-- /* User -> Country */
--
-- CREATE INDEX IX_User_Country ON Country (country_name);
-- ALTER TABLE User ADD FOREIGN KEY (user_citizenship_name) REFERENCES Country (country_name);

/*CREATE TABLE IF NOT EXISTS Person (
    oId         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER ,
    first_name VARCHAR(50) ,
    age        INTEGER
);

CREATE TABLE IF NOT EXISTS House (
    oId         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER ,
    address    VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Person_House (
    person_id   INTEGER  ,
    house_id    INTEGER  ,

    PRIMARY KEY (person_id, house_id)
);

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House ADD FOREIGN KEY (house_id) REFERENCES House(oId);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House ADD FOREIGN KEY (person_id) REFERENCES Person(oId);*/