-- Normal User User Table
-- password is from 1 to 9
insert into users  (id, birth_city, birth_date, code, email, job_title, name, password, phone, status, contracts_types_id, department_id, direct_manager_id, role_id, is_deleted)
values (2, 'Giza', '2000-11-11', '12345678', 'hanwar@gmail.com', 'Software Engineer', 'Hisham Normal',
        '$2a$10$K3jU8Y0kAigwjPlJvR7.K.G85OEhkqg2Nsnf0mVEqui9fxfjYCC.m', '01149027532', true, 1, 2, 1, 2, false);