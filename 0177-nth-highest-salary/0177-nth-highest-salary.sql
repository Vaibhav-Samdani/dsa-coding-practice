CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set n = N-1;
  RETURN (
      
      select Distinct salary 
      from Employee
      ORDER BY salary DESC
      limit 1 OFFSET n

  );
END