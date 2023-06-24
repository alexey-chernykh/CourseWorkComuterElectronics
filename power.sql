create table `power`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    full_name TEXT NOT NULL,
    company TEXT NOT NULL,
    capacity INT NOT NULL,
    power_connectors TEXT NOT NULL,
    sata_connectors INT NOT NULL,
    rating FLOAT NOT NULL,
    price INT NOT NULL,
    is_available BOOL NOT NULL,
    image_name TEXT NOT NULL
);
insert into `power` (full_name, company, capacity, power_connectors, sata_connectors, rating, price, is_available, image_name) values (
"be quiet! Straight Power 11 850W", "be quiet!", 850, "cpu: 1x4+4pin 1x8pin; video: 4x(6+2pin)", 11, 9, 6700, true, "bequietstraightpower11850w.webp"
);
select * from `power`