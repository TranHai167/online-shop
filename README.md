This is back-end server for online-shop web application.

For front-end package, visit: https://github.com/TranHai167/online-shop-front  

* Use **[Maven](maven.md)** for dependencies management.
* **[JWT](jwt.md)** to prevent CORS, CSRF attack. Which is cookie forgery. 
* Mail and Otp server to confirm client's data.
* Spring security, (a built-in dependency of Springboot framework) to block unexpected requests.
* Git action checks code before creating merge request.
* Use Jenkins for automatically building and pushing to private repo for prod env.

### Project structure: 

![Project structure](/images/pj_structure.png)

### Request flow from client:

![Project structure](/images/request_direction.png)

### Database design:

![Project structure](/images/db_design.png)


### When operations in UI web application worked as expected ([*see here*](https://github.com/TranHai167/online-shop-front )), let containerize the code and push it to docker hub repository.

#### Config workflow as we want.
![workflow-config](/images/workflow_config.png)


#### GitHub workflow success.
![Workflow](/images/workflow_success.png)

To build Docker image for our web application, we need Dockerfile and specify the path of it in workflow.

#### Push to docker hub.
![Workflow](/images/container-in-dockerhub.png)
