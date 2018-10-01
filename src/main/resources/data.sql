/* Organization table data */

INSERT INTO organization(organization_name, organization_fullname, version, organization_inn, organization_kpp,
                          organization_address, organization_phone, organization_is_active) VALUES ('Bad Organization', 'Организация имени Ивана Нерусского',
                                                                                                     0, 564573865, 433475475, 'ул.Цюрупы, 16', '89235445754', TRUE);

INSERT INTO organization(organization_name, organization_fullname, version, organization_inn, organization_kpp,
                          organization_address, organization_phone, organization_is_active) VALUES ('Плохая организация', 'Организация имени Ивана Русского',
                                                                                                     0, 164178866, 433475475, 'ул.Ленина, 67', '89235775757', FALSE);

INSERT INTO organization(organization_name, organization_fullname, version, organization_inn, organization_kpp,
                          organization_address, organization_phone, organization_is_active) VALUES ('Новая организация', 'Организация имени Ивана Иванова',
                                                                                                     0, 564578865, 433471471, 'ул.Дзержинского, 11', '89435445754', TRUE);

/* Office table data */

INSERT INTO office (office_org_id, version, office_name, office_address, office_phone, office_is_active) VALUES (1,
                                            0, 'Офис реконструкции разума', 'ул.Пешеходов, 13', '89275468934', true);

INSERT INTO office (office_org_id, version, office_name, office_address, office_phone, office_is_active) VALUES (2,
                                                                                                      0, 'Офис реконструкции мебели', 'ул.Металлургов, 43', '89275413931', false);

INSERT INTO office (office_org_id, version, office_name, office_address, office_phone, office_is_active) VALUES (1,
                                                                                                      0, 'Офис создания ИИ', 'ул.Космонавтов, 6', '89175418914', false);

/* Doc table data */

INSERT INTO doc (doc_name, VERSION, doc_code) VALUES ('Свидетельство о рождении', 0, 3);

INSERT INTO doc (doc_name, VERSION, doc_code) VALUES ('Удостоверение беженца', 0, 13);

INSERT INTO doc (doc_name, VERSION, doc_code) VALUES ('Паспорт гражданина Российской Федерации', 0, 21);

/* Countries table data */

INSERT INTO country (country_name, VERSION, country_code) VALUES ('Россия', 0, 643);

INSERT INTO country (country_name, VERSION, country_code) VALUES ('Сент-Китс и Невис', 0, 659);

INSERT INTO country (country_name, VERSION, country_code) VALUES ('Объединенные Арабские Эмираты', 0, 784);

/* User table data */

INSERT INTO user (user_office_id, version, user_firstname, user_secondname, user_middlename, user_lastname, user_position, user_doc_code,
                   user_doc_name, user_doc_number, user_doc_date, user_citizenship_name, user_citizenship_code, user_phone, user_is_identified) VALUES (1, 0,
                                                                                                                                                         'Фёдор', 'Смолов', 'ПолуСмолов', 'Федя', 'Гипнотизер', 3, 'FS67', 76, '2013-05-21', 'Russian', 643, '89035428910', true);

INSERT INTO user (user_office_id, version, user_firstname, user_secondname, user_middlename, user_lastname, user_position, user_doc_code,
                   user_doc_name, user_doc_number, user_doc_date, user_citizenship_name, user_citizenship_code, user_phone, user_is_identified) VALUES (1, 0,
                                                                                                                                                         'Алексей', 'Смирнов', 'ПолуСмирнов', 'Лёша', 'Адепт', 21, 'AS21', 12, '2010-10-01', 'Belarus', 659, '89995391230', false);

INSERT INTO user (user_office_id, version, user_firstname, user_secondname, user_middlename, user_lastname, user_position, user_doc_code,
                   user_doc_name, user_doc_number, user_doc_date, user_citizenship_name, user_citizenship_code, user_phone, user_is_identified) VALUES (2, 0,
                                                                                                                                                         'Игорь', 'Трунов', 'ПолуТрунов', 'Иго', 'Грузчик', 21, 'IT3', 30, '2015-07-29', 'Czech', 784, '8573542310', false);


/* Examples

INSERT INTO House (oId, version, address) VALUES (1, 0, 'ул.Цюрупы, 16');

INSERT INTO House (oId, version, address) VALUES (2, 0, 'ул.Лунина, 7');

INSERT INTO Person (oId, version, first_name, age) VALUES (1, 0, 'Пётр', 20);

INSERT INTO Person (oId, version, first_name, age) VALUES (2, 0, 'John', 25);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 1);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 2); */