SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX DEPT_LOCATION_IX ON DEPARTMENTS;
DROP INDEX EMP_DEPARTMENT_IX ON EMPLOYEES;
DROP INDEX EMP_JOB_IX ON EMPLOYEES;
DROP INDEX EMP_MANAGER_IX ON EMPLOYEES;
DROP INDEX EMP_NAME_IX ON EMPLOYEES;
DROP INDEX JHIST_DEPARTMENT_IX ON JOB_HISTORY;
DROP INDEX JHIST_EMPLOYEE_IX ON JOB_HISTORY;
DROP INDEX JHIST_JOB_IX ON JOB_HISTORY;
DROP INDEX LOC_CITY_IX ON LOCATIONS;
DROP INDEX LOC_COUNTRY_IX ON LOCATIONS;
DROP INDEX LOC_STATE_PROVINCE_IX ON LOCATIONS;



/* Drop Views */

DROP VIEW HR.EMP_DETAILS_VIEW;



/* Drop Triggers */

DROP TRIGGER SECURE_EMPLOYEES;
DROP TRIGGER UPDATE_JOB_HISTORY;



/* Drop Tables */

DROP TABLE JOB_HISTORY;
DROP TABLE EMPLOYEES;
DROP TABLE DEPARTMENTS;
DROP TABLE LOCATIONS;
DROP TABLE COUNTRIES;
DROP TABLE JOBS;
DROP TABLE REGIONS;




/* Create Tables */

-- country table. Contains 25 rows. References with locations table.
CREATE TABLE COUNTRIES
(
	-- Primary key of countries table.
	COUNTRY_ID char(2) NOT NULL COMMENT 'Primary key of countries table.',
	-- Country name
	COUNTRY_NAME varchar(40) COMMENT 'Country name',
	-- Region ID for the country. Foreign key to region_id column in the departments table.
	REGION_ID decimal COMMENT 'Region ID for the country. Foreign key to region_id column in the departments table.',
	CONSTRAINT COUNTRY_C_ID_PK PRIMARY KEY (COUNTRY_ID)
) COMMENT = 'country table. Contains 25 rows. References with locations t';


-- Departments table that shows details of departments where employees
-- work. Contains 27 rows; references with locations, employees, and job_history tables.
CREATE TABLE DEPARTMENTS
(
	-- Primary key column of departments table.
	DEPARTMENT_ID decimal(4,0) NOT NULL COMMENT 'Primary key column of departments table.',
	-- A not null column that shows name of a department. Administration,
	-- Marketing, Purchasing, Human Resources, Shipping, IT, Executive, Public
	-- Relations, Sales, Finance, and Accounting. 
	DEPARTMENT_NAME varchar(30) NOT NULL COMMENT 'A not null column that shows name of a department. Administration,
Marketing, Purchasing, Human Resources, Shipping, IT, Executive, Public
Relations, Sales, Finance, and Accounting. ',
	-- Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.
	MANAGER_ID decimal(6,0) COMMENT 'Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.',
	-- Location id where a department is located. Foreign key to location_id column of locations table.
	LOCATION_ID decimal(4,0) COMMENT 'Location id where a department is located. Foreign key to location_id column of locations table.',
	CONSTRAINT DEPT_ID_PK PRIMARY KEY (DEPARTMENT_ID)
) COMMENT = 'Departments table that shows details of departments where em';


-- employees table. Contains 107 rows. References with departments,
-- jobs, job_history tables. Contains a self reference.
CREATE TABLE EMPLOYEES
(
	-- Primary key of employees table.
	EMPLOYEE_ID decimal(6,0) NOT NULL COMMENT 'Primary key of employees table.',
	-- First name of the employee. A not null column.
	FIRST_NAME varchar(20) COMMENT 'First name of the employee. A not null column.',
	-- Last name of the employee. A not null column.
	LAST_NAME varchar(25) NOT NULL COMMENT 'Last name of the employee. A not null column.',
	-- Email id of the employee
	EMAIL varchar(25) NOT NULL UNIQUE COMMENT 'Email id of the employee',
	-- Phone number of the employee; includes country code and area code
	PHONE_NUMBER varchar(20) COMMENT 'Phone number of the employee; includes country code and area code',
	-- Date when the employee started on this job. A not null column.
	HIRE_DATE date NOT NULL COMMENT 'Date when the employee started on this job. A not null column.',
	-- Current job of the employee; foreign key to job_id column of the
	-- jobs table. A not null column.
	JOB_ID varchar(10) NOT NULL COMMENT 'Current job of the employee; foreign key to job_id column of the
jobs table. A not null column.',
	-- Monthly salary of the employee. Must be greater
	-- than zero (enforced by constraint emp_salary_min)
	SALARY decimal(8,2) COMMENT 'Monthly salary of the employee. Must be greater
than zero (enforced by constraint emp_salary_min)',
	-- Commission percentage of the employee; Only employees in sales
	-- department elgible for commission percentage
	COMMISSION_PCT decimal(2,2) COMMENT 'Commission percentage of the employee; Only employees in sales
department elgible for commission percentage',
	-- Manager id of the employee; has same domain as manager_id in
	-- departments table. Foreign key to employee_id column of employees table.
	-- (useful for reflexive joins and CONNECT BY query)
	MANAGER_ID decimal(6,0) COMMENT 'Manager id of the employee; has same domain as manager_id in
departments table. Foreign key to employee_id column of employees table.
(useful for reflexive joins and CONNECT BY query)',
	-- Department id where employee works; foreign key to department_id
	-- column of the departments table
	DEPARTMENT_ID decimal(4,0) COMMENT 'Department id where employee works; foreign key to department_id
column of the departments table',
	CONSTRAINT EMP_EMP_ID_PK PRIMARY KEY (EMPLOYEE_ID)
) COMMENT = 'employees table. Contains 107 rows. References with departme';


