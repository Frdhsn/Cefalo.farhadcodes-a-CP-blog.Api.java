# Welcome to Cefalo.farhadcodes-a-CP-blog.Api.java backend!

# About

This repository serves as a backend for my farhadcodes-a-CP-blog applcation which is a fullstack training/learning project at CEFALO. You can find the frontend here https://github.com/Frdhsn/farhadcodes-frontend

# Description

farhadcodes-a-CP-blog is a simple fullstack web blog app where a user can sign up with email, username, name and password. A user can post a blog with a valid title, and content. Users can also edit or delete their respective stories while logged in. All registered users can read other users' blogs.

# Dependencies

<ol>
<li>Java 19</li>
<li>Gradle</li>
<li>Sprint Boot 3.x</li>
<li>Spring Security</li>
<li>JPA (Java Persistence API)</li>
<li>MySQL Connector</li>
<li>JSON Web Token (JJWT)</li>
</ol>

# Getting Started

To get the app up and running on your local machine, follow these steps:

- Clone the repository to your local machine. Using `git clone https://github.com/Frdhsn/Cefalo.farhadcodes-a-CP-blog.Api.java.git`
- Change into the directory of the cloned repository using `cd Cefalo.farhadcodes-a-CP-blog.Api.java`
- Build the project with Gradle. Using `gradle build`
- Run the application. Using `gradle bootRun`
  <br><br>The app will be running at http://localhost:8080/.

# Api Documentation

- [User Related](/documentation/userApiDocumentation.md)
- [Story Related](/documentation/storyApiDocumentation.md)
