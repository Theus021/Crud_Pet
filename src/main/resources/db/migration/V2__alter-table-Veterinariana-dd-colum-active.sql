alter table Veterinarians add active tinyint;
update Veterinarians set active = 1;
