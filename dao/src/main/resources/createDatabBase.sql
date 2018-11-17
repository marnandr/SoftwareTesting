CREATE IF NOT EXISTS database Softest;
CREATE USER IF NOT EXISTS Client identified by 'Client';
GRANT ALL IF EXISTS ON Softest.* to 'Client';
grant all on Softest.* to 'Client'@'localhost' identified by 'Client' with grant option;