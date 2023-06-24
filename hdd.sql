create table `hdd`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    memory_value INT NOT NULL,
    form_factor TEXT NOT NULL,
    interface TEXT NOT NULL,
    spindle_speed INT NOT NULL,
    buffer_value INT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `hdd` (full_name, company, memory_value, form_factor, interface, spindle_speed, buffer_value, rating, price, is_available, image_name) values (
"Toshiba P300 1TB", "Toshiba", 1024, "2.5 inches", "SATAIII", 7200, 64, 8, 1300, true, "toshibap3001tb.webp"
);
select * from `hdd`