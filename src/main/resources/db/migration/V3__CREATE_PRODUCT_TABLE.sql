CREATE TABLE  PRODUCT
(
    ID BIGINT GENERATED  BY DEFAULT AS IDENTITY,
    NAME VARCHAR(250),
    CATEGORY_ID BIGINT REFERENCES CATEGORY(ID),
    COMPANY_ID BIGINT NOT NULL REFERENCES COMPANY_INFO(ID),
    PRIMARY KEY (ID)
);