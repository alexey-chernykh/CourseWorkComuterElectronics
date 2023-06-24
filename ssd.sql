create table `ssd`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    memory_value INT NOT NULL,
    read_speed INT NOT NULL,
    write_speed INT NOT NULL,
    form_factor TEXT NOT NULL,
    interface TEXT NOT NULL,
    cells_type TEXT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `ssd` (full_name, company, memory_value, read_speed, write_speed, form_factor, interface, cells_type, rating, price, is_available, image_name) values (
"Kingston SSDNow A400 480GB", "Kingston", 480, 500, 450, "2.5 inches", "SATAIII", "3D V-NAND", 9, 1100, true, "kingstonssdnowa400480gb.webp"
);
select * from `ssd`