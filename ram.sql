create table `ram`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    ram_value INT NOT NULL,
    ram_frequency INT NOT NULL,
    supply_voltage FLOAT NOT NULL,
    cooling TEXT NOT NULL,
    memory_type TEXT NOT NULL,
    timings TEXT NOT NULL,
    slats_count INT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `ram` (full_name, company, ram_value, ram_frequency, supply_voltage, cooling, memory_type, timings, slats_count, rating, price, is_available, image_name) values (
"Kingston Fury DDR4-3200 16GB Beast Black", "Kingston", 16, 3200, 1.35, "Low profile asymmetrical heat spreader", "DDR4 SDRAM", "CL16-18-18", 2, 9.8, 1800, true, "kingstonfuryddr4320016gbbeastblack.webp"
);
select * from `ram`