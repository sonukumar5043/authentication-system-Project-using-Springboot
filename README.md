login authentication from backend using concept of springbot
for main folder->
Login/src/main/java/com/RegisationProject/Login
This project is a Login Authentication System built using Spring Boot. It demonstrates how to handle user registration, login, update, and account deletion using RESTful APIs, connected to a MySQL database. The backend is structured using a clean service-controller-repository pattern.

🛠️ Tech Stack
Spring Boot

Spring Data JPA

MySQL

RESTful APIs

Lombok (optional)

Postman 

📌 Features Implemented
✅ Register User: Add a new user with email and password

✅ Login Authentication: Check if email and password match

✅ Fetch All Users

✅ Update Account by email and password

✅ Delete Account by email

✅ CORS Enabled for cross-origin frontend support

📫 API Endpoints

| Method   | Endpoint                                    | Description           |
| -------- | ------------------------------------------- | --------------------- |
| `POST`   | `/api/v1/user/save`                         | Save new user         |
| `GET`    | `/api/v1/user/get`                          | Get list of all users |
| `GET`    | `/api/v1/user/login?email=...&password=...` | Login verification    |
| `PUT`    | `/api/v1/user/update/{email}/{password}`    | Update user account   |
| `DELETE` | `/api/v1/user/delAccount/{email}`           | Delete user by email  |

🔌 Sample Controller Code

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private ServicesLayer layer;

    @PostMapping("/save")
    public String save(@RequestBody UserModel model) {
        layer.add(model);
        return "Saved successfully";
    }

    @GetMapping("/get")
    public List<UserModel> getAllUsers() {
        return layer.get();
    }

    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return layer.check(email, password);
    }

    @PutMapping("/update/{email}/{password}")
    public String updateUser(@PathVariable String email,
                             @PathVariable String password,
                             @RequestBody UserModel entity) {
        return layer.update(email, password, entity);
    }

    @DeleteMapping("/delAccount/{email}")
    public String delete(@PathVariable String email) {
        return layer.delete(email);
    }
}






