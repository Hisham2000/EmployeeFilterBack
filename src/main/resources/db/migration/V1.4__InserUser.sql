-- Direct Manager User Table
-- password is from 1 to 9
insert into users  (id, birth_city, birth_date, code, email, job_title, name, password, phone, status, contracts_types_id, department_id, direct_manager_id, role_id)
values (1, 'Cairo', '2000-10-10', '12345678', 'hishamanwar72@gmail.com', 'Software Engineer', 'Hisham Anwar',
        '$2a$10$K3jU8Y0kAigwjPlJvR7.K.G85OEhkqg2Nsnf0mVEqui9fxfjYCC.m', '01149027532', true, 1, 1, null, 1);