-- Table that stores job history of the employees. If an employee
-- changes departments within the job or changes jobs within the department,
-- new rows get inserted into this table with old job information of the
-- employee. Contains a complex primary key: employee_id+start_date.
-- Contains 25 rows. References with jobs, employees, and departments tables.
CREATE TABLE JOB_HISTORY
(
	-- A not null column in the complex primary key employee_id+start_date.
	-- Foreign key to employee_id column of the employee table
	EMPLOYEE_ID decimal(6,0) NOT NULL COMMENT 'A not null column in the complex primary key employee_id+start_date.
Foreign key to employee_id column of the employee table',
	-- A not null column in the complex primary key employee_id+start_date.
	-- Must be less than the end_date of the job_history table. (enforced by
	-- constraint jhist_date_interval)
	START_DATE date NOT NULL COMMENT 'A not null column in the complex primary key employee_id+start_date.
Must be less than the end_date of the job_history table. (enforced by
constraint jhist_date_interval)',
	-- Last day of the employee in this job role. A not null column. Must be
	-- greater than the start_date of the job_history table.
	-- (enforced by constraint jhist_date_interval)
	END_DATE date NOT NULL COMMENT 'Last day of the employee in this job role. A not null column. Must be
greater than the start_date of the job_history table.
(enforced by constraint jhist_date_interval)',
	-- Job role in which the employee worked in the past; foreign key to
	-- job_id column in the jobs table. A not null column.
	JOB_ID varchar(10) NOT NULL COMMENT 'Job role in which the employee worked in the past; foreign key to
job_id column in the jobs table. A not null column.',
	-- Department id in which the employee worked in the past; foreign key to deparment_id column in the departments table
	DEPARTMENT_ID decimal(4,0) COMMENT 'Department id in which the employee worked in the past; foreign key to deparment_id column in the departments table',
	CONSTRAINT JHIST_EMP_ID_ST_DATE_PK PRIMARY KEY (EMPLOYEE_ID, START_DATE)
) COMMENT = 'Table that stores job history of the employees. If an employ';


-- jobs table with job titles and salary ranges. Contains 19 rows.
-- References with employees and job_history table.
CREATE TABLE JOBS
(
	-- Primary key of jobs table.
	JOB_ID varchar(10) NOT NULL COMMENT 'Primary key of jobs table.',
	-- A not null column that shows job title, e.g. AD_VP, FI_ACCOUNTANT
	JOB_TITLE varchar(35) NOT NULL COMMENT 'A not null column that shows job title, e.g. AD_VP, FI_ACCOUNTANT',
	-- Minimum salary for a job title.
	MIN_SALARY decimal(6,0) COMMENT 'Minimum salary for a job title.',
	-- Maximum salary for a job title
	MAX_SALARY decimal(6,0) COMMENT 'Maximum salary for a job title',
	CONSTRAINT JOB_ID_PK PRIMARY KEY (JOB_ID)
) COMMENT = 'jobs table with job titles and salary ranges. Contains 19 ro';


-- Locations table that contains specific address of a specific office,
-- warehouse, and/or production site of a company. Does not store addresses /
-- locations of customers. Contains 23 rows; references with the
-- departments and countries tables. 
CREATE TABLE LOCATIONS
(
	-- Primary key of locations table
	LOCATION_ID decimal(4,0) NOT NULL COMMENT 'Primary key of locations table',
	-- Street address of an office, warehouse, or production site of a company.
	-- Contains building number and street name
	STREET_ADDRESS varchar(40) COMMENT 'Street address of an office, warehouse, or production site of a company.
Contains building number and street name',
	-- Postal code of the location of an office, warehouse, or production site
	-- of a company. 
	POSTAL_CODE varchar(12) COMMENT 'Postal code of the location of an office, warehouse, or production site
of a company. ',
	-- A not null column that shows city where an office, warehouse, or
	-- production site of a company is located. 
	CITY varchar(30) NOT NULL COMMENT 'A not null column that shows city where an office, warehouse, or
production site of a company is located. ',
	-- State or Province where an office, warehouse, or production site of a
	-- company is located.
	STATE_PROVINCE varchar(25) COMMENT 'State or Province where an office, warehouse, or production site of a
company is located.',
	-- Country where an office, warehouse, or production site of a company is
	-- located. Foreign key to country_id column of the countries table.
	COUNTRY_ID char(2) COMMENT 'Country where an office, warehouse, or production site of a company is
located. Foreign key to country_id column of the countries table.',
	CONSTRAINT LOC_ID_PK PRIMARY KEY (LOCATION_ID)
) COMMENT = 'Locations table that contains specific address of a specific';


