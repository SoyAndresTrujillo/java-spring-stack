When create the project structure, go the root main file and use the following command:
```
mkdir -p domain/{dto,repository,service} persistance/{entity,crud} web/controller
```

# Deploy API from bash
This script will deploy the API with the production profile, the ```-Dspring.profiles.active=pdn``` is optional, if not provided, the default profile will be used (dev or pdn).
```
java -jar -Dspring.profiles.active=pdn build/libs/anjotics-1.0.jar
```