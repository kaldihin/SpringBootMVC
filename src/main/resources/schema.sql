
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
    o_id INTEGER ,
    version            INTEGER NOT NULL ,
    office_name        VARCHAR(50) ,
    office_address     VARCHAR(70) ,
    office_phone       VARCHAR(20) ,
    office_is_active   BOOLEAN,
    FOREIGN KEY (office_org_id) REFERENCES organization (organization_id)
);

/* Table of Doc */

CREATE TABLE IF NOT EXISTS doc (
    doc_id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    doc_name        VARCHAR(50) NOT NULL,
    version         INTEGER NOT NULL,
    doc_code        INTEGER UNIQUE
);

/* Table of Countries */

CREATE TABLE IF NOT EXISTS country (
    country_id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    country_name    VARCHAR(50) NOT NULL,
    version         INTEGER NOT NULL,
    country_code    INTEGER UNIQUE
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
    country_code INTEGER ,
    code INTEGER ,
    of_id INTEGER ,
    user_phone       VARCHAR(20) ,
    user_is_identified    BOOLEAN,
    FOREIGN KEY (user_office_id) REFERENCES office(office_id),
    FOREIGN KEY (user_doc_code) REFERENCES doc(doc_code),
    FOREIGN KEY (user_citizenship_code) REFERENCES country(country_code)
);

/* FOREIGN KEY LINKING TABLES & INDEXES */

/* Organization <-> Office */

CREATE INDEX IX_office_organization_Id ON office (office_org_id, office_name, office_address, office_phone, office_is_active) ;

/* Office <-> User */

CREATE INDEX IX_user_office_Id ON user (user_office_id, version, user_firstname, user_secondname, user_middlename, user_lastname,
user_position, user_doc_code, user_doc_name, user_doc_number, user_doc_date, user_citizenship_name, user_citizenship_code, user_phone, user_is_identified) ;

/* User -> Doc */

CREATE INDEX IX_user_doc ON doc (doc_code);

/* User -> Country */

CREATE INDEX IX_user_country ON country (country_code);