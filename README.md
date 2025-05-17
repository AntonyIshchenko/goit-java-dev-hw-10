# Tomcat Servlet Project

## Setup Instructions
Download and install Tomcat on your computer. You can download it from here: https://tomcat.apache.org/download-90.cgi

## Task #1 - Create a servlet that returns an HTML page with the current UTC time
Write a `TimeServlet`. It should handle a `GET` request at the `/time` address and return an HTML page with the current time in the `UTC` timezone.

The page should display the time (accurate to seconds) and the timezone. For example, `2022-01-05 12:05:01 UTC`.

Since this is a `GET` request, you can test it in a browser. Run the program and verify that it works correctly and opens in the browser. You should enter an address like `http://localhost:8080/time` in your browser and get a result.

## Task #2 - Extend the servlet to accept a timezone
Extend the servlet from the previous task to accept a `timezone` query parameter and return the time in the specified timezone.

For example, if you open a URL like `http://localhost:8080/time?timezone=UTC+2` in your browser, you should get a result like `2022-01-05 12:05:01 UTC+2`.

If the `timezone` parameter is not provided, the time should be returned in `UTC`.

## Task #3 - Add a WebFilter for invalid timezones
The user may provide an invalid timezone in the timezone parameter. In this case, return a web page with the content `Invalid timezone` and HTTP response code `400`.

To accomplish this, create a web filter called `TimezoneValidateFilter` that intercepts the `/time` request, checks for the presence of the `timezone` parameter, and validates it.

For timezone validation, you can use the `TimeZone` class. Javadoc: https://docs.oracle.com/javase/7/docs/api/java/util/TimeZone.html