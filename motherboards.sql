create table `motherboards`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    socket_name TEXT NOT NULL,
    chipset_name TEXT NOT NULL,
    ram_support TEXT NOT NULL,
    ram_slots INT NOT NULL,
    form_factor TEXT NOT NULL,
    m2_count INT NOT NULL,
    power_connector TEXT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `motherboards` (full_name, company, socket_name, chipset_name, ram_support, ram_slots, form_factor, m2_count, power_connector, rating, price, is_available, image_name) values (
"Asus TUF Gaming B550M-Plus", "Asus", "AM4", "AMD B550", "4 x DDR4 DIMM", 4, "MicroATX", 2, "1 x 24-pin; 1 x 8-pin 12В", 9, 4600, true, "asustufgamingb550mplus.webp"
);
insert into `motherboards` (full_name, company, socket_name, chipset_name, ram_support, ram_slots, form_factor, m2_count, power_connector, rating, price, is_available, image_name) values (
"Asus TUF Gaming B550M-Plus", "Asus", "AM4", "AMD B550", "4 x DDR4 DIMM", 4, "MicroATX", 2, "1 x 24-pin; 1 x 8-pin 12В", 9, 4600, true, "asustufgamingb550mplus.webp"
);
insert into `motherboards` (full_name, company, socket_name, chipset_name, ram_support, ram_slots, form_factor, m2_count, power_connector, rating, price, is_available, image_name) values (
"Asus TUF Gaming B550M-Plus", "Asus", "AM4", "AMD B550", "4 x DDR4 DIMM", 4, "MicroATX", 2, "1 x 24-pin; 1 x 8-pin 12В", 9, 4600, true, "asustufgamingb550mplus.webp"
);
insert into `motherboards` (full_name, company, socket_name, chipset_name, ram_support, ram_slots, form_factor, m2_count, power_connector, rating, price, is_available, image_name) values (
"Gigabyte B550M Aorus Elite", "Gigabyte", "AM4", "AMD B550", "4 x DDR4 DIMM", 4, "MicroATX", 2, "1 x 24-pin ATX; 1 x 8-pin ATX 12 В", 8, 3700, true, "gigabyteb550maoruselite.webp"
);
select * from `motherboards`
