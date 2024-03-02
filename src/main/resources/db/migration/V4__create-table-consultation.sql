create table consultations(
  id bigint not null auto_increment,
    veterinarian_id bigint not null,
    tutor_id bigint not null,
    consultation datetime not null,

    primary key(id),
    constraint fk_consultations_veterinarian_id foreign key(veterinarian_id) references veterinarians(id),
    constraint fk_consultations_tutor_id foreign key(tutor_id) references tutors(id)
);