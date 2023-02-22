## simple-web-app

The purpose of this application is to provide a simple container
image that can be referenced in courses, without relying on
images outside the Tanzu Learning team.
It is built using the new native compilation features of Spring
Boot, so start-up times are very small.

It provides the following endpoints:

* `/` - just responds with `OK`, but can be over-ridden using
  the `OK_MESSAGE` environment variable.
* `/echo` - a GET to this with a query-parameter of `message`
  echoes back the supplied message
* `/echo` - a POST to this echoes back the body contents
* `/env` - responds with a JSON map of current environment variable settings
* `/hello` - responds with a canned greeting message, which
  can be over-ridden using the `HELLO_MESSAGE` environment
  variable.
* `/status/<CODE>` - response with a status of the given code
  value, and matching message.

In addition:

* `/actuator` - exposes the full range of actuator endpoints
* Liveness and readiness endpoints are also exposed on `/livez`
  and `/readyz`, respectively.