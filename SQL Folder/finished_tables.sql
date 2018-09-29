DROP TABLE ALGPARAMETERS;

--this is for password stuff, looks awesome.
CREATE TABLE ALGPARAMETERS
(
  NAME   VARCHAR2(100 BYTE),
  VALUE  NVARCHAR2(100),
  CONSTRAINT PK_ALG PRIMARY KEY(NAME)
);
INSERT INTO ALGPARAMETERS
   SELECT 'key' NAME,
          RAWTOHEX ('c26146b7e677fbd970fc5a9e') VALUE
     FROM DUAL
   UNION
   SELECT 'iv' NAME, RAWTOHEX ('3d35c510') VALUE FROM DUAL;
COMMIT;
SELECT * FROM ALGPARAMETERS;

CREATE OR REPLACE FUNCTION F_ENCRYPT (p_input VARCHAR2)
   RETURN VARCHAR2
AS
   v_encrypted_raw     RAW (2000);
   v_key               RAW (320);
   v_encryption_type   PLS_INTEGER
      :=   DBMS_CRYPTO.DES_CBC_PKCS5;
   v_iv                RAW (320);
BEGIN
   SELECT VALUE
     INTO v_key
     FROM algparameters
    WHERE name = 'key';
   SELECT VALUE
     INTO v_iv
     FROM algparameters
    WHERE name = 'iv';
   v_encrypted_raw :=
      DBMS_CRYPTO.encrypt (src   => UTL_I18N.STRING_TO_RAW (p_input, 'AL32UTF8'),
                           typ   => v_encryption_type,
                           key   => v_key,
                           iv    => v_iv);
   RETURN UTL_RAW.CAST_TO_VARCHAR2 (UTL_ENCODE.base64_encode (v_encrypted_raw));
END;
/

CREATE OR REPLACE FUNCTION F_DECRYPT (p_input VARCHAR2)
   RETURN VARCHAR2
AS
   v_decrypted_raw     RAW (2000);
   v_key               RAW (320);
   v_encryption_type   PLS_INTEGER := DBMS_CRYPTO.DES_CBC_PKCS5;
   v_iv                RAW (320);
BEGIN
   SELECT VALUE
     INTO v_key
     FROM algparameters
    WHERE name = 'key';
   SELECT VALUE
     INTO v_iv
     FROM algparameters
    WHERE name = 'iv';
   v_decrypted_raw :=
      DBMS_CRYPTO.DECRYPT (
         src   => UTL_ENCODE.base64_decode (UTL_RAW.CAST_TO_RAW (p_input)),
         typ   => v_encryption_type,
         key   => v_key,
         iv    => v_iv);
   RETURN UTL_I18N.RAW_TO_CHAR (v_decrypted_raw, 'AL32UTF8');
END;
/
