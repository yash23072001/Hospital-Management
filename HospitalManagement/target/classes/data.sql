INSERT INTO patient (name, gender, birth_date, email, blood_group)
VALUES
     ('Yash Paliwal', 'MALE', '2001-07-23', 'YashPaliwal@email.com', 'B_POSITIVE'),
     ('SS Rajamouli', 'MALE', '1965-08-12', 'Rajamouli@email.com', 'A_POSITIVE'),
     ('Christropher Nolan', 'MALE', '1970-09-14', 'Christropher@email.com', 'A_POSITIVE'),
     ('Kabir Singh', 'MALE', '1988-11-19', 'Wannawao@email.com', 'O_POSITIVE');

INSERT INTO doctor (name, specialization, email)
VALUES
     ('Dr Munna Bhai MBBS', 'Cardiology', 'MunnaBhai@email.com'),
     ('Dr Rakesh Mehta', 'Dermatology', 'Rakesh.Mehta@email.com'),
     ('Dr Arjun Nair', 'Orthopedic', 'Arjun123@email.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
     ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
     ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
     ('2025-07-03 09:45:00', 'Knee Pain', 1, 1),
     ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
     ('2025-07-05 16:15:00', 'Consultation', 1, 2);
