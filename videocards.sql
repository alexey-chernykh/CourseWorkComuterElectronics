create table `videocards`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    memory_frequency INT NOT NULL,
    core_frequency INT NOT NULL,
    memory_value INT NOT NULL,
    memory_bus INT NOT NULL,
    required_power INT NOT NULL,
    memory_type TEXT NOT NULL,
    interface TEXT NOT NULL,
    connectors TEXT NOT NULL,
    extra_supply TEXT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `videocards` (full_name, company, memory_frequency, core_frequency, memory_value, memory_bus, required_power, memory_type, interface, connectors, extra_supply, rating, price, is_available, image_name) values (
"Asus GeForce RTX 3060 Dual 12GB", "Asus", 15000, 1867, 12, 192, 650, "GDDR6", "PCI-Express x16 4.0", "DisplayPort, HDMI", "8 pin", 9.5, 14300, true, "asusgeforcertx3060dual12gb.webp"
);
select * from `videocards`