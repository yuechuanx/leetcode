# Write your MySQL query statement below
SELECT Person.FirstName, Person.LastName, Address.City, Address.State from Person LEFT JOIN Address ON Person.PersonId = Address.PersonId
