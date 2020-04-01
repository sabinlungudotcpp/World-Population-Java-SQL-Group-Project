
# Group Members :family:
> Sabin Constantin Lungu

> Taylor Aidan Courtney

> Jonathan Sung

> Sadeem Rashid

# Purpose of Agile Group Project :runner:
A "virtual company" gave us a long list of requirements to work through regarding the world population and in an Agile Development Environment, our group have to write SQL code embedded in Java by making use of the Java Database Connectivity Driver (JDBC) to solve the requirements given to us and generate different reports for the company. 

# Code Of Conduct :bookmark:

1. All members must attend meetings.
2. Equal contributions to the coursework.
3. No discrimination (racial, religion, gender etc.).
4. Respect and value alternative viewpoints and, seek, accept and offer honest criticisms of work.
5. Be polite to each other.
6. No distractions; all members must be fully focused on work.
7. All members must have the right tools to do the work (e.g. Docker, Travis, IntelliJ).


# Build Statuses of Branches :statue_of_liberty:
- Master Build Status [![Build Status](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project.svg?branch=master)](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project)
- Develop Build Status [![Build Status](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project.svg?branch=develop)](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project)
- License [![LICENSE](https://img.shields.io/github/license/kevin-chalmers/sem.svg?style=flat-square)](https://github.com/kevin-chalmers/sem/blob/master/LICENSE)
- Release [![Build Status](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project.svg?branch=release)](https://travis-ci.com/sabinlungudotcpp/World-Population-Java-SQL-Group-Project)

# Product Backlog :book:
This section will contain a list of requirements that have been put into a product backlog. As a group we are required to write Java code and SQL queries in order to extract the database results for each of the requirements. As a group we are using Travis Continuous Integration which allows us to continuously test and build this project after we make ***Commits*** and ***Pushes*** which are crucial features of Version Control using Git. 

The requirements that we had to write SQL queries for are:

> **1.  All the countries in the world organised by largest population to smallest.**

> **2.  All the countries in a continent organised by largest population to smallest.**

> **3.  All the countries in a region organised by largest population to smallest.**

> **4.  The top N populated countries in the world where N is provided by the user.**

> **5   The top N populated countries in a continent where N is provided by the user.

> **6.  The top N populated countries in a region where N is provided by the user.

> **7.  All the cities in the world organised by largest population to smallest.

> **8.  All the cities in a continent organised by largest population to smallest.

> All the cities in a region organised by largest population to smallest.

> All the cities in a country organised by largest population to smallest.

> All the cities in a district organised by largest population to smallest.

> The top N populated cities in the world where N is provided by the user.

> The top N populated cities in a continent where N is provided by the user.

> The top N populated cities in a region where N is provided by the user.

> The top N populated cities in a country where N is provided by the user.

> The top N populated cities in a district where N is provided by the user.

> All the capital cities in the world organised by largest population to smallest.

> All the capital cities in a continent organised by largest population to smallest.

> All the capital cities in a region organised by largest to smallest.

> The top N populated capital cities in the world where N is provided by the user.

> The top N populated capital cities in a continent where N is provided by the user.

> The top N populated capital cities in a region where N is provided by the user.

> The population of people, people living in cities, and people not living in cities in each continent.

> The population of people, people living in cities, and people not living in cities in each region.

> The population of people, people living in cities, and people not living in cities in each country.

**Additionally, the following information should be accessible to the organisation:**

The population of the world.

The population of a continent.

The population of a region.

The population of a country.

The population of a district.

The population of a city.

Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:

Chinese.
English.
Hindi.
Spanish.
Arabic.
Country Report
A country report requires the following columns:

Code.
Name.
Continent.
Region.
Population.
Capital.
City Report
A city report requires the following columns:

Name.
Country.
District.
Population.
Capital City Report
A capital city report requires the following columns:

Name.
Country.
Population.
Population Report
For the population reports, the following information is requested:

The name of the continent/region/country.
The total population of the continent/region/country.
The total population of the continent/region/country living in cities (including a %).
The total population of the continent/region/country not living in cities (including a %).
