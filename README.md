## simple-web-app

The purpose of this application is to provide a simple container
image that can be referenced in courses, without relying on
images outside the Tanzu Learning team.
It is built using the new native compilation features of Spring
Boot, so start-up times are very small.

It provides the following endpoints:

* `/` - just responds with `OK`
* `/hello` - responds with a canned greeting message, which
  can be over-ridden using the `GREETING_MESSAGE` environment
  variable.
* `/echo` - a GET to this with a query-parameter of `message`
  echoes back the supplied message
* `/echo` - a POST to this echoes back the body contents
* `/actuator` - exposes the full range of actuator endpoints
