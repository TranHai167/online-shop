This is back-end server for online-shop web application.

For front-end package, visit: https://github.com/TranHai167/online-shop-front  

* Use **[Maven](maven.md)** for dependencies management.
* **[JWT](jwt.md)** to prevent CORS, CSRF attack. Which is cookie forgery. 
* Mail and Otp server to confirm client's data.
* Spring security, (a built-in dependency of Springboot framework) to block unexpected requests.
* Git action checks code before creating merge request.
* Use Jenkins for automatically building and pushing to private repo for prod env.

Project structure: 

![Project structure](/images/pj_structure.png)

Request flow:

![Project structure](/images/request_direction.png)

