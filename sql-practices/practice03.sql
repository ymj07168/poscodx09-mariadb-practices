-- 테이블 조인(JOIN) SQL 문제입니다.

-- 현재 to_date='9999-01-01';

-- 문제 1. 
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.
select emp.emp_no, first_name, salary
from employees as emp, salaries as sal
where emp.emp_no = sal.emp_no
and sal.to_date = '9999-01-01'
order by salary desc;

-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.
select employees.emp_no, first_name, title
from employees, titles
where employees.emp_no = titles.emp_no
order by first_name asc;

-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요.
select employees.emp_no, first_name, dept_name
from employees, dept_emp, departments
where employees.emp_no = dept_emp.emp_no and dept_emp.dept_no = departments.dept_no
order by first_name asc;

-- 문제4.
-- 현재 근무중인 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.
select emp_no, first_name, salary, title, dept_name
where emp.emp_no = sal.emp_no
and sal.to_date = '9999-01-01'
order by first_name asc;

-- 문제5.
-- 'Technique Leader'의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요.
-- (현재 'Technique Leader'의 직책으로 근무하는 사원은 고려하지 않습니다.)
select employees.emp_no, first_name
from employees, titles
where employees.emp_no = titles.emp_no
and title = 'Technique Leader';

-- 문제6.
-- 직원 이름(last_name) 중에서 S로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.
select last_name, dept_name, title
from employees, dept_emp, departments, titles
where employees.emp_no = titles.emp_no
and employees.emp_no = dept_emp.emp_no and dept_emp.dept_no = departments.dept_no
and last_name like 'S%';

-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40,000 이상인 사원들의 사번, 이름, 급여 그리고 타이틀을 급여가 큰 순서대로 출력하세요.
select employees.emp_no, first_name, salary, title
from employees, salaries, titles
where employees.emp_no = salaries.emp_no and employees.emp_no = titles.emp_no
and titles.title = 'Engineer'
and salary >= 40000
order by salary desc;

-- 문제8.
-- 현재, 평균급여가 50,000이 넘는 직책을 직책과 평균급여을 평균급여가 큰 순서대로 출력하세요.
select title, avg(salary)
from salaries
join titles on salaries.emp_no = titles.emp_no
where salaries.to_date = '9999-01-01'
group by title
having avg(salary) > 50000
order by avg(salary) desc;

-- 문제9.
-- 현재, 부서별 평균급여을 평균급여가 큰 순서대로 부서명과 평균연봉을 출력 하세요.
select dept_name, avg(salary)
from departments
join dept_emp on dept_emp.dept_no = departments.dept_no
join employees on dept_emp.emp_no = employees.emp_no
join salaries on employees.emp_no = salaries.emp_no
where dept_emp.to_date = '9999-01-01'
group by dept_name
order by avg(salary) desc;

-- 문제10.
-- 현재, 직책별 평균급여를 평균급여가 큰 직책 순서대로 직책명과 그 평균연봉을 출력 하세요.
select title, avg(salary)
from salaries
join titles on salaries.emp_no = titles.emp_no
where salaries.to_date = '9999-01-01'
group by title
having avg(salary) > 50000
order by avg(salary) desc;