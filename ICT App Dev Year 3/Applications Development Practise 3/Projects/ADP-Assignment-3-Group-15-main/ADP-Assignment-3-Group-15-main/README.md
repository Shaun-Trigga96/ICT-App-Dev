# Computer Lab E-Management Application (LEMA)

### ADP3 Group 15

### Problem Statement
Group 15 has been hired by a local college in Cape Town called TechStart, to develop a Computer Lab Booking Application.
TechStart has 831 students (thus far)and, a software solution is needed to manage how students are seated in computer
labs according to national Covid-19 regulations. The Dean of TechStart wants to ensure that students who are not able
to continue their education remotely still have access to technical resources as clients of the college. Therefore, the
Computer Lab Booking Application will enable TechStart to manage normal college services according to national Covid-19
regulations.

The application should allow students to book a seat in a computer lab between Mondays and Fridays from 8am to 4pm.
The system should only allow registered students to book a lab seat and should record the student numbers of each
student that uses a specific computer station. That is to say, when a booking is made for a specific computer the
following student details are stored: Student Number, Student Full Name, Cellphone Number and Student Email.
The application also keeps track of all available computer labs, their seating totals, their available seats, their
building location, and their room number.

Additionally, but not limited to, the application keeps track of bookings. Each booking has a booking number, a student
number, a date, a time start and time end, a building location, and a room number. A student may only book one seat per
day. A computer seat is released from its reservation after the booking time expires. When a computer station’s booking
time has not expired, it has a status of OCCUPIED. After the computer’s booking time expires, it has a status of
UNOCCUPIED.

The application developmental structure will be classified into three recommended layers:
* the Presentation layer,
* the Service layer, and
* the data storage layer called the Depot.

### Project information
Project is created with the following:
* Maven
* JDK version 16
* JUnit5 version 5.7.1
* Spring Framework
* MySQL database