INSERT INTO Country (isocode,name) 
VALUES ('DE','Germany'),
('FR','France'),
('GB','Great Britain'),
('PL','Poland');

INSERT INTO Address (id,street,zip,city) 
VALUES (1,'straße','82256','Fürstenfeldbruck');

INSERT INTO User (firstname,lastname,email,username,password,address_id)
VALUES ('firstname','lastname','e@ma.il','user','$2a$10$dNxUPGiGY0CXpX3eaLqeE.xc1uSRUPIHWrPqOuaucAzCSnHPmZFCm',1);