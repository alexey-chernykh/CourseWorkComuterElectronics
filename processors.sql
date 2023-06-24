create table `processors`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    socket_name TEXT NOT NULL,
    cores INT NOT NULL,
    threads INT NOT NULL,
    frequency INT NOT NULL,
    max_frequency INT NOT NULL,
    tech_process INT NOT NULL,
    tdp INT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `processors` (full_name, company, socket_name, cores, threads, frequency, max_frequency, tech_process, tdp, rating, price, is_available, image_name) values (
"AMD Ryzen 5 5600", "AMD", "AM4", 6, 12, 3500, 4400, 7, 65, 9.9, 5300, true, "amdryzen55600.webp"
);
insert into `processors` (full_name, company, socket_name, cores, threads, frequency, max_frequency, tech_process, tdp, rating, price, is_available, image_name) values (
"Intel Core i5-10400F", "INTEL", "1200", 6, 12, 2900, 4300, 14, 65, 9.9, 3900, true, "intelcorei510400f.webp"
);
insert into `processors` (full_name, company, socket_name, cores, threads, frequency, max_frequency, tech_process, tdp, rating, price, is_available, image_name) values (
"AMD Ryzen 9 7900X3D", "AMD", "AM5", 12, 24, 4400, 5600, 5, 120, 10, 21000, true, "amdryzen97900x3d.webp"
);
select * from `processors`