CREATE TABLE REGIONS
(
	REGION_ID decimal NOT NULL,
	REGION_NAME varchar(25),
	CONSTRAINT REG_ID_PK PRIMARY KEY (REGION_ID)
);



/* Create Foreign Keys */

ALTER TABLE LOCATIONS
	ADD CONSTRAINT LOC_C_ID_FK FOREIGN KEY (COUNTRY_ID)
	REFERENCES COUNTRIES (COUNTRY_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE EMPLOYEES
	ADD CONSTRAINT EMP_DEPT_FK FOREIGN KEY (DEPARTMENT_ID)
	REFERENCES DEPARTMENTS (DEPARTMENT_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE JOB_HISTORY
	ADD CONSTRAINT JHIST_DEPT_FK FOREIGN KEY (DEPARTMENT_ID)
	REFERENCES DEPARTMENTS (DEPARTMENT_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE DEPARTMENTS
	ADD CONSTRAINT DEPT_MGR_FK FOREIGN KEY (MANAGER_ID)
	REFERENCES EMPLOYEES (EMPLOYEE_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE EMPLOYEES
	ADD CONSTRAINT EMP_MANAGER_FK FOREIGN KEY (MANAGER_ID)
	REFERENCES EMPLOYEES (EMPLOYEE_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE JOB_HISTORY
	ADD CONSTRAINT JHIST_EMP_FK FOREIGN KEY (EMPLOYEE_ID)
	REFERENCES EMPLOYEES (EMPLOYEE_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE EMPLOYEES
	ADD CONSTRAINT EMP_JOB_FK FOREIGN KEY (JOB_ID)
	REFERENCES JOBS (JOB_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE JOB_HISTORY
	ADD CONSTRAINT JHIST_JOB_FK FOREIGN KEY (JOB_ID)
	REFERENCES JOBS (JOB_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE DEPARTMENTS
	ADD CONSTRAINT DEPT_LOC_FK FOREIGN KEY (LOCATION_ID)
	REFERENCES LOCATIONS (LOCATION_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;


ALTER TABLE COUNTRIES
	ADD CONSTRAINT COUNTR_REG_FK FOREIGN KEY (REGION_ID)
	REFERENCES REGIONS (REGION_ID)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
;



/* Create Triggers */

-- secure_employees
--   BEFORE INSERT OR UPDATE OR DELETE ON employees
-- 
CREATE TRIGGER HR.SECURE_EMPLOYEES BEGIN
  secure_dml;
END secure_employees;;
-- update_job_history
--   AFTER UPDATE OF job_id, department_id ON employees
--   FOR EACH ROW
-- 
CREATE TRIGGER HR.UPDATE_JOB_HISTORY BEGIN
  add_job_history(:old.employee_id, :old.hire_date, sysdate,
                  :old.job_id, :old.department_id);
END;;



/* Create Views */

CREATE VIEW HR.EMP_DETAILS_VIEW AS SELECT
  e.employee_id,
  e.job_id,
  e.manager_id,
  e.department_id,
  d.location_id,
  l.country_id,
  e.first_name,
  e.last_name,
  e.salary,
  e.commission_pct,
  d.department_name,
  j.job_title,
  l.city,
  l.state_province,
  c.country_name,
  r.region_name
FROM
  employees e,
  departments d,
  jobs j,
  locations l,
  countries c,
  regions r
WHERE e.department_id = d.department_id
  AND d.location_id = l.location_id
  AND l.country_id = c.country_id
  AND c.region_id = r.region_id
  AND j.job_id = e.job_id
WITH READ ONLY;



/* Create Indexes */

CREATE INDEX DEPT_LOCATION_IX ON DEPARTMENTS (LOCATION_ID ASC);
CREATE INDEX EMP_DEPARTMENT_IX ON EMPLOYEES (DEPARTMENT_ID ASC);
CREATE INDEX EMP_JOB_IX ON EMPLOYEES (JOB_ID ASC);
CREATE INDEX EMP_MANAGER_IX ON EMPLOYEES (MANAGER_ID ASC);
CREATE INDEX EMP_NAME_IX ON EMPLOYEES (LAST_NAME ASC, FIRST_NAME ASC);
CREATE INDEX JHIST_DEPARTMENT_IX ON JOB_HISTORY (DEPARTMENT_ID ASC);
CREATE INDEX JHIST_EMPLOYEE_IX ON JOB_HISTORY (EMPLOYEE_ID ASC);
CREATE INDEX JHIST_JOB_IX ON JOB_HISTORY (JOB_ID ASC);
CREATE INDEX LOC_CITY_IX ON LOCATIONS (CITY ASC);
CREATE INDEX LOC_COUNTRY_IX ON LOCATIONS (COUNTRY_ID ASC);
CREATE INDEX LOC_STATE_PROVINCE_IX ON LOCATIONS (STATE_PROVINCE ASC);



