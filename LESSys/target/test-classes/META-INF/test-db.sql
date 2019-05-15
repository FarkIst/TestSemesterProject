-- Subject
insert into test_less.Subject(id, name) values(1, "Maths");
insert into test_less.Subject(id, name) values(2, "Computer Science");
insert into test_less.Subject(id, name) values(3, "German");
insert into test_less.Subject(id, name) values(4, "Spanish");
insert into test_less.Subject(id, name) values(5, "French");
-- Staff
insert into test_less.User(id, type, birthDate, name, staffNo, field, councilMember) values(4444, "NTS", "1981-03-11", "Jim Jones", 555, "Principle", true);
insert into test_less.User(id, type, birthDate, name, staffNo, field, councilMember) values(4445, "NTS", "1988-01-21", "Jim Jimes", 556, "Administration", true);
insert into test_less.User(id, type, birthDate, name, staffNo, field, councilMember) values(4446, "NTS", "1990-12-01", "Annette Andersen", 557, "Administration", true);
insert into test_less.User(id, type, birthDate, name, staffNo, qualifications, councilMember) values(4447, "TS", "1974-03-14", "Personal Jesus", 558, "8 years teaching Maths", true);
insert into test_less.User(id, type, birthDate, name, staffNo, qualifications, councilMember) values(4448, "TS", "1978-02-25", "Mary Jane", 559, "Highschool degree, 2 years internship", false);
insert into test_less.User(id, type, birthDate, name, staffNo, qualifications, councilMember) values(4449, "TS", "1960-11-11", "Honey Jones", 560, "20 years teaching English", false);
-- Students
insert into test_less.User(id, type, birthDate, name) values(4541, "S", "1999-12-24", "Jesper Anders");
insert into test_less.User(id, type, birthDate, name) values(4542, "S", "1998-11-12", "Bjorn Hensen");
insert into test_less.User(id, type, birthDate, name) values(4543, "S", "2001-05-16", "Futte Hansen");
-- Course
insert into test_less.Course(id, name, teachingHours, subject_id) values(7701, "Advanced Maths A", 15, 1);
insert into test_less.Course(id, name, teachingHours, subject_id, teacher_id) values(7702, "Advanced Maths B", 25, 1, 4447);
insert into test_less.Course(id, name, teachingHours, subject_id, teacher_id) values(7703, "Beginner Spanish B", 30, 4, 4449);
insert into test_less.Course(id, name, teachingHours, subject_id) values(7704, "Beginner Spanish B", 35, 4);
insert into test_less.Course(id, name, teachingHours, subject_id) values(7705, "Intermediate French A", 10, 5);
insert into test_less.Course(id, name, teachingHours, subject_id, teacher_id) values(7706, "Beginner German A", 22, 3, 4449);
insert into test_less.Course(id, name, teachingHours, subject_id) values(7707, "Advanced Computer Science", 20, 2);