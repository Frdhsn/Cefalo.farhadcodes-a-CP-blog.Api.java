## User Api Docs

###

- **Without any authorization** ( must be logged out )

  - Sign Up : `POST /users/signup`

    - Request Header
           Accept : application/json
    - Request Body
      ```json
      {
        "name": "Md. Tarek",
        "email": "acquatarek@gmail.com",
        "password": "1234678"
      }
      ```
    - Valid Request Field Requirements:
      - username can't be null
      - name can't be null
      - email can't be null
      - password must be between 8 to 15 chars

    &nbsp;

    - Valid Response

          Status: 201 Created

      JSON Response

      ```json
      {}
      ```

  - Login User : `POST /users/login`

    - Request Body
      ```json
      {
        "email": "acquatarek@gmail.com",
        "password": "12345678"
      }
      ```
    - Valid Request Field Requirements: - username can't be null - password must be between 8 to 15 chars  
      &nbsp;
    - Valid Response ( returns with a jwt cookie )

          Status: 200 OK

      JSON Response

      ```json
      {}
      ```
