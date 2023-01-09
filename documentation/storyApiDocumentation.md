## Story Api Docs

###

- **Without any authorization**

  - Get All Stories : `GET /stories`

    - Request Header
          Accept : application/json
    - Valid Response

          Status: 200 OK

      JSON Response

      ```json
      {
        "status": "success",
        "message": "Stories fetched successfully",
        "data": []
      }
      ```

  - Get A Single Story : `GET /stories/:storyId`
    - Request Header
          Accept : application/json
    - Valid Response
          Status: 200 OK
      JSON Response
      ```json
      {}
      ```

###

- **Authorized And Performed By User Himself** ( _jwt cookie must be included with request_ )

  - Post A Story : `POST /stories`

    - Request Header
          Accept : application/json
    - Request Body

      ```json
      {}
      ```

    - Valid Response
          Status: 201 Created
      JSON Response
      ```json
      {}
      ```
    - Valid Request Field Requirements:
      - title must be between 1 to 50 chars
      - description must be between 1 to 10000 chars

  &nbsp;

  - Update A Story : `PUT /stories/:storyId`

    - Request Header
          Accept : application/json or application/xml
    - Request Body

      ```json
      {}
      ```

    - Valid Response

      Status: 200 OK

      ```json
      {}
      ```

    - Valid Request Field Requirements:
      - title must be between 1 to 50 chars
      - description must be between 1 to 10000 chars

  &nbsp;

  - Delete A Story : `DELETE /stories/:storyId`

    - Valid Response

      Status: 204 No Content
