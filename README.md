# Spring Security project practice 01
this is to test the spring security for JWT with XML configuration

To invoke the jwt auth generation code 

need to call the below - rest API - POST
http://localhost:8080/SpringSecurity_practice01/api/auth/login
with raw body having a json object containing user context
{
	"username":"username",
	"password":"password"
}

in response you should get two tokens as under
{
  "accesstoken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkdW1teSIsInNjb3BlcyI6WyJ1c2VyIl0sImV4cFdhcm5UaW1lIjoxLCJpc3MiOiJodHRwOi8vZ29vZ2xlLmNvbSIsImlhdCI6MTUwMjgyNzUwMiwiZXhwIjoxNTAyODI3NTYyfQ.o2ri4y-bkZ8ne1juFCPa2qvLTXChMBMqd8UF1xumehHzzad2g_5U-76rmB4PVwWxdcGmzi1JInB4ToWCoq4T9Q",
  "refreshtoken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkdW1teSIsInNjb3BlcyI6WyJST0xFX1JFRlJFU0hfVE9LRU4iXSwiaXNzIjoiaHR0cDovL2dvb2dsZS5jb20iLCJqdGkiOiIxM2EyZDRlOC1jZDc2LTRkOTEtYWNkMy1lNDNhMDRiZGJmZmYiLCJpYXQiOjE1MDI4Mjc1MDMsImV4cCI6MTUwMjgyNzc0M30.dvtUeFed_eq6knG8RgAK5yZf4j9j-H1cAS-cIUTc8YLCWq_qBTqvt6JLiZdHPqz-_uYbEdd0rU9DCi5sdUzYmQ"
}


To refresh need to call the below - rest API - GETT
http://localhost:8080/SpringSecurity_practice01/api/auth/token
with header containing
X-Authorization: Bearer ${refreshToken}

The response would be new access token to be used to call secured rest end points
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkdW1teSIsInNjb3BlcyI6WyJ1c2VyIl0sImV4cFdhcm5UaW1lIjoxLCJpc3MiOiJodHRwOi8vZ29vZ2xlLmNvbSIsImlhdCI6MTUwMjg1Mjg3MSwiZXhwIjoxNTAyODUyOTMxfQ.kKruI5QWvSedc2arECBHy_wzfSWWxEUY1_LndS2uD9guuQescPF3tolfVz77J9obw9cMNcH9YTdO1PBs7-6CcQ"
}


To access a secured resource by JWToken
call GET API
http://localhost:8080/SpringSecurity_practice01/api/auth/getMessage
with header:
X-Authorization: Bearer ${accessToken}

if successfully validated
[
  "1",
  "2"
]


IN case token has expired - the below response would be received
{
  "status": 401,
  "message": "JWT Token expired",
  "errorCode": 11,
  "timestamp": 1502852774878
}


 