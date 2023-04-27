# Backend service for retrieving universities and country by IP address

This is a backend service that allows users to retrieve information about countries and universities. The service provides two REST endpoints:

http://localhost:8080/ip/xxx.xxx.xxx.xxx: Returns details about the country assigned to the provided IP address.
http://localhost:8080/university?country=xxx: Returns a list of universities in the specified country.

# Usage
To use this service, send an HTTP GET request to one of the endpoints listed above. The response will be a JSON object with the requested information.

# Audit Records
Every time a country is retrieved using the /ip/{ipAddress} endpoint, an audit record is created in the database with the following fields:
IP address, country, city and loc.

# How to use
To use this application, follow these steps:

1. Install Docker on your machine.
2. Clone this repository to your local machine.
3. Build the Docker image by running the following command in the project directory:
   `docker build -t eurofins-genomics .`
4. Run the Docker container by running the following command in the project directory:
   `./run.sh`
   Note: make sure you have executable permissions for the run.sh script, if not, run the following command to grant the executable permission:
   `chmod +x run.sh`
   Access the application by going to http://localhost:8080.

# Endpoints
This application has two REST endpoints:

GET /ip: Retrieves details about the country based on the provided IP address.

### Parameters:
ip: The IP address to lookup.
### Response:
ip: The IP address to lookup

city: The name of the city.

region: The name of the region.

country: The name of the country.

loc: The latitude and longitude of the IP address.

org: The name of organization.

timezone: The timezone of this location.

Example request: http://localhost:8080/ip/123.123.123.123

GET /universities: Retrieves a list of universities based on the provided country name.

### Parameters:
country: The name of the country to search for.

Response:
An array of universities.
Example request: http://localhost:8080/university?country=Latvia

# Useful links
Country details by IP can be retrieved using this public endpoint: https://ipinfo.io/80.233.249.21/geo

List of universities can be retrieved using this public endpoint: http://universities.hipolabs.com/search?country=Latvia

# Dockerfile and run.sh
This application uses a Dockerfile to build a Docker image of the application.
The run.sh script is used to automate the process of starting the container with the appropriate configuration.
Please make sure you have Docker installed on your machine before using the Dockerfile and run.sh script.